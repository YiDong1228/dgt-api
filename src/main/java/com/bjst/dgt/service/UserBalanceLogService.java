package com.bjst.dgt.service;

import com.bjst.dgt.dao.UserBalanceLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: UserBalanceLogService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:21 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:21 PM
 * @UpdateRemark: 创建UserBalanceLogService
 * @Version: 1.0
 */
@Service
@Transactional
public class UserBalanceLogService {

    @Resource
    private UserBalanceLogMapper userBalanceLogMapper;


}
