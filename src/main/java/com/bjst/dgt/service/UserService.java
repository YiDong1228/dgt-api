package com.bjst.dgt.service;

import com.bjst.dgt.dao.UserMapper;
import com.bjst.dgt.model.User;
import com.bjst.dgt.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @Description: UserService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:20 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:20 PM
 * @UpdateRemark: 创建UserService
 * @Version: 1.0
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    public boolean existsUserByMobile(User user) {
        int i = userMapper.existsUserByMobile(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean registerUser(User user) {
        user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
        user.setAvailableFund("0");
        user.setBaseCurrency("0");
        user.setDataStatus(0);
        user.setExecRate("0");
        user.setBalance(BigDecimal.valueOf(0));
        user.setMarginFund("0");
        int i = userMapper.registerUser(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loginUser(User user) {
        user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
        User loginUser = userMapper.loginUser(user);
        redisService.set("User", loginUser, new Long(7), TimeUnit.DAYS);
        if (loginUser != null) {
            return true;
        } else {
            return false;
        }
    }

}
