package com.bjst.dgt.third.yifu;


import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.dao.InvestorPositionDetailMapper;
import com.bjst.dgt.dao.InvestorPositionMapper;
import com.bjst.dgt.dao.TradeMapper;
import com.bjst.dgt.model.InvestorPosition;
import com.bjst.dgt.model.InvestorPositionDetail;
import com.bjst.dgt.model.Trade;
import com.bjst.dgt.model.TradeClient;
import com.bjst.dgt.service.RedisService;
import com.bjst.dgt.third.yifu.JNA.TradeApi;
import com.bjst.dgt.third.yifu.struct.*;
import com.sun.jna.Native;
import lombok.Setter;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class TradeAPI {
	private  String name;//userID
	private  String pwd; // user password
	private  String brokerID;//经纪公司代码
	private  String instrumentID="a1809";//合约

	private  String orderSysID="3418";//测试报单编号
	private  String exchangeID="DCE";//测试交易所代码

	private boolean systemStarted = false;
	private int orderRef = 0;

	private Random random = new Random();
	private int requestID = random.nextInt();
	private Map<String, Object> requestIDManager = new HashMap<>();

	private String tcpUrl; // tcp 连接url
	private Result insertOrderResult;
	private static final int MAX_WAIT_TIMES = 3; // 最多等待次数

	@Setter
	private WeakReference<TradeClient> tradeClientWeakReference;

	private TradeApi instance;
	private long handle;

	@Setter
	private TradeMapper tradeMapper;
	@Setter
	private RedisService redisService;
	@Setter
	private InvestorPositionMapper investorPositionMapper;
	@Setter
	private InvestorPositionDetailMapper investorPositionDetailMapper;

	public TradeAPI(String userId, String password, String brokerID, String tcpUrl) {
		this.name = userId;
		this.pwd = password;
		this.brokerID = brokerID;
		this.tcpUrl = tcpUrl;

		String path = System.getProperty("java.home");
		String systemType = System.getProperty("os.name");
		if (systemType.toLowerCase().indexOf("win") != -1){
			instance = (TradeApi) Native.loadLibrary(path + File.separator +"bin"+ File.separator+"EFThostTradeApi_C.dll", TradeApi.class);
		} else {
			instance = (TradeApi) Native.loadLibrary(path + File.separator +"bin"+ File.separator+"libEFThostTradeApi_C.so", TradeApi.class);
		}
		System.out.println(path);

		handle = instance.CreateHandle("");
	}
	

	public static void setBytesData(byte[] data, String value) {
		int dataLen = data.length;
		//data = value.getBytes();
		int dLen = 0;//data.length;
		while (dLen < dataLen) {
			if (dLen < value.length()) {
				data[dLen] = value.getBytes()[dLen];
			} else {
				data[dLen] = '\0';
			}
			dLen++;
		}
	}
	public static String ByteToString(byte[] bytes)
	{
	    StringBuilder strBuilder = new StringBuilder();
	    for (int i = 0; i <bytes.length ; i++) {
	        if (bytes[i]!=0){
	            strBuilder.append((char)bytes[i]);
	        }else {
	            break;
	        }
	    }
	    return strBuilder.toString();
	}

	TradeApi.cbOnFrontConnected fOnFrontConnected = new TradeApi.cbOnFrontConnected() {
		///当客户端与交易后台建立起通信连接时（还未登录前），该方法被调用。
		public void OnFrontConnected() {
			System.out.println("===================建立连接====================");
			System.out.println("OnFrontConnected");
			
			CThostFtdcReqUserLoginField.ByReference pReqUserLoginField = new CThostFtdcReqUserLoginField.ByReference();

			setBytesData(pReqUserLoginField.BrokerID, brokerID);
			setBytesData(pReqUserLoginField.UserID, name);
			setBytesData(pReqUserLoginField.Password, pwd);
			setBytesData(pReqUserLoginField.UserProductInfo, " ");
			int reqUserLogin = instance.ReqUserLogin(handle, pReqUserLoginField, random.nextInt());
		}
	};
	TradeApi.cbOnFrontDisconnected fOnFrontDisconnected = new TradeApi.cbOnFrontDisconnected() {
		///当客户端与交易后台通信连接断开时，该方法被调用。当发生这个情况后，API会自动重新连接，客户端可不做处理。
		public void OnFrontDisconnected(int nReason) {
			System.out.println("OnFrontDisconnected"+"     "+nReason);
			
		}
	};
	
	
	TradeApi.cbOnRspUserLogin fOnRspUserLogin = new TradeApi.cbOnRspUserLogin() {
		///登录请求响应
		public void OnRspUserLogin(CThostFtdcRspUserLoginField.ByReference pRspUserLogin, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {

			if(pRspInfo != null && pRspInfo.ErrorID != 0){
				try {
					System.out.println("登录失败   ErrorID:" + pRspInfo.ErrorID + "   ErrorMsg:" + new String(pRspInfo.ErrorMsg,"GBK"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else
			{
				systemStarted = true;
				
				System.out.println("===================登录成功====================" + ByteToString(pRspUserLogin.BrokerID));
				System.out.println("UserID:" + ByteToString(pRspUserLogin.UserID));
				// 登录成功将其加入管理器
				tradeClientWeakReference.get().put(ByteToString(pRspUserLogin.UserID), TradeAPI.this);
				orderRef = bytesToInt(pRspUserLogin.MaxOrderRef, 0);
				
			 	CThostFtdcQryInvestorPositionDetailField.ByReference positionDetail  =new CThostFtdcQryInvestorPositionDetailField.ByReference();
			 	setBytesData(positionDetail.BrokerID, brokerID);
				setBytesData(positionDetail.InstrumentID, instrumentID);
				setBytesData(positionDetail.InvestorID, name);

				
				//确认结算单 
				CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm = new CThostFtdcSettlementInfoConfirmField.ByReference();
//				int infoConfirm = instance.ReqSettlementInfoConfirm(handle,pSettlementInfoConfirm,++nRequestID);
				int infoConfirm = instance.ReqSettlementInfoConfirm(handle,pSettlementInfoConfirm,nRequestID);
				System.out.println("###确认结算单 : " + infoConfirm);
			}
		}
	};

	TradeApi.cbOnHeartBeatWarning fOnHeartBeatWarning = new TradeApi.cbOnHeartBeatWarning() {
		///心跳超时警告。当长时间未收到报文时，该方法被调用。
		///@param nTimeLapse 距离上次接收报文的时间
		public void OnHeartBeatWarning(int nTimeLapse) {
			
			System.err.println(nTimeLapse);
		};
	};
	
	TradeApi.cbOnRspAuthenticate fOnRspAuthenticate = new TradeApi.cbOnRspAuthenticate() {
		///客户端认证响应
		public void OnRspAuthenticate(CThostFtdcRspAuthenticateField.ByReference pRspAuthenticateField, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			byte[] userID = pRspAuthenticateField.UserID;
			System.err.println(new String(userID));
			
		};
	};

	TradeApi.cbOnRspUserLogout fOnRspUserLogout = new TradeApi.cbOnRspUserLogout() {
		///登出请求响应
		public void OnRspUserLogout(CThostFtdcUserLogoutField.ByReference pUserLogout, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.err.println("============ 退出登录   ==============");
			try {
				// 退出后清理交易实例
				tradeClientWeakReference.get().remove(ByteToString(pUserLogout.UserID));
				System.out.println("ErrorID:" + pRspInfo.ErrorID);
				System.out.println("ErrorMsg:" + new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		};
	};

	TradeApi.cbOnRspUserPasswordUpdate fOnRspUserPasswordUpdate = new TradeApi.cbOnRspUserPasswordUpdate() {
		///用户口令更新请求响应
		public void OnRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField.ByReference pUserPasswordUpdate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 用户口令更新请求响应   ==============");
			try {
				System.out.println("ErrorID:" + pRspInfo.ErrorID);
				System.out.println("ErrorMsg:" + new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		};
	};

	TradeApi.cbOnRspTradingAccountPasswordUpdate fOnRspTradingAccountPasswordUpdate = new TradeApi.cbOnRspTradingAccountPasswordUpdate() {
		///资金账户口令更新请求响应
		public void OnRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField.ByReference pTradingAccountPasswordUpdate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspOrderInsert fOnRspOrderInsert = new TradeApi.cbOnRspOrderInsert() {
		///报单录入请求响应
		public void OnRspOrderInsert(CThostFtdcInputOrderField.ByReference pInputOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 报单录入请求响应   ==============");
			// 用户报单后，如果正确根本不会“马上收到报单响应 OnRspOrderInsert”，只有报单被 CTP 拒绝才会收到
			try {
				System.out.println("ErrorID:" + pRspInfo.ErrorID);
				System.out.println("ErrorMsg:" + new String(pRspInfo.ErrorMsg,"GBK"));
				if(pRspInfo.ErrorID != 0 ){
					if (requestIDManager.containsKey(String.valueOf(nRequestID))) {
						Trade trade = (Trade)requestIDManager.get(String.valueOf(nRequestID));
						tradeMapper.delete(trade);
						requestIDManager.remove(String.valueOf(nRequestID));
					}
					insertOrderResult = ResultGenerator.genFailResult( new String(pRspInfo.ErrorMsg,"GBK"),ResultCode.TRADE_ORDER_INSERT_ERROR);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

		}
	};
	
	//预埋单是证券买卖中的一种下单(委托交易)方式。就是预先估计好一个买卖价，提前填好后，先行递交给证券营业部的交易单。
	TradeApi.cbOnRspParkedOrderInsert fOnRspParkedOrderInsert = new TradeApi.cbOnRspParkedOrderInsert() {
		///预埋单录入请求响应
		public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField.ByReference pParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspParkedOrderAction fOnRspParkedOrderAction = new TradeApi.cbOnRspParkedOrderAction() {
		///预埋撤单录入请求响应
		public void OnRspParkedOrderAction(CThostFtdcParkedOrderActionField.ByReference pParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	
	//报单 (委托买卖)指证券经纪商接受投资者委托，代理投资者买卖证券，从中收取佣金的交易行为
	TradeApi.cbOnRspOrderAction fOnRspOrderAction = new TradeApi.cbOnRspOrderAction() {
		///报单操作请求响应
		public void OnRspOrderAction(CThostFtdcInputOrderActionField.ByReference pInputOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 报单操作请求响应 ================");
			System.out.println("报单操作请求响应"+pRspInfo.ErrorID);
			try {
				System.out.println("报单操作请求响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		};
	};

	TradeApi.cbOnRspQueryMaxOrderVolume fOnRspQueryMaxOrderVolume = new TradeApi.cbOnRspQueryMaxOrderVolume() {
		///查询最大报单数量响应(账户中可用现金余额，不够买入你所想要买入的股票数量)
		public void OnRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField.ByReference pQueryMaxOrderVolume, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspSettlementInfoConfirm fOnRspSettlementInfoConfirm = new TradeApi.cbOnRspSettlementInfoConfirm() {
		///投资者结算结果确认响应
		public void OnRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 投资者结算结果确认响应 ================");
			System.out.println("投资者结算结果确认"+pRspInfo.ErrorID);
			try {
				System.out.println("投资者结算结果确认 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		};
	};

	TradeApi.cbOnRspRemoveParkedOrder fOnRspRemoveParkedOrder = new TradeApi.cbOnRspRemoveParkedOrder() {
		///删除预埋单响应
		public void OnRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField.ByReference pRemoveParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspRemoveParkedOrderAction fOnRspRemoveParkedOrderAction = new TradeApi.cbOnRspRemoveParkedOrderAction() {
		///删除预埋撤单响应
		public void OnRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField.ByReference pRemoveParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};	
	//股票价款中包括已宣告但尚未支付的现金股利是因为已宣告但尚未支付的现金股利已经是投资收益了，只要到实际发放日就能领到钱了。
	//已宣告但尚未支付的现金股利是指董事会决定宣告发放至实际发放日之间的现金股利。
	TradeApi.cbOnRspExecOrderInsert fOnRspExecOrderInsert = new TradeApi.cbOnRspExecOrderInsert() {
		///执行宣告录入请求响应
		public void OnRspExecOrderInsert(CThostFtdcInputExecOrderField.ByReference pInputExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspExecOrderAction fOnRspExecOrderAction = new TradeApi.cbOnRspExecOrderAction() {
		///执行宣告操作请求响应
		public void OnRspExecOrderAction(CThostFtdcInputExecOrderActionField.ByReference pInputExecOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	
	//所有新股皆采用询价制  
	//发行人及其保荐机构根据询价结果确定发行价格区间（询价区间），询价区间的上限不得高于区间下限的20％。
	TradeApi.cbOnRspForQuoteInsert fOnRspForQuoteInsert = new TradeApi.cbOnRspForQuoteInsert() {
		///询价录入请求响应
		public void OnRspForQuoteInsert(CThostFtdcInputForQuoteField.ByReference pInputForQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	
	//股票报价是证券市场上交易者在某一时间内对某种证券报出的最高进价或最低出价，报价代表了买卖双方所愿意出的最高价格，进价为买者愿买进某种证券所出的价格，出价为卖者愿卖出的价格。
	//报价的次序习惯上是报进价格在先，报出价格在后。
	TradeApi.cbOnRspQuoteInsert fOnRspQuoteInsert = new TradeApi.cbOnRspQuoteInsert() {
		///报价录入请求响应
		public void OnRspQuoteInsert(CThostFtdcInputQuoteField.ByReference pInputQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQuoteAction fOnRspQuoteAction = new TradeApi.cbOnRspQuoteAction() {
		///报价操作请求响应
		public void OnRspQuoteAction(CThostFtdcInputQuoteActionField.ByReference pInputQuoteAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspBatchOrderAction fOnRspBatchOrderAction = new TradeApi.cbOnRspBatchOrderAction() {
		///批量报单操作请求响应
		public void OnRspBatchOrderAction(CThostFtdcInputBatchOrderActionField.ByReference pInputBatchOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspOptionSelfCloseInsert fOnRspOptionSelfCloseInsert = new TradeApi.cbOnRspOptionSelfCloseInsert() {
		///期权自对冲录入请求响应
		public void OnRspOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField.ByReference pInputOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspOptionSelfCloseAction fOnRspOptionSelfCloseAction = new TradeApi.cbOnRspOptionSelfCloseAction() {
		///期权自对冲操作请求响应
		public void OnRspOptionSelfCloseAction(CThostFtdcInputOptionSelfCloseActionField.ByReference pInputOptionSelfCloseAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspCombActionInsert fOnRspCombActionInsert = new TradeApi.cbOnRspCombActionInsert() {
		///申请组合录入请求响应
		public void OnRspCombActionInsert(CThostFtdcInputCombActionField.ByReference pInputCombAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryOrder fOnRspQryOrder = new TradeApi.cbOnRspQryOrder() {
		///请求查询报单响应
		public void OnRspQryOrder(CThostFtdcOrderField.ByReference pOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 请求查询报单响应 ================");
			System.out.println("请求查询报单响应 : "+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询报单响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			System.out.println("报单引用 ： " + ByteToString(pOrder.OrderRef));
			System.out.println("InstrumentID : "+ ByteToString(pOrder.InstrumentID));
			System.out.println("买卖方向 : "+ pOrder.Direction);
			System.out.println();
		};
	};

	TradeApi.cbOnRspQryTrade fOnRspQryTrade = new TradeApi.cbOnRspQryTrade() {
		///请求查询成交响应
		public void OnRspQryTrade(CThostFtdcTradeField.ByReference pTrade, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {

			System.out.println("============ 请求查询成交响应 ================");
			System.out.println("请求查询成交响应 : "+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询成交响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if(pTrade != null){
				System.out.println("交易所代码 ： " + pTrade.ExchangeID);
				System.out.println("买卖方向 : "+ pTrade.Direction);
				System.out.println("报单编号 : "+ pTrade.OrderSysID);
				System.out.println();
			}else{
				System.out.println("成交无数据 ！");
			}

		};
	};

	TradeApi.cbOnRspQryInvestorPosition fOnRspQryInvestorPosition = new TradeApi.cbOnRspQryInvestorPosition() {
		///请求查询投资者持仓响应
		public void OnRspQryInvestorPosition(CThostFtdcInvestorPositionField.ByReference pInvestorPosition, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 请求查询投资者持仓响应 ================");
			System.out.println("请求查询投资者持仓响应 : "+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询投资者持仓响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			System.out.println("今日持仓 ： " + pInvestorPosition.Position);
			System.out.println("InstrumentID : "+ ByteToString(pInvestorPosition.InstrumentID));
			System.out.println("HedgeFlag 组合投机套保标志 : "+ pInvestorPosition.HedgeFlag);
			InvestorPosition investorPosition = new InvestorPosition();
			investorPosition.setInstrumentId(ByteToString(pInvestorPosition.InstrumentID));
			investorPosition.setPosiDirection(pInvestorPosition.PosiDirection);
			investorPosition.setHedgeFlag(pInvestorPosition.HedgeFlag);
			investorPosition.setPositionDate(pInvestorPosition.PositionDate);
			investorPosition.setYdPosition(pInvestorPosition.YdPosition);
			investorPosition.setPosition(pInvestorPosition.Position);
			investorPosition.setLongFrozen(pInvestorPosition.LongFrozen);
			investorPosition.setShortFrozen(pInvestorPosition.ShortFrozen);
			investorPosition.setLongFrozenAmount(pInvestorPosition.LongFrozenAmount);
			investorPosition.setShortFrozenAmount(pInvestorPosition.ShortFrozenAmount);
			investorPosition.setOpenVolume(pInvestorPosition.OpenVolume);
			investorPosition.setCloseVolume(pInvestorPosition.CloseVolume);
			investorPosition.setOpenAmount(pInvestorPosition.OpenAmount);
			investorPosition.setCloseAmount(pInvestorPosition.CloseAmount);
			investorPosition.setPositionCost(pInvestorPosition.PositionCost);
			investorPosition.setPreMargin(pInvestorPosition.PreMargin);
			investorPosition.setUseMargin(pInvestorPosition.UseMargin);
			investorPosition.setFrozenMargin(pInvestorPosition.FrozenMargin);
			investorPosition.setFrozenCash(pInvestorPosition.FrozenCash);
			investorPosition.setFrozenCommission(pInvestorPosition.FrozenCommission);
			investorPosition.setCashIn(pInvestorPosition.CashIn);
			investorPosition.setCommission(pInvestorPosition.Commission);
			investorPosition.setCloseProfit(pInvestorPosition.CloseProfit);
			investorPosition.setPositionProfit(pInvestorPosition.PositionProfit);
			System.out.println("investorPosition ="+investorPosition);
			investorPositionMapper.insert(investorPosition);
			redisService.hmSet(name, ProjectConstant.DGT_TRADE_INVESTOR_POSITION_KEY, investorPosition);

		}
	};

	TradeApi.cbOnRspQryTradingAccount fOnRspQryTradingAccount = new TradeApi.cbOnRspQryTradingAccount() {
		///请求查询资金账户响应
		public void OnRspQryTradingAccount(CThostFtdcTradingAccountField.ByReference pTradingAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 请求查询资金账户响应 ================");
			System.out.println("请求查询资金账户响应确认"+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询资金账户响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			System.out.println("资金账号返回结果 ： " + ByteToString(pTradingAccount.AccountID));
		};
	};

	TradeApi.cbOnRspQryInvestor fOnRspQryInvestor = new TradeApi.cbOnRspQryInvestor() {
		///请求查询投资者响应
		public void OnRspQryInvestor(CThostFtdcInvestorField.ByReference pInvestor, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryTradingCode fOnRspQryTradingCode = new TradeApi.cbOnRspQryTradingCode() {
		///请求查询交易编码响应
		public void OnRspQryTradingCode(CThostFtdcTradingCodeField.ByReference pTradingCode, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInstrumentMarginRate fOnRspQryInstrumentMarginRate = new TradeApi.cbOnRspQryInstrumentMarginRate() {
		///请求查询合约保证金率响应
		public void OnRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField.ByReference pInstrumentMarginRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInstrumentCommissionRate fOnRspQryInstrumentCommissionRate = new TradeApi.cbOnRspQryInstrumentCommissionRate() {
		///请求查询合约手续费率响应
		public void OnRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField.ByReference pInstrumentCommissionRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryExchange fOnRspQryExchange = new TradeApi.cbOnRspQryExchange() {
		///请求查询交易所响应
		public void OnRspQryExchange(CThostFtdcExchangeField.ByReference pExchange, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryProduct fOnRspQryProduct = new TradeApi.cbOnRspQryProduct() {
		///请求查询产品响应
		public void OnRspQryProduct(CThostFtdcProductField.ByReference pProduct, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInstrument fOnRspQryInstrument = new TradeApi.cbOnRspQryInstrument() {
		///请求查询合约响应
		public void OnRspQryInstrument(CThostFtdcInstrumentField.ByReference pInstrument, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.out.println("============ 请求查询投资者结算结果响应  ================");
			System.out.println("请求查询投资者结算结果响应"+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询投资者结算结果响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("合约id ： "+ ByteToString(pInstrument.InstrumentID));
		};
	};

	TradeApi.cbOnRspQryDepthMarketData fOnRspQryDepthMarketData = new TradeApi.cbOnRspQryDepthMarketData() {
		///请求查询行情响应
		public void OnRspQryDepthMarketData(CThostFtdcDepthMarketDataField.ByReference pDepthMarketData, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQrySettlementInfo fOnRspQrySettlementInfo = new TradeApi.cbOnRspQrySettlementInfo() {
		///请求查询投资者结算结果响应
		public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField.ByReference pSettlementInfo, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			
			System.out.println("============ 请求查询投资者结算结果响应  ================");
			System.out.println("请求查询投资者结算结果响应"+pRspInfo.ErrorID);
			try {
				System.out.println("请求查询投资者结算结果响应 ErrorMsg: "+ new String(pRspInfo.ErrorMsg,"GBK"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		};
	};

	TradeApi.cbOnRspQryTransferBank fOnRspQryTransferBank = new TradeApi.cbOnRspQryTransferBank() {
		///请求查询转帐银行响应
		public void OnRspQryTransferBank(CThostFtdcTransferBankField.ByReference pTransferBank, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInvestorPositionDetail fOnRspQryInvestorPositionDetail = new TradeApi.cbOnRspQryInvestorPositionDetail() {
		///请求查询投资者持仓明细响应
		public void OnRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField.ByReference pInvestorPositionDetail, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {

			System.out.println("请求查询投资者持仓明细响应"+pRspInfo.ErrorID);
			System.err.println("持仓明细:>>>>>>>>>>>> ");
			if (pInvestorPositionDetail == null)
			{
				return;
			}
			
			System.out.println("InstrumentID : "+ ByteToString(pInvestorPositionDetail.InstrumentID));
			System.out.println("HedgeFlag 组合投机套保标志 : "+ pInvestorPositionDetail.HedgeFlag);
			System.out.println("Direction  买卖方向 : "+pInvestorPositionDetail.Direction);
			System.out.println("OpenDate : "+ByteToString(pInvestorPositionDetail.OpenDate));
			System.out.println();

			InvestorPositionDetail investorPositionDetail = new InvestorPositionDetail();
			investorPositionDetail.setInstrumentId(ByteToString(pInvestorPositionDetail.InstrumentID));
			investorPositionDetail.setDirection(pInvestorPositionDetail.Direction);
			investorPositionDetail.setOpenDate(ByteToString(pInvestorPositionDetail.OpenDate));
			investorPositionDetail.setTradeId(ByteToString(pInvestorPositionDetail.TradeID));
			investorPositionDetail.setVolume(pInvestorPositionDetail.Volume);
			investorPositionDetail.setOpenPrice(pInvestorPositionDetail.OpenPrice);
			investorPositionDetail.setSettlementId(pInvestorPositionDetail.SettlementID);
			investorPositionDetail.setCombinstrumentId(ByteToString(pInvestorPositionDetail.CombInstrumentID));

			investorPositionDetailMapper.insert(investorPositionDetail);
			redisService.hmSet(name, ProjectConstant.DGT_TRADE_INVESTOR_POSITION_DETAIL_KEY, investorPositionDetail);
			
		};
	};

	TradeApi.cbOnRspQryNotice fOnRspQryNotice = new TradeApi.cbOnRspQryNotice() {
		///请求查询客户通知响应
		public void OnRspQryNotice(CThostFtdcNoticeField.ByReference pNotice, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQrySettlementInfoConfirm fOnRspQrySettlementInfoConfirm = new TradeApi.cbOnRspQrySettlementInfoConfirm() {
		///请求查询结算信息确认响应
		public void OnRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInvestorPositionCombineDetail fOnRspQryInvestorPositionCombineDetail = new TradeApi.cbOnRspQryInvestorPositionCombineDetail() {
		///请求查询投资者持仓明细响应
		public void OnRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField.ByReference pInvestorPositionCombineDetail, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {
			System.err.println("请求查询投资者持仓明细响应000000000000000000000");
			
		};
	};

	TradeApi.cbOnRspQryCFMMCTradingAccountKey fOnRspQryCFMMCTradingAccountKey = new TradeApi.cbOnRspQryCFMMCTradingAccountKey() {
		///查询保证金监管系统经纪公司资金账户密钥响应
		public void OnRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField.ByReference pCFMMCTradingAccountKey, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryEWarrantOffset fOnRspQryEWarrantOffset = new TradeApi.cbOnRspQryEWarrantOffset() {
		///请求查询仓单折抵信息响应
		public void OnRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField.ByReference pEWarrantOffset, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInvestorProductGroupMargin fOnRspQryInvestorProductGroupMargin = new TradeApi.cbOnRspQryInvestorProductGroupMargin() {
		///请求查询投资者品种/跨品种保证金响应
		public void OnRspQryInvestorProductGroupMargin(CThostFtdcInvestorProductGroupMarginField.ByReference pInvestorProductGroupMargin, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryExchangeMarginRate fOnRspQryExchangeMarginRate = new TradeApi.cbOnRspQryExchangeMarginRate() {
		///请求查询交易所保证金率响应
		public void OnRspQryExchangeMarginRate(CThostFtdcExchangeMarginRateField.ByReference pExchangeMarginRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryExchangeMarginRateAdjust fOnRspQryExchangeMarginRateAdjust = new TradeApi.cbOnRspQryExchangeMarginRateAdjust() {
		///请求查询交易所调整保证金率响应
		public void OnRspQryExchangeMarginRateAdjust(CThostFtdcExchangeMarginRateAdjustField.ByReference pExchangeMarginRateAdjust, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryExchangeRate fOnRspQryExchangeRate = new TradeApi.cbOnRspQryExchangeRate() {
		///请求查询汇率响应
		public void OnRspQryExchangeRate(CThostFtdcExchangeRateField.ByReference pExchangeRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQrySecAgentACIDMap fOnRspQrySecAgentACIDMap = new TradeApi.cbOnRspQrySecAgentACIDMap() {
		///请求查询二级代理操作员银期权限响应
		public void OnRspQrySecAgentACIDMap(CThostFtdcSecAgentACIDMapField.ByReference pSecAgentACIDMap, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryProductExchRate fOnRspQryProductExchRate = new TradeApi.cbOnRspQryProductExchRate() {
		///请求查询产品报价汇率
		public void OnRspQryProductExchRate(CThostFtdcProductExchRateField.ByReference pProductExchRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryProductGroup fOnRspQryProductGroup = new TradeApi.cbOnRspQryProductGroup() {
		///请求查询产品组
		public void OnRspQryProductGroup(CThostFtdcProductGroupField.ByReference pProductGroup, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryMMInstrumentCommissionRate fOnRspQryMMInstrumentCommissionRate = new TradeApi.cbOnRspQryMMInstrumentCommissionRate() {
		///请求查询做市商合约手续费率响应
		public void OnRspQryMMInstrumentCommissionRate(CThostFtdcMMInstrumentCommissionRateField.ByReference pMMInstrumentCommissionRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryMMOptionInstrCommRate fOnRspQryMMOptionInstrCommRate = new TradeApi.cbOnRspQryMMOptionInstrCommRate() {
		///请求查询做市商期权合约手续费响应
		public void OnRspQryMMOptionInstrCommRate(CThostFtdcMMOptionInstrCommRateField.ByReference pMMOptionInstrCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInstrumentOrderCommRate fOnRspQryInstrumentOrderCommRate = new TradeApi.cbOnRspQryInstrumentOrderCommRate() {
		///请求查询报单手续费响应
		public void OnRspQryInstrumentOrderCommRate(CThostFtdcInstrumentOrderCommRateField.ByReference pInstrumentOrderCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQrySecAgentTradingAccount fOnRspQrySecAgentTradingAccount = new TradeApi.cbOnRspQrySecAgentTradingAccount() {
		///请求查询资金账户响应
		public void OnRspQrySecAgentTradingAccount(CThostFtdcTradingAccountField.ByReference pTradingAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQrySecAgentCheckMode fOnRspQrySecAgentCheckMode = new TradeApi.cbOnRspQrySecAgentCheckMode() {
		///请求查询二级代理商资金校验模式响应
		public void OnRspQrySecAgentCheckMode(CThostFtdcSecAgentCheckModeField.ByReference pSecAgentCheckMode, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryOptionInstrTradeCost fOnRspQryOptionInstrTradeCost = new TradeApi.cbOnRspQryOptionInstrTradeCost() {
		///请求查询期权交易成本响应
		public void OnRspQryOptionInstrTradeCost(CThostFtdcOptionInstrTradeCostField.ByReference pOptionInstrTradeCost, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryOptionInstrCommRate fOnRspQryOptionInstrCommRate = new TradeApi.cbOnRspQryOptionInstrCommRate() {
		///请求查询期权合约手续费响应
		public void OnRspQryOptionInstrCommRate(CThostFtdcOptionInstrCommRateField.ByReference pOptionInstrCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryExecOrder fOnRspQryExecOrder = new TradeApi.cbOnRspQryExecOrder() {
		///请求查询执行宣告响应
		public void OnRspQryExecOrder(CThostFtdcExecOrderField.ByReference pExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryForQuote fOnRspQryForQuote = new TradeApi.cbOnRspQryForQuote() {
		///请求查询询价响应
		public void OnRspQryForQuote(CThostFtdcForQuoteField.ByReference pForQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryQuote fOnRspQryQuote = new TradeApi.cbOnRspQryQuote() {
		///请求查询报价响应
		public void OnRspQryQuote(CThostFtdcQuoteField.ByReference pQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryOptionSelfClose fOnRspQryOptionSelfClose = new TradeApi.cbOnRspQryOptionSelfClose() {
		///请求查询期权自对冲响应
		public void OnRspQryOptionSelfClose(CThostFtdcOptionSelfCloseField.ByReference pOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryInvestUnit fOnRspQryInvestUnit = new TradeApi.cbOnRspQryInvestUnit() {
		///请求查询投资单元响应
		public void OnRspQryInvestUnit(CThostFtdcInvestUnitField.ByReference pInvestUnit, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryCombInstrumentGuard fOnRspQryCombInstrumentGuard = new TradeApi.cbOnRspQryCombInstrumentGuard() {
		///请求查询组合合约安全系数响应
		public void OnRspQryCombInstrumentGuard(CThostFtdcCombInstrumentGuardField.ByReference pCombInstrumentGuard, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryCombAction fOnRspQryCombAction = new TradeApi.cbOnRspQryCombAction() {
		///请求查询申请组合响应
		public void OnRspQryCombAction(CThostFtdcCombActionField.ByReference pCombAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryTransferSerial fOnRspQryTransferSerial = new TradeApi.cbOnRspQryTransferSerial() {
		///请求查询转帐流水响应
		public void OnRspQryTransferSerial(CThostFtdcTransferSerialField.ByReference pTransferSerial, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryAccountregister fOnRspQryAccountregister = new TradeApi.cbOnRspQryAccountregister() {
		///请求查询银期签约关系响应
		public void OnRspQryAccountregister(CThostFtdcAccountregisterField.ByReference pAccountregister, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspError fOnRspError = new TradeApi.cbOnRspError() {
		///错误应答
		public void OnRspError(CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRtnOrder fOnRtnOrder = new TradeApi.cbOnRtnOrder() {
		///报单通知
		public void OnRtnOrder(CThostFtdcOrderField.ByReference pOrder) {
			System.out.println("$$$报单编号-->返回 : " + ByteToString(pOrder.OrderSysID));
			System.out.println("$$$报单编号-->交易所代码 : " + ByteToString(pOrder.ExchangeID));
			System.out.println("$$$报单编号-->请求编号 : " + pOrder.RequestID);
			if (requestIDManager.containsKey(String.valueOf(pOrder.RequestID))) {
				Trade trade = (Trade)requestIDManager.get(String.valueOf(pOrder.RequestID));
				trade.setExchangeId(ByteToString(pOrder.ExchangeID));
				trade.setOrderSysId(ByteToString(pOrder.OrderSysID));
				tradeMapper.updateByPrimaryKey(trade);
				requestIDManager.remove(String.valueOf(pOrder.RequestID));
			}
		};
	};

	TradeApi.cbOnRtnTrade fOnRtnTrade = new TradeApi.cbOnRtnTrade() {
		///成交通知
		public void OnRtnTrade(CThostFtdcTradeField.ByReference pTrade) {
			System.out.println("$$$成交通知-->合约编号 : " + ByteToString(pTrade.InstrumentID) + "， 数量:" + pTrade.Volume + "， 报单编号 ： " + ByteToString(pTrade.OrderSysID));

//			Trade trade = null;
//			// key name hashkey exchangeid+OrderSysID
//			String hashKey = ByteToString(pTrade.ExchangeID)+ByteToString(pTrade.OrderSysID);
//			if (pTrade.OffsetFlag == ProjectConstant.TRADE_COMB_OFFSET_FLAG_CLOSE){
//				trade = (Trade) redisService.hmGet(name,hashKey);
//				if (trade != null) {
//					 // 是否全部平仓，如果是移除，部分平仓显示剩余量
//					int lastCount = trade.getVolumeTotalOriginal() - pTrade.Volume;
//					// 已经全部平仓，移除
//					if (lastCount == 0) {
//						redisService.hmDel(name, hashKey);
//					} else {
//						// 部分
//						trade.setVolumeTotalOriginal(lastCount);
//						redisService.hmSet(name, hashKey, trade);
//					}
//				}
//
//			} else {
//				trade = tradeMapper.getTradeByExchangeIdAndOrderSysId(ByteToString(pTrade.ExchangeID), ByteToString(pTrade.OrderSysID));
//				trade.setTransactionPrice(pTrade.Price);
//				trade.setVolumeTotalOriginal(pTrade.Volume);
//				redisService.hmSet(name, hashKey, trade);
//
//			}
			// 查询投资者持仓
			queryPos();
			// 查询持仓明细
			queryPosition();
		}
	};

	TradeApi.cbOnErrRtnOrderInsert fOnErrRtnOrderInsert = new TradeApi.cbOnErrRtnOrderInsert() {
		///报单录入错误回报
		public void OnErrRtnOrderInsert(CThostFtdcInputOrderField.ByReference pInputOrder, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnOrderAction fOnErrRtnOrderAction = new TradeApi.cbOnErrRtnOrderAction() {
		///报单操作错误回报
		public void OnErrRtnOrderAction(CThostFtdcOrderActionField.ByReference pOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnInstrumentStatus fOnRtnInstrumentStatus = new TradeApi.cbOnRtnInstrumentStatus() {
		///合约交易状态通知
		public void OnRtnInstrumentStatus(CThostFtdcInstrumentStatusField.ByReference pInstrumentStatus) {};
	};

	TradeApi.cbOnRtnBulletin fOnRtnBulletin = new TradeApi.cbOnRtnBulletin() {
		///交易所公告通知
		public void OnRtnBulletin(CThostFtdcBulletinField.ByReference pBulletin) {};
	};

	TradeApi.cbOnRtnTradingNotice fOnRtnTradingNotice = new TradeApi.cbOnRtnTradingNotice() {
		///交易通知
		public void OnRtnTradingNotice(CThostFtdcTradingNoticeInfoField.ByReference pTradingNoticeInfo) {};
	};

	TradeApi.cbOnRtnErrorConditionalOrder fOnRtnErrorConditionalOrder = new TradeApi.cbOnRtnErrorConditionalOrder() {
		///提示条件单校验错误
		public void OnRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField.ByReference pErrorConditionalOrder) {};
	};

	TradeApi.cbOnRtnExecOrder fOnRtnExecOrder = new TradeApi.cbOnRtnExecOrder() {
		///执行宣告通知
		public void OnRtnExecOrder(CThostFtdcExecOrderField.ByReference pExecOrder) {};
	};

	TradeApi.cbOnErrRtnExecOrderInsert fOnErrRtnExecOrderInsert = new TradeApi.cbOnErrRtnExecOrderInsert() {
		///执行宣告录入错误回报
		public void OnErrRtnExecOrderInsert(CThostFtdcInputExecOrderField.ByReference pInputExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnExecOrderAction fOnErrRtnExecOrderAction = new TradeApi.cbOnErrRtnExecOrderAction() {
		///执行宣告操作错误回报
		public void OnErrRtnExecOrderAction(CThostFtdcExecOrderActionField.ByReference pExecOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnForQuoteInsert fOnErrRtnForQuoteInsert = new TradeApi.cbOnErrRtnForQuoteInsert() {
		///询价录入错误回报
		public void OnErrRtnForQuoteInsert(CThostFtdcInputForQuoteField.ByReference pInputForQuote, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnQuote fOnRtnQuote = new TradeApi.cbOnRtnQuote() {
		///报价通知
		public void OnRtnQuote(CThostFtdcQuoteField.ByReference pQuote) {};
	};

	TradeApi.cbOnErrRtnQuoteInsert fOnErrRtnQuoteInsert = new TradeApi.cbOnErrRtnQuoteInsert() {
		///报价录入错误回报
		public void OnErrRtnQuoteInsert(CThostFtdcInputQuoteField.ByReference pInputQuote, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnQuoteAction fOnErrRtnQuoteAction = new TradeApi.cbOnErrRtnQuoteAction() {
		///报价操作错误回报
		public void OnErrRtnQuoteAction(CThostFtdcQuoteActionField.ByReference pQuoteAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnForQuoteRsp fOnRtnForQuoteRsp = new TradeApi.cbOnRtnForQuoteRsp() {
		///询价通知
		public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField.ByReference pForQuoteRsp) {};
	};

	TradeApi.cbOnRtnCFMMCTradingAccountToken fOnRtnCFMMCTradingAccountToken = new TradeApi.cbOnRtnCFMMCTradingAccountToken() {
		///保证金监控中心用户令牌
		public void OnRtnCFMMCTradingAccountToken(CThostFtdcCFMMCTradingAccountTokenField.ByReference pCFMMCTradingAccountToken) {};
	};

	TradeApi.cbOnErrRtnBatchOrderAction fOnErrRtnBatchOrderAction = new TradeApi.cbOnErrRtnBatchOrderAction() {
		///批量报单操作错误回报
		public void OnErrRtnBatchOrderAction(CThostFtdcBatchOrderActionField.ByReference pBatchOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnOptionSelfClose fOnRtnOptionSelfClose = new TradeApi.cbOnRtnOptionSelfClose() {
		///期权自对冲通知
		public void OnRtnOptionSelfClose(CThostFtdcOptionSelfCloseField.ByReference pOptionSelfClose) {};
	};

	TradeApi.cbOnErrRtnOptionSelfCloseInsert fOnErrRtnOptionSelfCloseInsert = new TradeApi.cbOnErrRtnOptionSelfCloseInsert() {
		///期权自对冲录入错误回报
		public void OnErrRtnOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField.ByReference pInputOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnOptionSelfCloseAction fOnErrRtnOptionSelfCloseAction = new TradeApi.cbOnErrRtnOptionSelfCloseAction() {
		///期权自对冲操作错误回报
		public void OnErrRtnOptionSelfCloseAction(CThostFtdcOptionSelfCloseActionField.ByReference pOptionSelfCloseAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnCombAction fOnRtnCombAction = new TradeApi.cbOnRtnCombAction() {
		///申请组合通知
		public void OnRtnCombAction(CThostFtdcCombActionField.ByReference pCombAction) {};
	};

	TradeApi.cbOnErrRtnCombActionInsert fOnErrRtnCombActionInsert = new TradeApi.cbOnErrRtnCombActionInsert() {
		///申请组合录入错误回报
		public void OnErrRtnCombActionInsert(CThostFtdcInputCombActionField.ByReference pInputCombAction, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRspQryContractBank fOnRspQryContractBank = new TradeApi.cbOnRspQryContractBank() {
		///请求查询签约银行响应
		public void OnRspQryContractBank(CThostFtdcContractBankField.ByReference pContractBank, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryParkedOrder fOnRspQryParkedOrder = new TradeApi.cbOnRspQryParkedOrder() {
		///请求查询预埋单响应
		public void OnRspQryParkedOrder(CThostFtdcParkedOrderField.ByReference pParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryParkedOrderAction fOnRspQryParkedOrderAction = new TradeApi.cbOnRspQryParkedOrderAction() {
		///请求查询预埋撤单响应
		public void OnRspQryParkedOrderAction(CThostFtdcParkedOrderActionField.ByReference pParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryTradingNotice fOnRspQryTradingNotice = new TradeApi.cbOnRspQryTradingNotice() {
		///请求查询交易通知响应
		public void OnRspQryTradingNotice(CThostFtdcTradingNoticeField.ByReference pTradingNotice, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryBrokerTradingParams fOnRspQryBrokerTradingParams = new TradeApi.cbOnRspQryBrokerTradingParams() {
		///请求查询经纪公司交易参数响应
		public void OnRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField.ByReference pBrokerTradingParams, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQryBrokerTradingAlgos fOnRspQryBrokerTradingAlgos = new TradeApi.cbOnRspQryBrokerTradingAlgos() {
		///请求查询经纪公司交易算法响应
		public void OnRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField.ByReference pBrokerTradingAlgos, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQueryCFMMCTradingAccountToken fOnRspQueryCFMMCTradingAccountToken = new TradeApi.cbOnRspQueryCFMMCTradingAccountToken() {
		///请求查询监控中心用户令牌
		public void OnRspQueryCFMMCTradingAccountToken(CThostFtdcQueryCFMMCTradingAccountTokenField.ByReference pQueryCFMMCTradingAccountToken, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRtnFromBankToFutureByBank fOnRtnFromBankToFutureByBank = new TradeApi.cbOnRtnFromBankToFutureByBank() {
		///银行发起银行资金转期货通知
		public void OnRtnFromBankToFutureByBank(CThostFtdcRspTransferField.ByReference pRspTransfer) {};
	};

	TradeApi.cbOnRtnFromFutureToBankByBank fOnRtnFromFutureToBankByBank = new TradeApi.cbOnRtnFromFutureToBankByBank() {
		///银行发起期货资金转银行通知
		public void OnRtnFromFutureToBankByBank(CThostFtdcRspTransferField.ByReference pRspTransfer) {};
	};

	TradeApi.cbOnRtnRepealFromBankToFutureByBank fOnRtnRepealFromBankToFutureByBank = new TradeApi.cbOnRtnRepealFromBankToFutureByBank() {
		///银行发起冲正银行转期货通知
		public void OnRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRtnRepealFromFutureToBankByBank fOnRtnRepealFromFutureToBankByBank = new TradeApi.cbOnRtnRepealFromFutureToBankByBank() {
		///银行发起冲正期货转银行通知
		public void OnRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRtnFromBankToFutureByFuture fOnRtnFromBankToFutureByFuture = new TradeApi.cbOnRtnFromBankToFutureByFuture() {
		///期货发起银行资金转期货通知
		public void OnRtnFromBankToFutureByFuture(CThostFtdcRspTransferField.ByReference pRspTransfer) {};
	};

	TradeApi.cbOnRtnFromFutureToBankByFuture fOnRtnFromFutureToBankByFuture = new TradeApi.cbOnRtnFromFutureToBankByFuture() {
		///期货发起期货资金转银行通知
		public void OnRtnFromFutureToBankByFuture(CThostFtdcRspTransferField.ByReference pRspTransfer) {};
	};

	TradeApi.cbOnRtnRepealFromBankToFutureByFutureManual fOnRtnRepealFromBankToFutureByFutureManual = new TradeApi.cbOnRtnRepealFromBankToFutureByFutureManual() {
		///系统运行时期货端手工发起冲正银行转期货请求，银行处理完毕后报盘发回的通知
		public void OnRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRtnRepealFromFutureToBankByFutureManual fOnRtnRepealFromFutureToBankByFutureManual = new TradeApi.cbOnRtnRepealFromFutureToBankByFutureManual() {
		///系统运行时期货端手工发起冲正期货转银行请求，银行处理完毕后报盘发回的通知
		public void OnRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRtnQueryBankBalanceByFuture fOnRtnQueryBankBalanceByFuture = new TradeApi.cbOnRtnQueryBankBalanceByFuture() {
		///期货发起查询银行余额通知
		public void OnRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField.ByReference pNotifyQueryAccount) {};
	};

	TradeApi.cbOnErrRtnBankToFutureByFuture fOnErrRtnBankToFutureByFuture = new TradeApi.cbOnErrRtnBankToFutureByFuture() {
		///期货发起银行资金转期货错误回报
		public void OnErrRtnBankToFutureByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnFutureToBankByFuture fOnErrRtnFutureToBankByFuture = new TradeApi.cbOnErrRtnFutureToBankByFuture() {
		///期货发起期货资金转银行错误回报
		public void OnErrRtnFutureToBankByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnRepealBankToFutureByFutureManual fOnErrRtnRepealBankToFutureByFutureManual = new TradeApi.cbOnErrRtnRepealBankToFutureByFutureManual() {
		///系统运行时期货端手工发起冲正银行转期货错误回报
		public void OnErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField.ByReference pReqRepeal, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnRepealFutureToBankByFutureManual fOnErrRtnRepealFutureToBankByFutureManual = new TradeApi.cbOnErrRtnRepealFutureToBankByFutureManual() {
		///系统运行时期货端手工发起冲正期货转银行错误回报
		public void OnErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField.ByReference pReqRepeal, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnErrRtnQueryBankBalanceByFuture fOnErrRtnQueryBankBalanceByFuture = new TradeApi.cbOnErrRtnQueryBankBalanceByFuture() {
		///期货发起查询银行余额错误回报
		public void OnErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField.ByReference pReqQueryAccount, CThostFtdcRspInfoField.ByReference pRspInfo) {};
	};

	TradeApi.cbOnRtnRepealFromBankToFutureByFuture fOnRtnRepealFromBankToFutureByFuture = new TradeApi.cbOnRtnRepealFromBankToFutureByFuture() {
		///期货发起冲正银行转期货请求，银行处理完毕后报盘发回的通知
		public void OnRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRtnRepealFromFutureToBankByFuture fOnRtnRepealFromFutureToBankByFuture = new TradeApi.cbOnRtnRepealFromFutureToBankByFuture() {
		///期货发起冲正期货转银行请求，银行处理完毕后报盘发回的通知
		public void OnRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField.ByReference pRspRepeal) {};
	};

	TradeApi.cbOnRspFromBankToFutureByFuture fOnRspFromBankToFutureByFuture = new TradeApi.cbOnRspFromBankToFutureByFuture() {
		///期货发起银行资金转期货应答
		public void OnRspFromBankToFutureByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspFromFutureToBankByFuture fOnRspFromFutureToBankByFuture = new TradeApi.cbOnRspFromFutureToBankByFuture() {
		///期货发起期货资金转银行应答
		public void OnRspFromFutureToBankByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRspQueryBankAccountMoneyByFuture fOnRspQueryBankAccountMoneyByFuture = new TradeApi.cbOnRspQueryBankAccountMoneyByFuture() {
		///期货发起查询银行余额应答
		public void OnRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField.ByReference pReqQueryAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast) {};
	};

	TradeApi.cbOnRtnOpenAccountByBank fOnRtnOpenAccountByBank = new TradeApi.cbOnRtnOpenAccountByBank() {
		///银行发起银期开户通知
		public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField.ByReference pOpenAccount) {};
	};

	TradeApi.cbOnRtnCancelAccountByBank fOnRtnCancelAccountByBank = new TradeApi.cbOnRtnCancelAccountByBank() {
		///银行发起银期销户通知
		public void OnRtnCancelAccountByBank(CThostFtdcCancelAccountField.ByReference pCancelAccount) {};
	};

	TradeApi.cbOnRtnChangeAccountByBank fOnRtnChangeAccountByBank = new TradeApi.cbOnRtnChangeAccountByBank() {
		///银行发起变更银行账号通知
		public void OnRtnChangeAccountByBank(CThostFtdcChangeAccountField.ByReference pChangeAccount) {};
	};
	
	public void login() {
		TradeApi.JavaCallback.ByReference dcallback = new TradeApi.JavaCallback.ByReference();
		dcallback.OnFrontConnected = fOnFrontConnected;
		dcallback.OnFrontDisconnected = fOnFrontDisconnected;
		dcallback.OnHeartBeatWarning = fOnHeartBeatWarning;
		dcallback.OnRspAuthenticate = fOnRspAuthenticate;
		dcallback.OnRspUserLogin = fOnRspUserLogin;
		dcallback.OnRspUserLogout = fOnRspUserLogout;
		dcallback.OnRspUserPasswordUpdate = fOnRspUserPasswordUpdate;
		dcallback.OnRspTradingAccountPasswordUpdate = fOnRspTradingAccountPasswordUpdate;
		dcallback.OnRspOrderInsert = fOnRspOrderInsert;
		dcallback.OnRspParkedOrderInsert = fOnRspParkedOrderInsert;
		dcallback.OnRspParkedOrderAction = fOnRspParkedOrderAction;
		dcallback.OnRspOrderAction = fOnRspOrderAction;
		dcallback.OnRspQueryMaxOrderVolume = fOnRspQueryMaxOrderVolume;
		dcallback.OnRspSettlementInfoConfirm = fOnRspSettlementInfoConfirm;
		dcallback.OnRspRemoveParkedOrder = fOnRspRemoveParkedOrder;
		dcallback.OnRspRemoveParkedOrderAction = fOnRspRemoveParkedOrderAction;
		dcallback.OnRspExecOrderInsert = fOnRspExecOrderInsert;
		dcallback.OnRspExecOrderAction = fOnRspExecOrderAction;
		dcallback.OnRspForQuoteInsert = fOnRspForQuoteInsert;
		dcallback.OnRspQuoteInsert = fOnRspQuoteInsert;
		dcallback.OnRspQuoteAction = fOnRspQuoteAction;
		dcallback.OnRspBatchOrderAction = fOnRspBatchOrderAction;
		dcallback.OnRspOptionSelfCloseInsert = fOnRspOptionSelfCloseInsert;
		dcallback.OnRspOptionSelfCloseAction = fOnRspOptionSelfCloseAction;
		dcallback.OnRspCombActionInsert = fOnRspCombActionInsert;
		dcallback.OnRspQryOrder = fOnRspQryOrder;
		dcallback.OnRspQryTrade = fOnRspQryTrade;
		dcallback.OnRspQryInvestorPosition = fOnRspQryInvestorPosition;
		dcallback.OnRspQryTradingAccount = fOnRspQryTradingAccount;
		dcallback.OnRspQryInvestor = fOnRspQryInvestor;
		dcallback.OnRspQryTradingCode = fOnRspQryTradingCode;
		dcallback.OnRspQryInstrumentMarginRate = fOnRspQryInstrumentMarginRate;
		dcallback.OnRspQryInstrumentCommissionRate = fOnRspQryInstrumentCommissionRate;
		dcallback.OnRspQryExchange = fOnRspQryExchange;
		dcallback.OnRspQryProduct = fOnRspQryProduct;
		dcallback.OnRspQryInstrument = fOnRspQryInstrument;
		dcallback.OnRspQryDepthMarketData = fOnRspQryDepthMarketData;
		dcallback.OnRspQrySettlementInfo = fOnRspQrySettlementInfo;
		dcallback.OnRspQryTransferBank = fOnRspQryTransferBank;
		dcallback.OnRspQryInvestorPositionDetail = fOnRspQryInvestorPositionDetail;
		dcallback.OnRspQryNotice = fOnRspQryNotice;
		dcallback.OnRspQrySettlementInfoConfirm = fOnRspQrySettlementInfoConfirm;
		dcallback.OnRspQryInvestorPositionCombineDetail = fOnRspQryInvestorPositionCombineDetail;
		dcallback.OnRspQryCFMMCTradingAccountKey = fOnRspQryCFMMCTradingAccountKey;
		dcallback.OnRspQryEWarrantOffset = fOnRspQryEWarrantOffset;
		dcallback.OnRspQryInvestorProductGroupMargin = fOnRspQryInvestorProductGroupMargin;
		dcallback.OnRspQryExchangeMarginRate = fOnRspQryExchangeMarginRate;
		dcallback.OnRspQryExchangeMarginRateAdjust = fOnRspQryExchangeMarginRateAdjust;
		dcallback.OnRspQryExchangeRate = fOnRspQryExchangeRate;
		dcallback.OnRspQrySecAgentACIDMap = fOnRspQrySecAgentACIDMap;
		dcallback.OnRspQryProductExchRate = fOnRspQryProductExchRate;
		dcallback.OnRspQryProductGroup = fOnRspQryProductGroup;
		dcallback.OnRspQryMMInstrumentCommissionRate = fOnRspQryMMInstrumentCommissionRate;
		dcallback.OnRspQryMMOptionInstrCommRate = fOnRspQryMMOptionInstrCommRate;
		dcallback.OnRspQryInstrumentOrderCommRate = fOnRspQryInstrumentOrderCommRate;
		dcallback.OnRspQrySecAgentTradingAccount = fOnRspQrySecAgentTradingAccount;
		dcallback.OnRspQrySecAgentCheckMode = fOnRspQrySecAgentCheckMode;
		dcallback.OnRspQryOptionInstrTradeCost = fOnRspQryOptionInstrTradeCost;
		dcallback.OnRspQryOptionInstrCommRate = fOnRspQryOptionInstrCommRate;
		dcallback.OnRspQryExecOrder = fOnRspQryExecOrder;
		dcallback.OnRspQryForQuote = fOnRspQryForQuote;
		dcallback.OnRspQryQuote = fOnRspQryQuote;
		dcallback.OnRspQryOptionSelfClose = fOnRspQryOptionSelfClose;
		dcallback.OnRspQryInvestUnit = fOnRspQryInvestUnit;
		dcallback.OnRspQryCombInstrumentGuard = fOnRspQryCombInstrumentGuard;
		dcallback.OnRspQryCombAction = fOnRspQryCombAction;
		dcallback.OnRspQryTransferSerial = fOnRspQryTransferSerial;
		dcallback.OnRspQryAccountregister = fOnRspQryAccountregister;
		dcallback.OnRspError = fOnRspError;
		dcallback.OnRtnOrder = fOnRtnOrder;
		dcallback.OnRtnTrade = fOnRtnTrade;
		dcallback.OnErrRtnOrderInsert = fOnErrRtnOrderInsert;
		dcallback.OnErrRtnOrderAction = fOnErrRtnOrderAction;
		dcallback.OnRtnInstrumentStatus = fOnRtnInstrumentStatus;
		dcallback.OnRtnBulletin = fOnRtnBulletin;
		dcallback.OnRtnTradingNotice = fOnRtnTradingNotice;
		dcallback.OnRtnErrorConditionalOrder = fOnRtnErrorConditionalOrder;
		dcallback.OnRtnExecOrder = fOnRtnExecOrder;
		dcallback.OnErrRtnExecOrderInsert = fOnErrRtnExecOrderInsert;
		dcallback.OnErrRtnExecOrderAction = fOnErrRtnExecOrderAction;
		dcallback.OnErrRtnForQuoteInsert = fOnErrRtnForQuoteInsert;
		dcallback.OnRtnQuote = fOnRtnQuote;
		dcallback.OnErrRtnQuoteInsert = fOnErrRtnQuoteInsert;
		dcallback.OnErrRtnQuoteAction = fOnErrRtnQuoteAction;
		dcallback.OnRtnForQuoteRsp = fOnRtnForQuoteRsp;
		dcallback.OnRtnCFMMCTradingAccountToken = fOnRtnCFMMCTradingAccountToken;
		dcallback.OnErrRtnBatchOrderAction = fOnErrRtnBatchOrderAction;
		dcallback.OnRtnOptionSelfClose = fOnRtnOptionSelfClose;
		dcallback.OnErrRtnOptionSelfCloseInsert = fOnErrRtnOptionSelfCloseInsert;
		dcallback.OnErrRtnOptionSelfCloseAction = fOnErrRtnOptionSelfCloseAction;
		dcallback.OnRtnCombAction = fOnRtnCombAction;
		dcallback.OnErrRtnCombActionInsert = fOnErrRtnCombActionInsert;
		dcallback.OnRspQryContractBank = fOnRspQryContractBank;
		dcallback.OnRspQryParkedOrder = fOnRspQryParkedOrder;
		dcallback.OnRspQryParkedOrderAction = fOnRspQryParkedOrderAction;
		dcallback.OnRspQryTradingNotice = fOnRspQryTradingNotice;
		dcallback.OnRspQryBrokerTradingParams = fOnRspQryBrokerTradingParams;
		dcallback.OnRspQryBrokerTradingAlgos = fOnRspQryBrokerTradingAlgos;
		dcallback.OnRspQueryCFMMCTradingAccountToken = fOnRspQueryCFMMCTradingAccountToken;
		dcallback.OnRtnFromBankToFutureByBank = fOnRtnFromBankToFutureByBank;
		dcallback.OnRtnFromFutureToBankByBank = fOnRtnFromFutureToBankByBank;
		dcallback.OnRtnRepealFromBankToFutureByBank = fOnRtnRepealFromBankToFutureByBank;
		dcallback.OnRtnRepealFromFutureToBankByBank = fOnRtnRepealFromFutureToBankByBank;
		dcallback.OnRtnFromBankToFutureByFuture = fOnRtnFromBankToFutureByFuture;
		dcallback.OnRtnFromFutureToBankByFuture = fOnRtnFromFutureToBankByFuture;
		dcallback.OnRtnRepealFromBankToFutureByFutureManual = fOnRtnRepealFromBankToFutureByFutureManual;
		dcallback.OnRtnRepealFromFutureToBankByFutureManual = fOnRtnRepealFromFutureToBankByFutureManual;
		dcallback.OnRtnQueryBankBalanceByFuture = fOnRtnQueryBankBalanceByFuture;
		dcallback.OnErrRtnBankToFutureByFuture = fOnErrRtnBankToFutureByFuture;
		dcallback.OnErrRtnFutureToBankByFuture = fOnErrRtnFutureToBankByFuture;
		dcallback.OnErrRtnRepealBankToFutureByFutureManual = fOnErrRtnRepealBankToFutureByFutureManual;
		dcallback.OnErrRtnRepealFutureToBankByFutureManual = fOnErrRtnRepealFutureToBankByFutureManual;
		dcallback.OnErrRtnQueryBankBalanceByFuture = fOnErrRtnQueryBankBalanceByFuture;
		dcallback.OnRtnRepealFromBankToFutureByFuture = fOnRtnRepealFromBankToFutureByFuture;
		dcallback.OnRtnRepealFromFutureToBankByFuture = fOnRtnRepealFromFutureToBankByFuture;
		dcallback.OnRspFromBankToFutureByFuture = fOnRspFromBankToFutureByFuture;
		dcallback.OnRspFromFutureToBankByFuture = fOnRspFromFutureToBankByFuture;
		dcallback.OnRspQueryBankAccountMoneyByFuture = fOnRspQueryBankAccountMoneyByFuture;
		dcallback.OnRtnOpenAccountByBank = fOnRtnOpenAccountByBank;
		dcallback.OnRtnCancelAccountByBank = fOnRtnCancelAccountByBank;
		dcallback.OnRtnChangeAccountByBank = fOnRtnChangeAccountByBank;

		instance.RegisterSpi(handle, dcallback);
		//instance.RegisterFront(handle, "tcp://120.55.162.84:9609"); // tcp://192.168.1.210:1706 // tcp://180.168.146.187:10000
		instance.RegisterFront(handle, tcpUrl);
		instance.SubscribePublicTopic(handle, 0);
		instance.SubscribePrivateTopic(handle, 0);
		instance.Init(handle);
	}

	//报单
	public Result placeOrder(Trade trade) {
		CThostFtdcInputOrderField.ByReference  pInputOrder = new CThostFtdcInputOrderField.ByReference();
		setBytesData(pInputOrder.BrokerID, brokerID);//经济公司代码
		setBytesData(pInputOrder.InstrumentID, trade.getInstrumentId());//合约代码 InstrumentID
		setBytesData(pInputOrder.OrderRef, Integer.toString(++orderRef));//报单引用
		setBytesData(pInputOrder.UserID, name);////用户代码
		setBytesData( pInputOrder.InvestorID, name);//投资者代码
		
		//报单价格条件（限价）
		pInputOrder.OrderPriceType=(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_OPT_LimitPrice;
		//买卖方向（买）
		pInputOrder.Direction=(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_D_Buy ;
		// 判断 买卖方向
		if (trade.getDirection() == ProjectConstant.TRADE_DIRECTION_SELL) {
			pInputOrder.Direction = (byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_D_Sell;
		}
		//有效期类型 THOST_FTDC_TC_GF（当日有效）
		pInputOrder.TimeCondition=(byte)ThostFtdcUserApiDataTypeLibrary. THOST_FTDC_TC_GFD;
		 //成交类型（任何数量）
		pInputOrder.VolumeCondition =(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_VC_AV;
		//触发条件（立即）
		pInputOrder.ContingentCondition=(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_CC_Immediately;
		//强平原因（非强平）
		pInputOrder.ForceCloseReason=(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_FCC_NotForceClose;
		//组合投机套保标志（投机）
		setBytesData(pInputOrder.CombHedgeFlag,"1");
		//组合开平标志（开仓）
		setBytesData(pInputOrder.CombOffsetFlag,"0");
		if (trade.getCombOffsetFlag() == ProjectConstant.TRADE_COMB_OFFSET_FLAG_CLOSE) {
			setBytesData(pInputOrder.CombOffsetFlag,"1"); // 平仓
		}
		setBytesData(pInputOrder.GTDDate, "");

		///自动挂起标志
		pInputOrder.IsAutoSuspend=0;


		pInputOrder.MinVolume=1;//最小数量
		pInputOrder.LimitPrice=trade.getLimitPrice() + ProjectConstant.TRADE_LIMIT_PRICE_RANGE;//价格范围
		pInputOrder.VolumeTotalOriginal= trade.getVolumeTotalOriginal(); //数量
		pInputOrder.StopPrice= trade.getStopPrice();//止损价
		requestIDManager.put(String.valueOf(trade.getId()), trade);
		instance.ReqOrderInsert(handle,pInputOrder, trade.getId());
		// 睡眠三次每次一秒，等待下单结果
		int i = 0;
		Result result = ResultGenerator.genFailResult("委托成功", ResultCode.SUCCESS);
		try {
			while (insertOrderResult == null) {
				Thread.sleep(1000);
				i++;
				if (i == MAX_WAIT_TIMES) {
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (insertOrderResult != null){
			result  = insertOrderResult;
			insertOrderResult = null;
		}

		return result;
	}

	//查询资金账号
	public void queryAccountId(){
		CThostFtdcQryTradingAccountField.ByReference  pInputOrder = new CThostFtdcQryTradingAccountField.ByReference();
		pInputOrder.BrokerID= brokerID.getBytes();//经济公司代码 : 8000
		pInputOrder.InvestorID = name.getBytes();//投资者代码
		int reqOrderInsert = instance.ReqQryTradingAccount(handle,pInputOrder, requestID);
		System.out.println("###查询资金账号请求 ： " + reqOrderInsert);
	}


	////确认结算单
	public void ReqSettlementInfoConfirm(){
		CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm = new CThostFtdcSettlementInfoConfirmField.ByReference();
		pSettlementInfoConfirm.BrokerID = brokerID.getBytes();//经纪公司代码
		pSettlementInfoConfirm.InvestorID = name.getBytes();//投资者代码
		int infoConfirm = instance.ReqSettlementInfoConfirm(handle,pSettlementInfoConfirm,requestID);
		System.out.println("###确认结算单 : " + infoConfirm);
	}

	///请求查询投资者持仓明细响应
	public void queryPosition(){
		CThostFtdcQryInvestorPositionDetailField.ByReference pQryInvestorPositionDetail = new CThostFtdcQryInvestorPositionDetailField.ByReference ();
		pQryInvestorPositionDetail.BrokerID = brokerID.getBytes();//经纪公司代码
		pQryInvestorPositionDetail.InvestorID = name.getBytes();///合约代码
		//pQryInvestorPositionDetail.InstrumentID = instrumentID.getBytes();///合约代码
		//pQryInvestorPositionDetail.ExchangeID = ExchangeID.getBytes();//交易所代码
		//pQryInvestorPositionDetail.InvestUnitID = InvestUnitID.getBytes();//投资单元代码
		int result =  instance.ReqQryInvestorPositionDetail(handle, pQryInvestorPositionDetail, requestID);
		System.out.println("###请求查询投资者持仓明细响应 : " + result);
	}


	//查询合约
	public void queryInstrument(){
		CThostFtdcQryInstrumentField.ByReference pQryInstrument = new CThostFtdcQryInstrumentField.ByReference();
		int result = instance.ReqQryInstrument(handle, pQryInstrument, requestID);
		System.out.println("###查询合约 : " + result);
	}


	//登出
	public void goOut(){
		CThostFtdcUserLogoutField.ByReference pUserLogout = new CThostFtdcUserLogoutField.ByReference();
		pUserLogout.BrokerID = brokerID.getBytes();///经纪公司代码
		pUserLogout.UserID = name.getBytes();///经纪公司代码
		int result =  instance.ReqUserLogout(handle, pUserLogout,requestID);
		System.out.println("###查询合约 : " + result);
	}

	//用户口令更新请求
	public void updatePwd(){
		CThostFtdcUserPasswordUpdateField.ByReference pUserPasswordUpdate= new CThostFtdcUserPasswordUpdateField.ByReference();
		setBytesData(pUserPasswordUpdate.BrokerID, brokerID);///经纪公司代码
		setBytesData(pUserPasswordUpdate.UserID, name);///经纪公司代码
		setBytesData(pUserPasswordUpdate.OldPassword, "111111");
		setBytesData(pUserPasswordUpdate.NewPassword, "123456");
		int result =  instance.ReqUserPasswordUpdate(handle, pUserPasswordUpdate, requestID);
		System.out.println("###用户口令更新请求 : " + result);
	}

	///报单操作请求(撤单)
	public void goCancel(){
		CThostFtdcInputOrderActionField.ByReference pInputOrderAction = new CThostFtdcInputOrderActionField.ByReference();
		setBytesData(pInputOrderAction.BrokerID, brokerID);//经纪公司代码
		setBytesData(pInputOrderAction.InvestorID , name);///投资者代码
		setBytesData(pInputOrderAction.UserID , name);///用户id
		setBytesData(pInputOrderAction.ExchangeID , exchangeID);///交易所代码
		setBytesData(pInputOrderAction.OrderSysID , orderSysID);///报单编号

		pInputOrderAction.ActionFlag=(byte)ThostFtdcUserApiDataTypeLibrary.THOST_FTDC_AF_Delete ;

		int result =  instance.ReqOrderAction(handle, pInputOrderAction,requestID);
		System.out.println("###报单操作请求(撤单) : " + result);
	}

	//请求查询投资者持仓
	public void queryPos(){
		CThostFtdcQryInvestorPositionField.ByReference pQryInvestorPosition = new CThostFtdcQryInvestorPositionField.ByReference();
		pQryInvestorPosition.BrokerID = brokerID.getBytes();//经纪公司代码
		pQryInvestorPosition.InvestorID = name.getBytes();///投资者代码
		//pQryInvestorPosition.InstrumentID = instrumentID.getBytes();///合约代码
		//pQryInvestorPosition.ExchangeID = ExchangeID.getBytes();///交易所代码
		//pQryInvestorPosition.InvestUnitID = InvestUnitID.getBytes();///交易所代码

		int result =  instance.ReqQryInvestorPosition(handle, pQryInvestorPosition, requestID);
		System.out.println("###请求查询投资者持仓 : " + result);
	}

	/////请求查询报单（查询委托）
	public void qryOrder(){
		CThostFtdcQryOrderField.ByReference pQryOrder = new CThostFtdcQryOrderField.ByReference ();
		pQryOrder.BrokerID = brokerID.getBytes();//经纪公司代码
		pQryOrder.InvestorID = name.getBytes();///投资者代码
		pQryOrder.InstrumentID = instrumentID.getBytes();///合约代码
		//pQryOrder.ExchangeID = ExchangeID.getBytes();///交易所代码
		//pQryOrder.OrderSysID = OrderSysID.getBytes();///报单编号
		int result = instance.ReqQryOrder(handle, pQryOrder, requestID);
		System.out.println("###请求查询报单（查询委托） : " + result);
	}

	///请求查询成交
	public void qryTrade(){
		CThostFtdcQryTradeField.ByReference pQryTrade = new CThostFtdcQryTradeField.ByReference ();
		pQryTrade.BrokerID = brokerID.getBytes();//经纪公司代码
		pQryTrade.InvestorID = name.getBytes();///投资者代码
		pQryTrade.InstrumentID = instrumentID.getBytes();///合约代码
		//pQryTrade.ExchangeID = ExchangeID.getBytes();///交易所代码
		//pQryTrade.TradeID = TradeID.getBytes();///成交编号
		int result = instance.ReqQryTrade( handle, pQryTrade, requestID);
		System.out.println("###请求查询成交 : " + result);
	}

	public static int bytesToInt(byte[] src, int offset) {
		int value;
		value = (int) ((src[offset] & 0xFF)
				| ((src[offset+1] & 0xFF)<<8)
				| ((src[offset+2] & 0xFF)<<16)
				| ((src[offset+3] & 0xFF)<<24));
		return value;
	}


}







