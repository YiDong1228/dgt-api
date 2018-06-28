package com.bjst.dgt.service;

import com.bjst.dgt.dao.BankCardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: BankCardService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:22 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:22 PM
 * @UpdateRemark: 创建BankCardService
 * @Version: 1.0
 */
@Service
@Transactional
public class BankCardService {

    @Resource
    private BankCardMapper bankCardMapper;

}
