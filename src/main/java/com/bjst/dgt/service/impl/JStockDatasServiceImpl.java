package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.JStockDatasMapper;
import com.bjst.dgt.model.JStockDatas;
import com.bjst.dgt.service.JStockDatasService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class JStockDatasServiceImpl extends AbstractService<JStockDatas> implements JStockDatasService {
    @Resource
    private JStockDatasMapper jStockDatasMapper;

}
