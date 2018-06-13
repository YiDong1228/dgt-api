package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SMessageSystemMapper;
import com.bjst.dgt.model.SMessageSystem;
import com.bjst.dgt.service.SMessageSystemService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SMessageSystemServiceImpl extends AbstractService<SMessageSystem> implements SMessageSystemService {
    @Resource
    private SMessageSystemMapper sMessageSystemMapper;

}
