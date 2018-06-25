package com.bjst.dgt.service;

import com.bjst.dgt.dao.TradingRulesMapper;
import com.bjst.dgt.model.TradingRules;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: 报单计算规则
 * @Author: yd
 * @CreateDate: 2018/06/25 01:29 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/25 01:29 PM
 * @UpdateRemark: 查询指定产品的报单计算规则
 * @Version: 1.0
 */
@Service
@Transactional
public class TradingRulesService {

    @Resource
    private TradingRulesMapper tradingRulesMapper;

    public TradingRules getTradingRulesByCode(TradingRules rules) {
        TradingRules tradingRules = tradingRulesMapper.getTradingRulesByCode(rules);
        if (tradingRules != null) {
            return tradingRules;
        } else {
            return null;
        }
    }

}
