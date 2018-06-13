package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.STransactionMapper;
import com.bjst.dgt.model.STransaction;
import com.bjst.dgt.service.STransactionService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class STransactionServiceImpl extends AbstractService<STransaction> implements STransactionService {
    @Resource
    private STransactionMapper sTransactionMapper;

}
