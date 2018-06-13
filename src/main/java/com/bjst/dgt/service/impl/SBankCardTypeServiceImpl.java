package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SBankCardTypeMapper;
import com.bjst.dgt.model.SBankCardType;
import com.bjst.dgt.service.SBankCardTypeService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SBankCardTypeServiceImpl extends AbstractService<SBankCardType> implements SBankCardTypeService {
    @Resource
    private SBankCardTypeMapper sBankCardTypeMapper;

}
