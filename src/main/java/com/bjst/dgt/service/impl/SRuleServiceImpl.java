package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SRuleMapper;
import com.bjst.dgt.model.SRule;
import com.bjst.dgt.service.SRuleService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SRuleServiceImpl extends AbstractService<SRule> implements SRuleService {
    @Resource
    private SRuleMapper sRuleMapper;

}
