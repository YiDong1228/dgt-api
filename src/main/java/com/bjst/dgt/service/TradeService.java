package com.bjst.dgt.service;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.dao.InvestorPositionDetailMapper;
import com.bjst.dgt.dao.InvestorPositionMapper;
import com.bjst.dgt.dao.TradeMapper;
import com.bjst.dgt.model.InvestorPosition;
import com.bjst.dgt.model.Trade;
import com.bjst.dgt.model.TradeClient;
import com.bjst.dgt.third.yifu.TradeAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by zll on 2018/6/19.
 */
@Service
public class TradeService {

    // 交易 经纪公司内盘公测代码
    @Value("${dgt.trade.inner.disc}")
    private String innerDisc;
    // 交易 经纪公司外盘公测代码
    @Value("${dgt.trade.outer.disc}")
    private String outerDisc;
    // 交易 内盘盘公测地址
    @Value("${dgt.trade.inner.tcp-url}")
    private String innerUrl;
    // 交易 外盘公测地址
    @Value("${dgt.trade.outer.tcp-url}")
    private String outerUrl;


    @Resource
    private TradeClient tradeClient;
    @Resource
    private TradeMapper tradeMapper;
    @Resource
    private RedisService redisService;
    @Resource
    private InvestorPositionMapper investorPositionMapper;
    @Resource
    private InvestorPositionDetailMapper investorPositionDetailMapper;

    /**
     *  内盘登录
     *  @param localUserId 本地用户id
     * @param userId 用户id
     * @param pwd 用户密码
     */
    public void tradeInnerLogin(String localUserId,String userId, String pwd) {
        tradeLogin(localUserId,userId, pwd, false);
    }

    /**
     * 外盘登录
     * @param localUserId 本地用户id
     * @param userId 用户id
     * @param pwd 用户密码
     */
    public void tradeOuterLogin(String localUserId,String userId, String pwd) {
        tradeLogin(localUserId,userId, pwd, true);
    }

    @Async
    public void tradeLogin(String localUserId,String userId, String pwd, boolean isOuter) {
        if (!tradeClient.getTradeClient().containsKey(userId)) {
            TradeAPI tradeAPI = null;
            if (isOuter) {
                tradeAPI = new TradeAPI(localUserId,userId, pwd, outerDisc, outerUrl);

            } else {
                tradeAPI = new TradeAPI(localUserId, userId, pwd, innerDisc, innerUrl);
            }
            tradeAPI.setTradeClientWeakReference(new WeakReference<TradeClient>(tradeClient));
            tradeAPI.setRedisService(redisService);
            tradeAPI.setTradeMapper(tradeMapper);
            tradeAPI.setInvestorPositionMapper(investorPositionMapper);
            tradeAPI.setInvestorPositionDetailMapper(investorPositionDetailMapper);
            tradeAPI.login();
        }

    }

    /**
     * 用戶登出
     * @param userId
     */
    public void tradeLogout(String userId) {
        if (tradeClient.containsKey(userId)) {
            tradeClient.get(userId).goOut();
        }
    }

    /**
     *
     * @param userId 内外盘 用户id
     * @param trade 交易model
     * @return
     */
    public Result placeOrder(String userId, Trade trade) {
        //tradeOuterLogin("testwai001","123456");
            Result result = ResultGenerator.genFailResult("委托单失败", ResultCode.TRADE_ORDER_INSERT_ERROR);
            if (tradeClient.containsKey(userId)) {
                tradeMapper.insert(trade);
                result = tradeClient.get(userId).placeOrder(trade);
            }
            return result;
    }

    public Result getPositionList(String userId) {
        // 内外盘都要查, 需等待登录将用户信息存储 **** 暂时 只有吃外盘
        Result result = ResultGenerator.genFailResult("查询持仓失败", ResultCode.FAIL);
        if (tradeClient.containsKey(userId)) {
            List<InvestorPosition> investorPositionList = tradeClient.get(userId).queryInvestorPositiosnForResult();
            result = ResultGenerator.genSuccessResult(investorPositionList);
        }
        return result;
    }


}
