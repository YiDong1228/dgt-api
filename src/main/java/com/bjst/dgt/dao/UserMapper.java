package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.User;

public interface UserMapper extends Mapper<User> {
    /**
     * 是否存在该用户
     * @param user 手机号
     * @return 是否存在
     */
    int existsUserByMobile(User user);

    /**
     * 登录
     * @param user User对象
     * @return 是否登录成功
     */
    User loginUser(User user);

    /**
     * 注册
     * @param user User对象
     * @return 是否注册成功
     */
    int registerUser(User user);
}