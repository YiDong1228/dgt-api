package com.bjst.dgt.service;

import com.bjst.dgt.dao.TradingRulesMapper;
import com.bjst.dgt.model.TradingRules;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 报单计算规则
 * @Author: yd
 * @CreateDate: 2018/06/25 01:29 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/25 01:29 PM
 * @UpdateRemark: 添加Redis缓存
 * @Version: 1.0
 */
@Service
@Transactional
public class TradingRulesService {

    @Resource
    private TradingRulesMapper tradingRulesMapper;

    @Resource
    private RedisService redisService;

    public TradingRules getTradingRulesByCode(TradingRules rules) {
        TradingRules tradingRules = new TradingRules();
        /*boolean exists = redisService.exists("getTradingRulesByCode");
        if (exists) {
            List list = (List) redisService.get("getTradingRulesByCode");
            Object[] objects = (Object[]) list.get(0);
            tradingRules.setCode((String) objects[0]);
            tradingRules.setVolatilityPrice((BigDecimal) objects[1]);
            tradingRules.setExchangerate((BigDecimal) objects[2]);
            tradingRules.setSingleTransactionCosts((BigDecimal) objects[3]);
            tradingRules.setSingleDefaultMargin((BigDecimal) objects[4]);
            tradingRules.setDefaultPoints((BigDecimal) objects[5]);
            tradingRules.setToken((String) objects[6]);
            tradingRules.setUserId((Integer) objects[7]);
            return tradingRules;
        } else {*/
        tradingRules = tradingRulesMapper.getTradingRulesByCode(rules);
        //redisService.lPush("getTradingRulesByCode", tradingRules);
        if (tradingRules != null) {
            return tradingRules;
        } else {
            return null;
        }
        //}
    }

}
