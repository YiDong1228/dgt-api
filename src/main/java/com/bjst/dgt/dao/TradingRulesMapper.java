package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.TradingRules;

public interface TradingRulesMapper extends Mapper<TradingRules> {
    /**
     * 查询指定产品的报单计算规则
     * @param tradingRules TradingRules对象
     * @return TradingRules对象
     */
    TradingRules getTradingRulesByCode(TradingRules tradingRules);
}