package com.bjst.dgt.third.yifu;

import com.bjst.dgt.third.yifu.struct.*;
import com.sun.jna.Callback;
import com.sun.jna.Library;
import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class JNA {
	
    // 定义接口CLibrary，继承自com.sun.jna.Library
	public interface TradeApi extends Library {
		public interface cbOnFrontConnected extends Callback {
			///当客户端与交易后台建立起通信连接时（还未登录前），该方法被调用。
			public void OnFrontConnected();
		};

		public interface cbOnFrontDisconnected extends Callback {
			///当客户端与交易后台通信连接断开时，该方法被调用。当发生这个情况后，API会自动重新连接，客户端可不做处理。
			///@param nReason 错误原因
			///        0x1001 网络读失败
			///        0x1002 网络写失败
			///        0x2001 接收心跳超时
			///        0x2002 发送心跳失败
			///        0x2003 收到错误报文
			public void OnFrontDisconnected(int nReason);
		};
		
		public interface cbOnHeartBeatWarning extends Callback {
			///心跳超时警告。当长时间未收到报文时，该方法被调用。
			///@param nTimeLapse 距离上次接收报文的时间
			public void OnHeartBeatWarning(int nTimeLapse);
		}
		
		public interface cbOnRspAuthenticate extends Callback {
			///客户端认证响应
			public void OnRspAuthenticate(CThostFtdcRspAuthenticateField.ByReference pRspAuthenticateField, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspUserLogin extends Callback {
			///登录请求响应
			public void OnRspUserLogin(CThostFtdcRspUserLoginField.ByReference pRspUserLogin, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspUserLogout extends Callback {
			///登出请求响应
			public void OnRspUserLogout(CThostFtdcUserLogoutField.ByReference pUserLogout, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspUserPasswordUpdate extends Callback {
			///用户口令更新请求响应
			public void OnRspUserPasswordUpdate(CThostFtdcUserPasswordUpdateField.ByReference pUserPasswordUpdate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspTradingAccountPasswordUpdate extends Callback {
			///资金账户口令更新请求响应
			public void OnRspTradingAccountPasswordUpdate(CThostFtdcTradingAccountPasswordUpdateField.ByReference pTradingAccountPasswordUpdate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspOrderInsert extends Callback {
			///报单录入请求响应
			public void OnRspOrderInsert(CThostFtdcInputOrderField.ByReference pInputOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspParkedOrderInsert extends Callback {
			///预埋单录入请求响应
			public void OnRspParkedOrderInsert(CThostFtdcParkedOrderField.ByReference pParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspParkedOrderAction extends Callback {
			///预埋撤单录入请求响应
			public void OnRspParkedOrderAction(CThostFtdcParkedOrderActionField.ByReference pParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspOrderAction extends Callback {
			///报单操作请求响应
			public void OnRspOrderAction(CThostFtdcInputOrderActionField.ByReference pInputOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQueryMaxOrderVolume extends Callback {
			///查询最大报单数量响应
			public void OnRspQueryMaxOrderVolume(CThostFtdcQueryMaxOrderVolumeField.ByReference pQueryMaxOrderVolume, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspSettlementInfoConfirm extends Callback {
			///投资者结算结果确认响应
			public void OnRspSettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspRemoveParkedOrder extends Callback {
			///删除预埋单响应
			public void OnRspRemoveParkedOrder(CThostFtdcRemoveParkedOrderField.ByReference pRemoveParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspRemoveParkedOrderAction extends Callback {
			///删除预埋撤单响应
			public void OnRspRemoveParkedOrderAction(CThostFtdcRemoveParkedOrderActionField.ByReference pRemoveParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspExecOrderInsert extends Callback {
			///执行宣告录入请求响应
			public void OnRspExecOrderInsert(CThostFtdcInputExecOrderField.ByReference pInputExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspExecOrderAction extends Callback {
			///执行宣告操作请求响应
			public void OnRspExecOrderAction(CThostFtdcInputExecOrderActionField.ByReference pInputExecOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspForQuoteInsert extends Callback {
			///询价录入请求响应
			public void OnRspForQuoteInsert(CThostFtdcInputForQuoteField.ByReference pInputForQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQuoteInsert extends Callback {
			///报价录入请求响应
			public void OnRspQuoteInsert(CThostFtdcInputQuoteField.ByReference pInputQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQuoteAction extends Callback {
			///报价操作请求响应
			public void OnRspQuoteAction(CThostFtdcInputQuoteActionField.ByReference pInputQuoteAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspBatchOrderAction extends Callback {
			///批量报单操作请求响应
			public void OnRspBatchOrderAction(CThostFtdcInputBatchOrderActionField.ByReference pInputBatchOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspOptionSelfCloseInsert extends Callback {
			///期权自对冲录入请求响应
			public void OnRspOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField.ByReference pInputOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspOptionSelfCloseAction extends Callback {
			///期权自对冲操作请求响应
			public void OnRspOptionSelfCloseAction(CThostFtdcInputOptionSelfCloseActionField.ByReference pInputOptionSelfCloseAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspCombActionInsert extends Callback {
			///申请组合录入请求响应
			public void OnRspCombActionInsert(CThostFtdcInputCombActionField.ByReference pInputCombAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryOrder extends Callback {
			///请求查询报单响应
			public void OnRspQryOrder(CThostFtdcOrderField.ByReference pOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTrade extends Callback {
			///请求查询成交响应
			public void OnRspQryTrade(CThostFtdcTradeField.ByReference pTrade, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestorPosition extends Callback {
			///请求查询投资者持仓响应
			public void OnRspQryInvestorPosition(CThostFtdcInvestorPositionField.ByReference pInvestorPosition, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTradingAccount extends Callback {
			///请求查询资金账户响应
			public void OnRspQryTradingAccount(CThostFtdcTradingAccountField.ByReference pTradingAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestor extends Callback {
			///请求查询投资者响应
			public void OnRspQryInvestor(CThostFtdcInvestorField.ByReference pInvestor, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTradingCode extends Callback {
			///请求查询交易编码响应
			public void OnRspQryTradingCode(CThostFtdcTradingCodeField.ByReference pTradingCode, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInstrumentMarginRate extends Callback {
			///请求查询合约保证金率响应
			public void OnRspQryInstrumentMarginRate(CThostFtdcInstrumentMarginRateField.ByReference pInstrumentMarginRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInstrumentCommissionRate extends Callback {
			///请求查询合约手续费率响应
			public void OnRspQryInstrumentCommissionRate(CThostFtdcInstrumentCommissionRateField.ByReference pInstrumentCommissionRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryExchange extends Callback {
			///请求查询交易所响应
			public void OnRspQryExchange(CThostFtdcExchangeField.ByReference pExchange, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryProduct extends Callback {
			///请求查询产品响应
			public void OnRspQryProduct(CThostFtdcProductField.ByReference pProduct, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInstrument extends Callback {
			///请求查询合约响应
			public void OnRspQryInstrument(CThostFtdcInstrumentField.ByReference pInstrument, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryDepthMarketData extends Callback {
			///请求查询行情响应
			public void OnRspQryDepthMarketData(CThostFtdcDepthMarketDataField.ByReference pDepthMarketData, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQrySettlementInfo extends Callback {
			///请求查询投资者结算结果响应
			public void OnRspQrySettlementInfo(CThostFtdcSettlementInfoField.ByReference pSettlementInfo, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTransferBank extends Callback {
			///请求查询转帐银行响应
			public void OnRspQryTransferBank(CThostFtdcTransferBankField.ByReference pTransferBank, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestorPositionDetail extends Callback {
			///请求查询投资者持仓明细响应
			public void OnRspQryInvestorPositionDetail(CThostFtdcInvestorPositionDetailField.ByReference pInvestorPositionDetail, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryNotice extends Callback {
			///请求查询客户通知响应
			public void OnRspQryNotice(CThostFtdcNoticeField.ByReference pNotice, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQrySettlementInfoConfirm extends Callback {
			///请求查询结算信息确认响应
			public void OnRspQrySettlementInfoConfirm(CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestorPositionCombineDetail extends Callback {
			///请求查询投资者持仓明细响应
			public void OnRspQryInvestorPositionCombineDetail(CThostFtdcInvestorPositionCombineDetailField.ByReference pInvestorPositionCombineDetail, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryCFMMCTradingAccountKey extends Callback {
			///查询保证金监管系统经纪公司资金账户密钥响应
			public void OnRspQryCFMMCTradingAccountKey(CThostFtdcCFMMCTradingAccountKeyField.ByReference pCFMMCTradingAccountKey, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryEWarrantOffset extends Callback {
			///请求查询仓单折抵信息响应
			public void OnRspQryEWarrantOffset(CThostFtdcEWarrantOffsetField.ByReference pEWarrantOffset, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestorProductGroupMargin extends Callback {
			///请求查询投资者品种/跨品种保证金响应
			public void OnRspQryInvestorProductGroupMargin(CThostFtdcInvestorProductGroupMarginField.ByReference pInvestorProductGroupMargin, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryExchangeMarginRate extends Callback {
			///请求查询交易所保证金率响应
			public void OnRspQryExchangeMarginRate(CThostFtdcExchangeMarginRateField.ByReference pExchangeMarginRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryExchangeMarginRateAdjust extends Callback {
			///请求查询交易所调整保证金率响应
			public void OnRspQryExchangeMarginRateAdjust(CThostFtdcExchangeMarginRateAdjustField.ByReference pExchangeMarginRateAdjust, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryExchangeRate extends Callback {
			///请求查询汇率响应
			public void OnRspQryExchangeRate(CThostFtdcExchangeRateField.ByReference pExchangeRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQrySecAgentACIDMap extends Callback {
			///请求查询二级代理操作员银期权限响应
			public void OnRspQrySecAgentACIDMap(CThostFtdcSecAgentACIDMapField.ByReference pSecAgentACIDMap, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryProductExchRate extends Callback {
			///请求查询产品报价汇率
			public void OnRspQryProductExchRate(CThostFtdcProductExchRateField.ByReference pProductExchRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryProductGroup extends Callback {
			///请求查询产品组
			public void OnRspQryProductGroup(CThostFtdcProductGroupField.ByReference pProductGroup, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryMMInstrumentCommissionRate extends Callback {
			///请求查询做市商合约手续费率响应
			public void OnRspQryMMInstrumentCommissionRate(CThostFtdcMMInstrumentCommissionRateField.ByReference pMMInstrumentCommissionRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryMMOptionInstrCommRate extends Callback {
			///请求查询做市商期权合约手续费响应
			public void OnRspQryMMOptionInstrCommRate(CThostFtdcMMOptionInstrCommRateField.ByReference pMMOptionInstrCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInstrumentOrderCommRate extends Callback {
			///请求查询报单手续费响应
			public void OnRspQryInstrumentOrderCommRate(CThostFtdcInstrumentOrderCommRateField.ByReference pInstrumentOrderCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQrySecAgentTradingAccount extends Callback {
			///请求查询资金账户响应
			public void OnRspQrySecAgentTradingAccount(CThostFtdcTradingAccountField.ByReference pTradingAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQrySecAgentCheckMode extends Callback {
			///请求查询二级代理商资金校验模式响应
			public void OnRspQrySecAgentCheckMode(CThostFtdcSecAgentCheckModeField.ByReference pSecAgentCheckMode, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryOptionInstrTradeCost extends Callback {
			///请求查询期权交易成本响应
			public void OnRspQryOptionInstrTradeCost(CThostFtdcOptionInstrTradeCostField.ByReference pOptionInstrTradeCost, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryOptionInstrCommRate extends Callback {
			///请求查询期权合约手续费响应
			public void OnRspQryOptionInstrCommRate(CThostFtdcOptionInstrCommRateField.ByReference pOptionInstrCommRate, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryExecOrder extends Callback {
			///请求查询执行宣告响应
			public void OnRspQryExecOrder(CThostFtdcExecOrderField.ByReference pExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryForQuote extends Callback {
			///请求查询询价响应
			public void OnRspQryForQuote(CThostFtdcForQuoteField.ByReference pForQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryQuote extends Callback {
			///请求查询报价响应
			public void OnRspQryQuote(CThostFtdcQuoteField.ByReference pQuote, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryOptionSelfClose extends Callback {
			///请求查询期权自对冲响应
			public void OnRspQryOptionSelfClose(CThostFtdcOptionSelfCloseField.ByReference pOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryInvestUnit extends Callback {
			///请求查询投资单元响应
			public void OnRspQryInvestUnit(CThostFtdcInvestUnitField.ByReference pInvestUnit, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryCombInstrumentGuard extends Callback {
			///请求查询组合合约安全系数响应
			public void OnRspQryCombInstrumentGuard(CThostFtdcCombInstrumentGuardField.ByReference pCombInstrumentGuard, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryCombAction extends Callback {
			///请求查询申请组合响应
			public void OnRspQryCombAction(CThostFtdcCombActionField.ByReference pCombAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTransferSerial extends Callback {
			///请求查询转帐流水响应
			public void OnRspQryTransferSerial(CThostFtdcTransferSerialField.ByReference pTransferSerial, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryAccountregister extends Callback {
			///请求查询银期签约关系响应
			public void OnRspQryAccountregister(CThostFtdcAccountregisterField.ByReference pAccountregister, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspError extends Callback {
			///错误应答
			public void OnRspError(CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRtnOrder extends Callback {
			///报单通知
			public void OnRtnOrder(CThostFtdcOrderField.ByReference pOrder);
		}

		public interface cbOnRtnTrade extends Callback {
			///成交通知
			public void OnRtnTrade(CThostFtdcTradeField.ByReference pTrade);
		}

		public interface cbOnErrRtnOrderInsert extends Callback {
			///报单录入错误回报
			public void OnErrRtnOrderInsert(CThostFtdcInputOrderField.ByReference pInputOrder, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnOrderAction extends Callback {
			///报单操作错误回报
			public void OnErrRtnOrderAction(CThostFtdcOrderActionField.ByReference pOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnInstrumentStatus extends Callback {
			///合约交易状态通知
			public void OnRtnInstrumentStatus(CThostFtdcInstrumentStatusField.ByReference pInstrumentStatus);
		}

		public interface cbOnRtnBulletin extends Callback {
			///交易所公告通知
			public void OnRtnBulletin(CThostFtdcBulletinField.ByReference pBulletin);
		}

		public interface cbOnRtnTradingNotice extends Callback {
			///交易通知
			public void OnRtnTradingNotice(CThostFtdcTradingNoticeInfoField.ByReference pTradingNoticeInfo);
		}

		public interface cbOnRtnErrorConditionalOrder extends Callback {
			///提示条件单校验错误
			public void OnRtnErrorConditionalOrder(CThostFtdcErrorConditionalOrderField.ByReference pErrorConditionalOrder);
		}

		public interface cbOnRtnExecOrder extends Callback {
			///执行宣告通知
			public void OnRtnExecOrder(CThostFtdcExecOrderField.ByReference pExecOrder);
		}

		public interface cbOnErrRtnExecOrderInsert extends Callback {
			///执行宣告录入错误回报
			public void OnErrRtnExecOrderInsert(CThostFtdcInputExecOrderField.ByReference pInputExecOrder, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnExecOrderAction extends Callback {
			///执行宣告操作错误回报
			public void OnErrRtnExecOrderAction(CThostFtdcExecOrderActionField.ByReference pExecOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnForQuoteInsert extends Callback {
			///询价录入错误回报
			public void OnErrRtnForQuoteInsert(CThostFtdcInputForQuoteField.ByReference pInputForQuote, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnQuote extends Callback {
			///报价通知
			public void OnRtnQuote(CThostFtdcQuoteField.ByReference pQuote);
		}

		public interface cbOnErrRtnQuoteInsert extends Callback {
			///报价录入错误回报
			public void OnErrRtnQuoteInsert(CThostFtdcInputQuoteField.ByReference pInputQuote, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnQuoteAction extends Callback {
			///报价操作错误回报
			public void OnErrRtnQuoteAction(CThostFtdcQuoteActionField.ByReference pQuoteAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnForQuoteRsp extends Callback {
			///询价通知
			public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField.ByReference pForQuoteRsp);
		}

		public interface cbOnRtnCFMMCTradingAccountToken extends Callback {
			///保证金监控中心用户令牌
			public void OnRtnCFMMCTradingAccountToken(CThostFtdcCFMMCTradingAccountTokenField.ByReference pCFMMCTradingAccountToken);
		}

		public interface cbOnErrRtnBatchOrderAction extends Callback {
			///批量报单操作错误回报
			public void OnErrRtnBatchOrderAction(CThostFtdcBatchOrderActionField.ByReference pBatchOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnOptionSelfClose extends Callback {
			///期权自对冲通知
			public void OnRtnOptionSelfClose(CThostFtdcOptionSelfCloseField.ByReference pOptionSelfClose);
		}

		public interface cbOnErrRtnOptionSelfCloseInsert extends Callback {
			///期权自对冲录入错误回报
			public void OnErrRtnOptionSelfCloseInsert(CThostFtdcInputOptionSelfCloseField.ByReference pInputOptionSelfClose, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnOptionSelfCloseAction extends Callback {
			///期权自对冲操作错误回报
			public void OnErrRtnOptionSelfCloseAction(CThostFtdcOptionSelfCloseActionField.ByReference pOptionSelfCloseAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnCombAction extends Callback {
			///申请组合通知
			public void OnRtnCombAction(CThostFtdcCombActionField.ByReference pCombAction);
		}

		public interface cbOnErrRtnCombActionInsert extends Callback {
			///申请组合录入错误回报
			public void OnErrRtnCombActionInsert(CThostFtdcInputCombActionField.ByReference pInputCombAction, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRspQryContractBank extends Callback {
			///请求查询签约银行响应
			public void OnRspQryContractBank(CThostFtdcContractBankField.ByReference pContractBank, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryParkedOrder extends Callback {
			///请求查询预埋单响应
			public void OnRspQryParkedOrder(CThostFtdcParkedOrderField.ByReference pParkedOrder, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryParkedOrderAction extends Callback {
			///请求查询预埋撤单响应
			public void OnRspQryParkedOrderAction(CThostFtdcParkedOrderActionField.ByReference pParkedOrderAction, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryTradingNotice extends Callback {
			///请求查询交易通知响应
			public void OnRspQryTradingNotice(CThostFtdcTradingNoticeField.ByReference pTradingNotice, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryBrokerTradingParams extends Callback {
			///请求查询经纪公司交易参数响应
			public void OnRspQryBrokerTradingParams(CThostFtdcBrokerTradingParamsField.ByReference pBrokerTradingParams, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQryBrokerTradingAlgos extends Callback {
			///请求查询经纪公司交易算法响应
			public void OnRspQryBrokerTradingAlgos(CThostFtdcBrokerTradingAlgosField.ByReference pBrokerTradingAlgos, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQueryCFMMCTradingAccountToken extends Callback {
			///请求查询监控中心用户令牌
			public void OnRspQueryCFMMCTradingAccountToken(CThostFtdcQueryCFMMCTradingAccountTokenField.ByReference pQueryCFMMCTradingAccountToken, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRtnFromBankToFutureByBank extends Callback {
			///银行发起银行资金转期货通知
			public void OnRtnFromBankToFutureByBank(CThostFtdcRspTransferField.ByReference pRspTransfer);
		}

		public interface cbOnRtnFromFutureToBankByBank extends Callback {
			///银行发起期货资金转银行通知
			public void OnRtnFromFutureToBankByBank(CThostFtdcRspTransferField.ByReference pRspTransfer);
		}

		public interface cbOnRtnRepealFromBankToFutureByBank extends Callback {
			///银行发起冲正银行转期货通知
			public void OnRtnRepealFromBankToFutureByBank(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRtnRepealFromFutureToBankByBank extends Callback {
			///银行发起冲正期货转银行通知
			public void OnRtnRepealFromFutureToBankByBank(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRtnFromBankToFutureByFuture extends Callback {
			///期货发起银行资金转期货通知
			public void OnRtnFromBankToFutureByFuture(CThostFtdcRspTransferField.ByReference pRspTransfer);
		}

		public interface cbOnRtnFromFutureToBankByFuture extends Callback {
			///期货发起期货资金转银行通知
			public void OnRtnFromFutureToBankByFuture(CThostFtdcRspTransferField.ByReference pRspTransfer);
		}

		public interface cbOnRtnRepealFromBankToFutureByFutureManual extends Callback {
			///系统运行时期货端手工发起冲正银行转期货请求，银行处理完毕后报盘发回的通知
			public void OnRtnRepealFromBankToFutureByFutureManual(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRtnRepealFromFutureToBankByFutureManual extends Callback {
			///系统运行时期货端手工发起冲正期货转银行请求，银行处理完毕后报盘发回的通知
			public void OnRtnRepealFromFutureToBankByFutureManual(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRtnQueryBankBalanceByFuture extends Callback {
			///期货发起查询银行余额通知
			public void OnRtnQueryBankBalanceByFuture(CThostFtdcNotifyQueryAccountField.ByReference pNotifyQueryAccount);
		}

		public interface cbOnErrRtnBankToFutureByFuture extends Callback {
			///期货发起银行资金转期货错误回报
			public void OnErrRtnBankToFutureByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnFutureToBankByFuture extends Callback {
			///期货发起期货资金转银行错误回报
			public void OnErrRtnFutureToBankByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnRepealBankToFutureByFutureManual extends Callback {
			///系统运行时期货端手工发起冲正银行转期货错误回报
			public void OnErrRtnRepealBankToFutureByFutureManual(CThostFtdcReqRepealField.ByReference pReqRepeal, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnRepealFutureToBankByFutureManual extends Callback {
			///系统运行时期货端手工发起冲正期货转银行错误回报
			public void OnErrRtnRepealFutureToBankByFutureManual(CThostFtdcReqRepealField.ByReference pReqRepeal, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnErrRtnQueryBankBalanceByFuture extends Callback {
			///期货发起查询银行余额错误回报
			public void OnErrRtnQueryBankBalanceByFuture(CThostFtdcReqQueryAccountField.ByReference pReqQueryAccount, CThostFtdcRspInfoField.ByReference pRspInfo);
		}

		public interface cbOnRtnRepealFromBankToFutureByFuture extends Callback {
			///期货发起冲正银行转期货请求，银行处理完毕后报盘发回的通知
			public void OnRtnRepealFromBankToFutureByFuture(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRtnRepealFromFutureToBankByFuture extends Callback {
			///期货发起冲正期货转银行请求，银行处理完毕后报盘发回的通知
			public void OnRtnRepealFromFutureToBankByFuture(CThostFtdcRspRepealField.ByReference pRspRepeal);
		}

		public interface cbOnRspFromBankToFutureByFuture extends Callback {
			///期货发起银行资金转期货应答
			public void OnRspFromBankToFutureByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspFromFutureToBankByFuture extends Callback {
			///期货发起期货资金转银行应答
			public void OnRspFromFutureToBankByFuture(CThostFtdcReqTransferField.ByReference pReqTransfer, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRspQueryBankAccountMoneyByFuture extends Callback {
			///期货发起查询银行余额应答
			public void OnRspQueryBankAccountMoneyByFuture(CThostFtdcReqQueryAccountField.ByReference pReqQueryAccount, CThostFtdcRspInfoField.ByReference pRspInfo, int nRequestID, boolean bIsLast);
		}

		public interface cbOnRtnOpenAccountByBank extends Callback {
			///银行发起银期开户通知
			public void OnRtnOpenAccountByBank(CThostFtdcOpenAccountField.ByReference pOpenAccount);
		}

		public interface cbOnRtnCancelAccountByBank extends Callback {
			///银行发起银期销户通知
			public void OnRtnCancelAccountByBank(CThostFtdcCancelAccountField.ByReference pCancelAccount);
		}

		public interface cbOnRtnChangeAccountByBank extends Callback {
			///银行发起变更银行账号通知
			public void OnRtnChangeAccountByBank(CThostFtdcChangeAccountField.ByReference pChangeAccount);
		}

		//////////////////////////////////////////////////////////

		public static class JavaCallback extends Structure {
			public cbOnFrontConnected OnFrontConnected;
			public cbOnFrontDisconnected OnFrontDisconnected;
			public cbOnHeartBeatWarning OnHeartBeatWarning;
			public cbOnRspAuthenticate OnRspAuthenticate;
			public cbOnRspUserLogin OnRspUserLogin;
			public cbOnRspUserLogout OnRspUserLogout;
			public cbOnRspUserPasswordUpdate OnRspUserPasswordUpdate;
			public cbOnRspTradingAccountPasswordUpdate OnRspTradingAccountPasswordUpdate;
			public cbOnRspOrderInsert OnRspOrderInsert;
			public cbOnRspParkedOrderInsert OnRspParkedOrderInsert;
			public cbOnRspParkedOrderAction OnRspParkedOrderAction;
			public cbOnRspOrderAction OnRspOrderAction;
			public cbOnRspQueryMaxOrderVolume OnRspQueryMaxOrderVolume;
			public cbOnRspSettlementInfoConfirm OnRspSettlementInfoConfirm;
			public cbOnRspRemoveParkedOrder OnRspRemoveParkedOrder;
			public cbOnRspRemoveParkedOrderAction OnRspRemoveParkedOrderAction;
			public cbOnRspExecOrderInsert OnRspExecOrderInsert;
			public cbOnRspExecOrderAction OnRspExecOrderAction;
			public cbOnRspForQuoteInsert OnRspForQuoteInsert;
			public cbOnRspQuoteInsert OnRspQuoteInsert;
			public cbOnRspQuoteAction OnRspQuoteAction;
			public cbOnRspBatchOrderAction OnRspBatchOrderAction;
			public cbOnRspOptionSelfCloseInsert OnRspOptionSelfCloseInsert;
			public cbOnRspOptionSelfCloseAction OnRspOptionSelfCloseAction;
			public cbOnRspCombActionInsert OnRspCombActionInsert;
			public cbOnRspQryOrder OnRspQryOrder;
			public cbOnRspQryTrade OnRspQryTrade;
			public cbOnRspQryInvestorPosition OnRspQryInvestorPosition;
			public cbOnRspQryTradingAccount OnRspQryTradingAccount;
			public cbOnRspQryInvestor OnRspQryInvestor;
			public cbOnRspQryTradingCode OnRspQryTradingCode;
			public cbOnRspQryInstrumentMarginRate OnRspQryInstrumentMarginRate;
			public cbOnRspQryInstrumentCommissionRate OnRspQryInstrumentCommissionRate;
			public cbOnRspQryExchange OnRspQryExchange;
			public cbOnRspQryProduct OnRspQryProduct;
			public cbOnRspQryInstrument OnRspQryInstrument;
			public cbOnRspQryDepthMarketData OnRspQryDepthMarketData;
			public cbOnRspQrySettlementInfo OnRspQrySettlementInfo;
			public cbOnRspQryTransferBank OnRspQryTransferBank;
			public cbOnRspQryInvestorPositionDetail OnRspQryInvestorPositionDetail;
			public cbOnRspQryNotice OnRspQryNotice;
			public cbOnRspQrySettlementInfoConfirm OnRspQrySettlementInfoConfirm;
			public cbOnRspQryInvestorPositionCombineDetail OnRspQryInvestorPositionCombineDetail;
			public cbOnRspQryCFMMCTradingAccountKey OnRspQryCFMMCTradingAccountKey;
			public cbOnRspQryEWarrantOffset OnRspQryEWarrantOffset;
			public cbOnRspQryInvestorProductGroupMargin OnRspQryInvestorProductGroupMargin;
			public cbOnRspQryExchangeMarginRate OnRspQryExchangeMarginRate;
			public cbOnRspQryExchangeMarginRateAdjust OnRspQryExchangeMarginRateAdjust;
			public cbOnRspQryExchangeRate OnRspQryExchangeRate;
			public cbOnRspQrySecAgentACIDMap OnRspQrySecAgentACIDMap;
			public cbOnRspQryProductExchRate OnRspQryProductExchRate;
			public cbOnRspQryProductGroup OnRspQryProductGroup;
			public cbOnRspQryMMInstrumentCommissionRate OnRspQryMMInstrumentCommissionRate;
			public cbOnRspQryMMOptionInstrCommRate OnRspQryMMOptionInstrCommRate;
			public cbOnRspQryInstrumentOrderCommRate OnRspQryInstrumentOrderCommRate;
			public cbOnRspQrySecAgentTradingAccount OnRspQrySecAgentTradingAccount;
			public cbOnRspQrySecAgentCheckMode OnRspQrySecAgentCheckMode;
			public cbOnRspQryOptionInstrTradeCost OnRspQryOptionInstrTradeCost;
			public cbOnRspQryOptionInstrCommRate OnRspQryOptionInstrCommRate;
			public cbOnRspQryExecOrder OnRspQryExecOrder;
			public cbOnRspQryForQuote OnRspQryForQuote;
			public cbOnRspQryQuote OnRspQryQuote;
			public cbOnRspQryOptionSelfClose OnRspQryOptionSelfClose;
			public cbOnRspQryInvestUnit OnRspQryInvestUnit;
			public cbOnRspQryCombInstrumentGuard OnRspQryCombInstrumentGuard;
			public cbOnRspQryCombAction OnRspQryCombAction;
			public cbOnRspQryTransferSerial OnRspQryTransferSerial;
			public cbOnRspQryAccountregister OnRspQryAccountregister;
			public cbOnRspError OnRspError;
			public cbOnRtnOrder OnRtnOrder;
			public cbOnRtnTrade OnRtnTrade;
			public cbOnErrRtnOrderInsert OnErrRtnOrderInsert;
			public cbOnErrRtnOrderAction OnErrRtnOrderAction;
			public cbOnRtnInstrumentStatus OnRtnInstrumentStatus;
			public cbOnRtnBulletin OnRtnBulletin;
			public cbOnRtnTradingNotice OnRtnTradingNotice;
			public cbOnRtnErrorConditionalOrder OnRtnErrorConditionalOrder;
			public cbOnRtnExecOrder OnRtnExecOrder;
			public cbOnErrRtnExecOrderInsert OnErrRtnExecOrderInsert;
			public cbOnErrRtnExecOrderAction OnErrRtnExecOrderAction;
			public cbOnErrRtnForQuoteInsert OnErrRtnForQuoteInsert;
			public cbOnRtnQuote OnRtnQuote;
			public cbOnErrRtnQuoteInsert OnErrRtnQuoteInsert;
			public cbOnErrRtnQuoteAction OnErrRtnQuoteAction;
			public cbOnRtnForQuoteRsp OnRtnForQuoteRsp;
			public cbOnRtnCFMMCTradingAccountToken OnRtnCFMMCTradingAccountToken;
			public cbOnErrRtnBatchOrderAction OnErrRtnBatchOrderAction;
			public cbOnRtnOptionSelfClose OnRtnOptionSelfClose;
			public cbOnErrRtnOptionSelfCloseInsert OnErrRtnOptionSelfCloseInsert;
			public cbOnErrRtnOptionSelfCloseAction OnErrRtnOptionSelfCloseAction;
			public cbOnRtnCombAction OnRtnCombAction;
			public cbOnErrRtnCombActionInsert OnErrRtnCombActionInsert;
			public cbOnRspQryContractBank OnRspQryContractBank;
			public cbOnRspQryParkedOrder OnRspQryParkedOrder;
			public cbOnRspQryParkedOrderAction OnRspQryParkedOrderAction;
			public cbOnRspQryTradingNotice OnRspQryTradingNotice;
			public cbOnRspQryBrokerTradingParams OnRspQryBrokerTradingParams;
			public cbOnRspQryBrokerTradingAlgos OnRspQryBrokerTradingAlgos;
			public cbOnRspQueryCFMMCTradingAccountToken OnRspQueryCFMMCTradingAccountToken;
			public cbOnRtnFromBankToFutureByBank OnRtnFromBankToFutureByBank;
			public cbOnRtnFromFutureToBankByBank OnRtnFromFutureToBankByBank;
			public cbOnRtnRepealFromBankToFutureByBank OnRtnRepealFromBankToFutureByBank;
			public cbOnRtnRepealFromFutureToBankByBank OnRtnRepealFromFutureToBankByBank;
			public cbOnRtnFromBankToFutureByFuture OnRtnFromBankToFutureByFuture;
			public cbOnRtnFromFutureToBankByFuture OnRtnFromFutureToBankByFuture;
			public cbOnRtnRepealFromBankToFutureByFutureManual OnRtnRepealFromBankToFutureByFutureManual;
			public cbOnRtnRepealFromFutureToBankByFutureManual OnRtnRepealFromFutureToBankByFutureManual;
			public cbOnRtnQueryBankBalanceByFuture OnRtnQueryBankBalanceByFuture;
			public cbOnErrRtnBankToFutureByFuture OnErrRtnBankToFutureByFuture;
			public cbOnErrRtnFutureToBankByFuture OnErrRtnFutureToBankByFuture;
			public cbOnErrRtnRepealBankToFutureByFutureManual OnErrRtnRepealBankToFutureByFutureManual;
			public cbOnErrRtnRepealFutureToBankByFutureManual OnErrRtnRepealFutureToBankByFutureManual;
			public cbOnErrRtnQueryBankBalanceByFuture OnErrRtnQueryBankBalanceByFuture;
			public cbOnRtnRepealFromBankToFutureByFuture OnRtnRepealFromBankToFutureByFuture;
			public cbOnRtnRepealFromFutureToBankByFuture OnRtnRepealFromFutureToBankByFuture;
			public cbOnRspFromBankToFutureByFuture OnRspFromBankToFutureByFuture;
			public cbOnRspFromFutureToBankByFuture OnRspFromFutureToBankByFuture;
			public cbOnRspQueryBankAccountMoneyByFuture OnRspQueryBankAccountMoneyByFuture;
			public cbOnRtnOpenAccountByBank OnRtnOpenAccountByBank;
			public cbOnRtnCancelAccountByBank OnRtnCancelAccountByBank;
			public cbOnRtnChangeAccountByBank OnRtnChangeAccountByBank;

	        public static class ByReference extends JavaCallback implements Structure.ByReference {}
	        public static class ByValue extends JavaCallback implements Structure.ByValue {}

	        @SuppressWarnings({ "rawtypes", "unchecked" })
	        @Override
	        protected List getFieldOrder() {
	            List a = new ArrayList();
	            a.add("OnFrontConnected");
	            a.add("OnFrontDisconnected");
	            a.add("OnHeartBeatWarning");
	            a.add("OnRspAuthenticate");
	            a.add("OnRspUserLogin");
	            a.add("OnRspUserLogout");
	            a.add("OnRspUserPasswordUpdate");
	            a.add("OnRspTradingAccountPasswordUpdate");
	            a.add("OnRspOrderInsert");
	            a.add("OnRspParkedOrderInsert");
	            a.add("OnRspParkedOrderAction");
	            a.add("OnRspOrderAction");
	            a.add("OnRspQueryMaxOrderVolume");
	            a.add("OnRspSettlementInfoConfirm");
	            a.add("OnRspRemoveParkedOrder");
	            a.add("OnRspRemoveParkedOrderAction");
	            a.add("OnRspExecOrderInsert");
	            a.add("OnRspExecOrderAction");
	            a.add("OnRspForQuoteInsert");
	            a.add("OnRspQuoteInsert");
	            a.add("OnRspQuoteAction");
	            a.add("OnRspBatchOrderAction");
	            a.add("OnRspOptionSelfCloseInsert");
	            a.add("OnRspOptionSelfCloseAction");
	            a.add("OnRspCombActionInsert");
	            a.add("OnRspQryOrder");
	            a.add("OnRspQryTrade");
	            a.add("OnRspQryInvestorPosition");
	            a.add("OnRspQryTradingAccount");
	            a.add("OnRspQryInvestor");
	            a.add("OnRspQryTradingCode");
	            a.add("OnRspQryInstrumentMarginRate");
	            a.add("OnRspQryInstrumentCommissionRate");
	            a.add("OnRspQryExchange");
	            a.add("OnRspQryProduct");
	            a.add("OnRspQryInstrument");
	            a.add("OnRspQryDepthMarketData");
	            a.add("OnRspQrySettlementInfo");
	            a.add("OnRspQryTransferBank");
	            a.add("OnRspQryInvestorPositionDetail");
	            a.add("OnRspQryNotice");
	            a.add("OnRspQrySettlementInfoConfirm");
	            a.add("OnRspQryInvestorPositionCombineDetail");
	            a.add("OnRspQryCFMMCTradingAccountKey");
	            a.add("OnRspQryEWarrantOffset");
	            a.add("OnRspQryInvestorProductGroupMargin");
	            a.add("OnRspQryExchangeMarginRate");
	            a.add("OnRspQryExchangeMarginRateAdjust");
	            a.add("OnRspQryExchangeRate");
	            a.add("OnRspQrySecAgentACIDMap");
	            a.add("OnRspQryProductExchRate");
	            a.add("OnRspQryProductGroup");
	            a.add("OnRspQryMMInstrumentCommissionRate");
	            a.add("OnRspQryMMOptionInstrCommRate");
	            a.add("OnRspQryInstrumentOrderCommRate");
	            a.add("OnRspQrySecAgentTradingAccount");
	            a.add("OnRspQrySecAgentCheckMode");
	            a.add("OnRspQryOptionInstrTradeCost");
	            a.add("OnRspQryOptionInstrCommRate");
	            a.add("OnRspQryExecOrder");
	            a.add("OnRspQryForQuote");
	            a.add("OnRspQryQuote");
	            a.add("OnRspQryOptionSelfClose");
	            a.add("OnRspQryInvestUnit");
	            a.add("OnRspQryCombInstrumentGuard");
	            a.add("OnRspQryCombAction");
	            a.add("OnRspQryTransferSerial");
	            a.add("OnRspQryAccountregister");
	            a.add("OnRspError");
	            a.add("OnRtnOrder");
	            a.add("OnRtnTrade");
	            a.add("OnErrRtnOrderInsert");
	            a.add("OnErrRtnOrderAction");
	            a.add("OnRtnInstrumentStatus");
	            a.add("OnRtnBulletin");
	            a.add("OnRtnTradingNotice");
	            a.add("OnRtnErrorConditionalOrder");
	            a.add("OnRtnExecOrder");
	            a.add("OnErrRtnExecOrderInsert");
	            a.add("OnErrRtnExecOrderAction");
	            a.add("OnErrRtnForQuoteInsert");
	            a.add("OnRtnQuote");
	            a.add("OnErrRtnQuoteInsert");
	            a.add("OnErrRtnQuoteAction");
	            a.add("OnRtnForQuoteRsp");
	            a.add("OnRtnCFMMCTradingAccountToken");
	            a.add("OnErrRtnBatchOrderAction");
	            a.add("OnRtnOptionSelfClose");
	            a.add("OnErrRtnOptionSelfCloseInsert");
	            a.add("OnErrRtnOptionSelfCloseAction");
	            a.add("OnRtnCombAction");
	            a.add("OnErrRtnCombActionInsert");
	            a.add("OnRspQryContractBank");
	            a.add("OnRspQryParkedOrder");
	            a.add("OnRspQryParkedOrderAction");
	            a.add("OnRspQryTradingNotice");
	            a.add("OnRspQryBrokerTradingParams");
	            a.add("OnRspQryBrokerTradingAlgos");
	            a.add("OnRspQueryCFMMCTradingAccountToken");
	            a.add("OnRtnFromBankToFutureByBank");
	            a.add("OnRtnFromFutureToBankByBank");
	            a.add("OnRtnRepealFromBankToFutureByBank");
	            a.add("OnRtnRepealFromFutureToBankByBank");
	            a.add("OnRtnFromBankToFutureByFuture");
	            a.add("OnRtnFromFutureToBankByFuture");
	            a.add("OnRtnRepealFromBankToFutureByFutureManual");
	            a.add("OnRtnRepealFromFutureToBankByFutureManual");
	            a.add("OnRtnQueryBankBalanceByFuture");
	            a.add("OnErrRtnBankToFutureByFuture");
	            a.add("OnErrRtnFutureToBankByFuture");
	            a.add("OnErrRtnRepealBankToFutureByFutureManual");
	            a.add("OnErrRtnRepealFutureToBankByFutureManual");
	            a.add("OnErrRtnQueryBankBalanceByFuture");
	            a.add("OnRtnRepealFromBankToFutureByFuture");
	            a.add("OnRtnRepealFromFutureToBankByFuture");
	            a.add("OnRspFromBankToFutureByFuture");
	            a.add("OnRspFromFutureToBankByFuture");
	            a.add("OnRspQueryBankAccountMoneyByFuture");
	            a.add("OnRtnOpenAccountByBank");
	            a.add("OnRtnCancelAccountByBank");
	            a.add("OnRtnChangeAccountByBank");
	            return a;
	        }
	    };
		///创建TraderApi
		///@param pszFlowPath 存贮订阅信息文件的目录，默认为当前目录
		///@return 创建出的UserApi
		public long CreateHandle(String path);

		///删除接口对象本身
		///@remark 不再使用本接口对象时,调用该函数删除接口对象
		public void Release(long handle);

		///注册回调接口
		///@param pSpi 派生自回调接口类的实例
		public void RegisterSpi(long handle, JavaCallback.ByReference callback);

		///获取API的版本信息
		///@retrun 获取到的版本号
		///获取API的版本信息
		///@retrun 获取到的版本号
		public String GetApiVersion(long handle);

		///初始化
		///@remark 初始化运行环境,只有调用后,接口才开始工作
		public void Init(long handle);

		///等待接口线程结束运行
		///@return 线程退出代码
		public int Join(long handle);

		///注册前置机网络地址
		///@param pszFrontAddress：前置机网络地址。
		///@remark 网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:17001”。 
		///@remark “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”17001”代表服务器端口号。
		public void RegisterFront(long handle, String pszFrontAddress);

		///注册名字服务器网络地址
		///@param pszNsAddress：名字服务器网络地址。
		///@remark 网络地址的格式为：“protocol://ipaddress:port”，如：”tcp://127.0.0.1:12001”。 
		///@remark “tcp”代表传输协议，“127.0.0.1”代表服务器地址。”12001”代表服务器端口号。
		///@remark RegisterNameServer优先于RegisterFront
		public void RegisterNameServer(long handle, String pszNsAddress);

		///用户登录请求
		public int ReqUserLogin(long handle, CThostFtdcReqUserLoginField.ByReference pReqUserLoginField, int nRequestID);
		
		///获取当前交易日
		///@retrun 获取到的交易日
		///@remark 只有登录成功后,才能得到正确的交易日
		public String GetTradingDay();
			
		///注册名字服务器用户信息
		///@param pFensUserInfo：用户信息。
		public void RegisterFensUserInfo(long handle, CThostFtdcFensUserInfoField.ByReference pFensUserInfo);

		///订阅私有流。
		///@param nResumeType 私有流重传方式
		///        THOST_TERT_RESTART:从本交易日开始重传
		///        THOST_TERT_RESUME:从上次收到的续传
		///        THOST_TERT_QUICK:只传送登录后私有流的内容
		///@remark 该方法要在Init方法前调用。若不调用则不会收到私有流的数据。
		public void SubscribePrivateTopic(long handle, int nResumeType);

		///订阅公共流。
		///@param nResumeType 公共流重传方式
		///        THOST_TERT_RESTART:从本交易日开始重传
		///        THOST_TERT_RESUME:从上次收到的续传
		///        THOST_TERT_QUICK:只传送登录后公共流的内容
		///@remark 该方法要在Init方法前调用。若不调用则不会收到公共流的数据。
		public void SubscribePublicTopic(long handle, int nResumeType);

		///客户端认证请求
		public int ReqAuthenticate(long handle, CThostFtdcReqAuthenticateField.ByReference pReqAuthenticateField, int nRequestID);

		///登出请求
		public int ReqUserLogout(long handle, CThostFtdcUserLogoutField.ByReference pUserLogout, int nRequestID);

		///用户口令更新请求
		public int ReqUserPasswordUpdate(long handle, CThostFtdcUserPasswordUpdateField.ByReference pUserPasswordUpdate, int nRequestID);

		///资金账户口令更新请求
		public int ReqTradingAccountPasswordUpdate(long handle, CThostFtdcTradingAccountPasswordUpdateField.ByReference pTradingAccountPasswordUpdate, int nRequestID);

		///登录请求2
		public int ReqUserLogin2(long handle, CThostFtdcReqUserLoginField.ByReference pReqUserLogin, int nRequestID);

		///用户口令更新请求2
		public int ReqUserPasswordUpdate2(long handle, CThostFtdcUserPasswordUpdateField.ByReference pUserPasswordUpdate, int nRequestID);

		///报单录入请求
		public int ReqOrderInsert(long handle, CThostFtdcInputOrderField.ByReference pInputOrder, int nRequestID);

		///预埋单录入请求
		public int ReqParkedOrderInsert(long handle, CThostFtdcParkedOrderField.ByReference pParkedOrder, int nRequestID);

		///预埋撤单录入请求
		public int ReqParkedOrderAction(long handle, CThostFtdcParkedOrderActionField.ByReference pParkedOrderAction, int nRequestID);

		///报单操作请求
		public int ReqOrderAction(long handle, CThostFtdcInputOrderActionField.ByReference pInputOrderAction, int nRequestID);

		///查询最大报单数量请求
		public int ReqQueryMaxOrderVolume(long handle, CThostFtdcQueryMaxOrderVolumeField.ByReference pQueryMaxOrderVolume, int nRequestID);

		///投资者结算结果确认
		public int ReqSettlementInfoConfirm(long handle, CThostFtdcSettlementInfoConfirmField.ByReference pSettlementInfoConfirm, int nRequestID);

		///请求删除预埋单
		public int ReqRemoveParkedOrder(long handle, CThostFtdcRemoveParkedOrderField.ByReference pRemoveParkedOrder, int nRequestID);

		///请求删除预埋撤单
		public int ReqRemoveParkedOrderAction(long handle, CThostFtdcRemoveParkedOrderActionField.ByReference pRemoveParkedOrderAction, int nRequestID);

		///执行宣告录入请求
		public int ReqExecOrderInsert(long handle, CThostFtdcInputExecOrderField.ByReference pInputExecOrder, int nRequestID);

		///执行宣告操作请求
		public int ReqExecOrderAction(long handle, CThostFtdcInputExecOrderActionField.ByReference pInputExecOrderAction, int nRequestID);

		///询价录入请求
		public int ReqForQuoteInsert(long handle, CThostFtdcInputForQuoteField.ByReference pInputForQuote, int nRequestID);

		///报价录入请求
		public int ReqQuoteInsert(long handle, CThostFtdcInputQuoteField.ByReference pInputQuote, int nRequestID);

		///报价操作请求
		public int ReqQuoteAction(long handle, CThostFtdcInputQuoteActionField.ByReference pInputQuoteAction, int nRequestID);

		///批量报单操作请求
		public int ReqBatchOrderAction(long handle, CThostFtdcInputBatchOrderActionField.ByReference pInputBatchOrderAction, int nRequestID);

		///期权自对冲录入请求
		public int ReqOptionSelfCloseInsert(long handle, CThostFtdcInputOptionSelfCloseField.ByReference pInputOptionSelfClose, int nRequestID);

		///期权自对冲操作请求
		public int ReqOptionSelfCloseAction(long handle, CThostFtdcInputOptionSelfCloseActionField.ByReference pInputOptionSelfCloseAction, int nRequestID);

		///申请组合录入请求
		public int ReqCombActionInsert(long handle, CThostFtdcInputCombActionField.ByReference pInputCombAction, int nRequestID);

		///请求查询报单
		public int ReqQryOrder(long handle, CThostFtdcQryOrderField.ByReference pQryOrder, int nRequestID);

		///请求查询成交
		public int ReqQryTrade(long handle, CThostFtdcQryTradeField.ByReference pQryTrade, int nRequestID);

		///请求查询投资者持仓
		public int ReqQryInvestorPosition(long handle, CThostFtdcQryInvestorPositionField.ByReference pQryInvestorPosition, int nRequestID);

		///请求查询资金账户
		public int ReqQryTradingAccount(long handle, CThostFtdcQryTradingAccountField.ByReference pQryTradingAccount, int nRequestID);

		///请求查询投资者
		public int ReqQryInvestor(long handle, CThostFtdcQryInvestorField.ByReference pQryInvestor, int nRequestID);

		///请求查询交易编码
		public int ReqQryTradingCode(long handle, CThostFtdcQryTradingCodeField.ByReference pQryTradingCode, int nRequestID);

		///请求查询合约保证金率
		public int ReqQryInstrumentMarginRate(long handle, CThostFtdcQryInstrumentMarginRateField.ByReference pQryInstrumentMarginRate, int nRequestID);

		///请求查询合约手续费率
		public int ReqQryInstrumentCommissionRate(long handle, CThostFtdcQryInstrumentCommissionRateField.ByReference pQryInstrumentCommissionRate, int nRequestID);

		///请求查询交易所
		public int ReqQryExchange(long handle, CThostFtdcQryExchangeField.ByReference pQryExchange, int nRequestID);

		///请求查询产品
		public int ReqQryProduct(long handle, CThostFtdcQryProductField.ByReference pQryProduct, int nRequestID);

		///请求查询合约
		public int ReqQryInstrument(long handle, CThostFtdcQryInstrumentField.ByReference pQryInstrument, int nRequestID);

		///请求查询行情
		public int ReqQryDepthMarketData(long handle, CThostFtdcQryDepthMarketDataField.ByReference pQryDepthMarketData, int nRequestID);

		///请求查询投资者结算结果
		public int ReqQrySettlementInfo(long handle, CThostFtdcQrySettlementInfoField.ByReference pQrySettlementInfo, int nRequestID);

		///请求查询转帐银行
		public int ReqQryTransferBank(long handle, CThostFtdcQryTransferBankField.ByReference pQryTransferBank, int nRequestID);

		///请求查询投资者持仓明细
		public int ReqQryInvestorPositionDetail(long handle, CThostFtdcQryInvestorPositionDetailField.ByReference pQryInvestorPositionDetail, int nRequestID);

		///请求查询客户通知
		public int ReqQryNotice(long handle, CThostFtdcQryNoticeField.ByReference pQryNotice, int nRequestID);

		///请求查询结算信息确认
		public int ReqQrySettlementInfoConfirm(long handle, CThostFtdcQrySettlementInfoConfirmField.ByReference pQrySettlementInfoConfirm, int nRequestID);

		///请求查询投资者组合持仓明细
		public int ReqQryInvestorPositionCombineDetail(long handle, CThostFtdcQryInvestorPositionCombineDetailField.ByReference pQryInvestorPositionCombineDetail, int nRequestID);

		///请求查询保证金监管系统经纪公司资金账户密钥
		public int ReqQryCFMMCTradingAccountKey(long handle, CThostFtdcQryCFMMCTradingAccountKeyField.ByReference pQryCFMMCTradingAccountKey, int nRequestID);

		///请求查询仓单折抵信息
		public int ReqQryEWarrantOffset(long handle, CThostFtdcQryEWarrantOffsetField.ByReference pQryEWarrantOffset, int nRequestID);

		///请求查询投资者品种/跨品种保证金
		public int ReqQryInvestorProductGroupMargin(long handle, CThostFtdcQryInvestorProductGroupMarginField.ByReference pQryInvestorProductGroupMargin, int nRequestID);

		///请求查询交易所保证金率
		public int ReqQryExchangeMarginRate(long handle, CThostFtdcQryExchangeMarginRateField.ByReference pQryExchangeMarginRate, int nRequestID);

		///请求查询交易所调整保证金率
		public int ReqQryExchangeMarginRateAdjust(long handle, CThostFtdcQryExchangeMarginRateAdjustField.ByReference pQryExchangeMarginRateAdjust, int nRequestID);

		///请求查询汇率
		public int ReqQryExchangeRate(long handle, CThostFtdcQryExchangeRateField.ByReference pQryExchangeRate, int nRequestID);

		///请求查询二级代理操作员银期权限
		public int ReqQrySecAgentACIDMap(long handle, CThostFtdcQrySecAgentACIDMapField.ByReference pQrySecAgentACIDMap, int nRequestID);

		///请求查询产品报价汇率
		public int ReqQryProductExchRate(long handle, CThostFtdcQryProductExchRateField.ByReference pQryProductExchRate, int nRequestID);

		///请求查询产品组
		public int ReqQryProductGroup(long handle, CThostFtdcQryProductGroupField.ByReference pQryProductGroup, int nRequestID);

		///请求查询做市商合约手续费率
		public int ReqQryMMInstrumentCommissionRate(long handle, CThostFtdcQryMMInstrumentCommissionRateField.ByReference pQryMMInstrumentCommissionRate, int nRequestID);

		///请求查询做市商期权合约手续费
		public int ReqQryMMOptionInstrCommRate(long handle, CThostFtdcQryMMOptionInstrCommRateField.ByReference pQryMMOptionInstrCommRate, int nRequestID);

		///请求查询报单手续费
		public int ReqQryInstrumentOrderCommRate(long handle, CThostFtdcQryInstrumentOrderCommRateField.ByReference pQryInstrumentOrderCommRate, int nRequestID);

		///请求查询资金账户
		public int ReqQrySecAgentTradingAccount(long handle, CThostFtdcQryTradingAccountField.ByReference pQryTradingAccount, int nRequestID);

		///请求查询二级代理商资金校验模式
		public int ReqQrySecAgentCheckMode(long handle, CThostFtdcQrySecAgentCheckModeField.ByReference pQrySecAgentCheckMode, int nRequestID);

		///请求查询期权交易成本
		public int ReqQryOptionInstrTradeCost(long handle, CThostFtdcQryOptionInstrTradeCostField.ByReference pQryOptionInstrTradeCost, int nRequestID);

		///请求查询期权合约手续费
		public int ReqQryOptionInstrCommRate(long handle, CThostFtdcQryOptionInstrCommRateField.ByReference pQryOptionInstrCommRate, int nRequestID);

		///请求查询执行宣告
		public int ReqQryExecOrder(long handle, CThostFtdcQryExecOrderField.ByReference pQryExecOrder, int nRequestID);

		///请求查询询价
		public int ReqQryForQuote(long handle, CThostFtdcQryForQuoteField.ByReference pQryForQuote, int nRequestID);

		///请求查询报价
		public int ReqQryQuote(long handle, CThostFtdcQryQuoteField.ByReference pQryQuote, int nRequestID);

		///请求查询期权自对冲
		public int ReqQryOptionSelfClose(long handle, CThostFtdcQryOptionSelfCloseField.ByReference pQryOptionSelfClose, int nRequestID);

		///请求查询投资单元
		public int ReqQryInvestUnit(long handle, CThostFtdcQryInvestUnitField.ByReference pQryInvestUnit, int nRequestID);

		///请求查询组合合约安全系数
		public int ReqQryCombInstrumentGuard(long handle, CThostFtdcQryCombInstrumentGuardField.ByReference pQryCombInstrumentGuard, int nRequestID);

		///请求查询申请组合
		public int ReqQryCombAction(long handle, CThostFtdcQryCombActionField.ByReference pQryCombAction, int nRequestID);

		///请求查询转帐流水
		public int ReqQryTransferSerial(long handle, CThostFtdcQryTransferSerialField.ByReference pQryTransferSerial, int nRequestID);

		///请求查询银期签约关系
		public int ReqQryAccountregister(long handle, CThostFtdcQryAccountregisterField.ByReference pQryAccountregister, int nRequestID);

		///请求查询签约银行
		public int ReqQryContractBank(long handle, CThostFtdcQryContractBankField.ByReference pQryContractBank, int nRequestID);

		///请求查询预埋单
		public int ReqQryParkedOrder(long handle, CThostFtdcQryParkedOrderField.ByReference pQryParkedOrder, int nRequestID);

		///请求查询预埋撤单
		public int ReqQryParkedOrderAction(long handle, CThostFtdcQryParkedOrderActionField.ByReference pQryParkedOrderAction, int nRequestID);

		///请求查询交易通知
		public int ReqQryTradingNotice(long handle, CThostFtdcQryTradingNoticeField.ByReference pQryTradingNotice, int nRequestID);

		///请求查询经纪公司交易参数
		public int ReqQryBrokerTradingParams(long handle, CThostFtdcQryBrokerTradingParamsField.ByReference pQryBrokerTradingParams, int nRequestID);

		///请求查询经纪公司交易算法
		public int ReqQryBrokerTradingAlgos(long handle, CThostFtdcQryBrokerTradingAlgosField.ByReference pQryBrokerTradingAlgos, int nRequestID);

		///请求查询监控中心用户令牌
		public int ReqQueryCFMMCTradingAccountToken(long handle, CThostFtdcQueryCFMMCTradingAccountTokenField.ByReference pQueryCFMMCTradingAccountToken, int nRequestID);

		///期货发起银行资金转期货请求
		public int ReqFromBankToFutureByFuture(long handle, CThostFtdcReqTransferField.ByReference pReqTransfer, int nRequestID);

		///期货发起期货资金转银行请求
		public int ReqFromFutureToBankByFuture(long handle, CThostFtdcReqTransferField.ByReference pReqTransfer, int nRequestID);

		///期货发起查询银行余额请求
		public int ReqQueryBankAccountMoneyByFuture(long handle, CThostFtdcReqQueryAccountField.ByReference pReqQueryAccount, int nRequestID);
	};
	
}
