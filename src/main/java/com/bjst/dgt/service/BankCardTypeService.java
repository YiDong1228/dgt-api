package com.bjst.dgt.service;

import com.bjst.dgt.dao.BankCardTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: BankCardTypeService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:23 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:23 PM
 * @UpdateRemark: 创建BankCardTypeService
 * @Version: 1.0
 */
@Service
@Transactional
public class BankCardTypeService {

    @Resource
    private BankCardTypeMapper bankCardTypeMapper;

}
