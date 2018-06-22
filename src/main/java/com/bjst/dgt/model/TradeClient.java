package com.bjst.dgt.model;

import com.bjst.dgt.third.yifu.Trade;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zll on 2018/6/19.
 */
@Data
@Component
@Scope
public class TradeClient {

    // 记录用户登录交易系统的实例
    private Map<String,Trade> tradeClient = new HashMap<>();

    /**
     *  簡化操作
     * @param key
     * @param trade
     */
    public void put(String key, Trade trade) {
        tradeClient.put(key, trade);
    }
    /**
     *  簡化操作
     * @param key
     */
    public Trade get(String key) {
        return tradeClient.get(key);
    }
    /**
     *  簡化操作
     * @param key
     */
    public boolean containsKey(String key) {
        return tradeClient.containsKey(key);
    }

    public Trade remove(String key) {
        return tradeClient.remove(key);
    }
}
