package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SProductMapper;
import com.bjst.dgt.model.SProduct;
import com.bjst.dgt.service.SProductService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SProductServiceImpl extends AbstractService<SProduct> implements SProductService {
    @Resource
    private SProductMapper sProductMapper;

}
