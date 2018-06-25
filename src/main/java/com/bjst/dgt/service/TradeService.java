package com.bjst.dgt.service;

import com.bjst.dgt.dao.TradeMapper;
import com.bjst.dgt.model.Trade;
import com.bjst.dgt.model.TradeClient;
import com.bjst.dgt.third.yifu.TradeAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.ref.WeakReference;

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

    /**
     *  内盘登录
     * @param userId 用户id
     * @param pwd 用户密码
     */
    @Async
    public void tradeInnerLogin(String userId, String pwd) {
        if (!tradeClient.containsKey(userId)) {
            TradeAPI tradeAPI = new TradeAPI(userId, pwd, innerDisc, innerUrl);
            tradeAPI.setTradeClientWeakReference(new WeakReference<TradeClient>(tradeClient));
            tradeAPI.login();
        }
    }

    /**
     * 外盘登录
     * @param userId 用户id
     * @param pwd 用户密码
     */
    @Async
    public void tradeOuterLogin(String userId, String pwd) {
        if (!tradeClient.getTradeClient().containsKey(userId)) {
            TradeAPI tradeAPI = new TradeAPI(userId, pwd, outerDisc, outerUrl);
            tradeAPI.setTradeClientWeakReference(new WeakReference<TradeClient>(tradeClient));
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
    public int placeOrder(String userId,Trade trade) {
            int result = -1;
            if (tradeClient.containsKey(userId)) {
                result = tradeClient.get(userId).plcaeOrder(trade);
                tradeMapper.insert(trade);
            }

            return result;
    }
}
