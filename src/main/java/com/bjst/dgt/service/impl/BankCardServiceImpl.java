package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.BankCardMapper;
import com.bjst.dgt.model.BankCard;
import com.bjst.dgt.service.BankCardService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class BankCardServiceImpl extends AbstractService<BankCard> implements BankCardService {
    @Resource
    private BankCardMapper bankCardMapper;

}
