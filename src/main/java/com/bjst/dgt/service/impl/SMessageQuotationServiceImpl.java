package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SMessageQuotationMapper;
import com.bjst.dgt.model.SMessageQuotation;
import com.bjst.dgt.service.SMessageQuotationService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SMessageQuotationServiceImpl extends AbstractService<SMessageQuotation> implements SMessageQuotationService {
    @Resource
    private SMessageQuotationMapper sMessageQuotationMapper;

}
