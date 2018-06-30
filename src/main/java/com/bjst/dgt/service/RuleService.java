package com.bjst.dgt.service;

import com.bjst.dgt.dao.RuleMapper;
import com.bjst.dgt.model.Rule;
import com.bjst.dgt.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    public Rule getRuleById(Rule rule) {
        Rule ru = ruleMapper.getRuleById(rule);
        if (ru != null) {
            ru.setTradeStatus(DateUtil.isBelong(Integer.parseInt(ru.getIsDomestic()), ru.getCode(), ru.getStartTime(), ru.getEndTime()));
            return ru;
        } else {
            return null;
        }
    }
}
