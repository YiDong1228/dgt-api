package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SStockDatasMapper;
import com.bjst.dgt.model.SStockDatas;
import com.bjst.dgt.service.SStockDatasService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SStockDatasServiceImpl extends AbstractService<SStockDatas> implements SStockDatasService {
    @Resource
    private SStockDatasMapper sStockDatasMapper;

}
