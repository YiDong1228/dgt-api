package com.bjst.dgt.service;

import com.bjst.dgt.dao.RuleMapper;
import com.bjst.dgt.model.Rule;
import com.bjst.dgt.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 规则
 * @Author: yd
 * @CreateDate: 2018/06/15 05:48 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月26日13:35:47
 * @UpdateRemark: 添加Redis缓存
 * @Version: 1.0
 */
@Service
@Transactional
public class RuleService {

    @Resource
    private RuleMapper ruleMapper;

    @Resource
    private RedisService redisService;

    public Rule getRuleById(Rule rule) {
        Rule ru = new Rule();
        /*boolean exists = redisService.exists("getRuleById");
        if (exists) {
            List list = (List) redisService.get("getRuleById");
            Object[] objects = (Object[]) list.get(0);
            ru.setCode((String) objects[0]);
            ru.setIsDomestic((String) objects[1]);
            ru.setMonetaryunit((String) objects[2]);
            ru.setTradingunit((String) objects[3]);
            ru.setExchange((String) objects[4]);
            ru.setMinimumfluctuation((String) objects[5]);
            ru.setFluctuatingprofitandloss((String) objects[6]);
            ru.setPerformancebond((String) objects[7]);
            ru.setTradingtime((String) objects[8]);
            ru.setClearingtime((String) objects[9]);
            ru.setComprehensivefee((String) objects[10]);
            ru.setExchangerate((String) objects[11]);
            ru.setStartTime((String) objects[12]);
            ru.setEndTime((String) objects[13]);
            ru.setStartTime1((String) objects[14]);
            ru.setEndTime1((String) objects[15]);
            ru.setTradeStatus((String) objects[16]);
            ru.setShuoming1((String) objects[17]);
            ru.setShuoming2((String) objects[18]);
            ru.setShuoming1Moon((String) objects[19]);
            return ru;
        } else {*/
        ru = ruleMapper.getRuleById(rule);
        if (ru != null) {
            ru.setTradeStatus(DateUtil.isBelong(Integer.parseInt(ru.getIsDomestic()), ru.getCode(), ru.getStartTime(), ru.getEndTime()));
            //redisService.lPush("getRuleById", ru);
            return ru;
        } else {
            return null;
        }
        //}
    }
}
