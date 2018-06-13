package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SUserBalanceLogMapper;
import com.bjst.dgt.model.SUserBalanceLog;
import com.bjst.dgt.service.SUserBalanceLogService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SUserBalanceLogServiceImpl extends AbstractService<SUserBalanceLog> implements SUserBalanceLogService {
    @Resource
    private SUserBalanceLogMapper sUserBalanceLogMapper;

}
