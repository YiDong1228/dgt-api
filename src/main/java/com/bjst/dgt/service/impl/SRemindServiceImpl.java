package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SRemindMapper;
import com.bjst.dgt.model.SRemind;
import com.bjst.dgt.service.SRemindService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SRemindServiceImpl extends AbstractService<SRemind> implements SRemindService {
    @Resource
    private SRemindMapper sRemindMapper;

}
