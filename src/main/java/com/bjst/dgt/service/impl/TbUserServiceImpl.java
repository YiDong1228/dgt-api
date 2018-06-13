package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.TbUserMapper;
import com.bjst.dgt.model.TbUser;
import com.bjst.dgt.service.TbUserService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zll on 2018/06/13.
 */
@Service
@Transactional
public class TbUserServiceImpl extends AbstractService<TbUser> implements TbUserService {
    @Resource
    private TbUserMapper tbUserMapper;

}
