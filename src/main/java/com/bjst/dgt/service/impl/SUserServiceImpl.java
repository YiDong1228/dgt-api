package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SUserMapper;
import com.bjst.dgt.model.SUser;
import com.bjst.dgt.service.SUserService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SUserServiceImpl extends AbstractService<SUser> implements SUserService {
    @Resource
    private SUserMapper sUserMapper;

}
