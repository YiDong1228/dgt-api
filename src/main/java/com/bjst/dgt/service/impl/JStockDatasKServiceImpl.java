package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.JStockDatasKMapper;
import com.bjst.dgt.model.JStockDatasK;
import com.bjst.dgt.service.JStockDatasKService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class JStockDatasKServiceImpl extends AbstractService<JStockDatasK> implements JStockDatasKService {
    @Resource
    private JStockDatasKMapper jStockDatasKMapper;

}
