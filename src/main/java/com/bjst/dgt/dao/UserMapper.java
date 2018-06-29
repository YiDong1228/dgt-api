package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.User;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    /**
     * 是否存在该用户
     *
     * @param user 手机号
     * @return 是否存在
     */
    int existsUserByMobile(User user);

    /**
     * 登录
     *
     * @param user User对象
     * @return 是否登录成功
     */
    User loginUser(User user);

    /**
     * 注册
     *
     * @param user User对象
     * @return 是否注册成功
     */
    int registerUser(User user);

    /**
     * 忘记密码
     *
     * @param user User对象
     * @return 是否重置成功
     */
    int updateUserPwdByMobile(User user);

    /**
     * 查询某个用户信息
     *
     * @param user User对象
     * @return 用户信息
     */
    User getUserList(User user);

    /**
     * 修改密码
     *
     * @param user User对象
     * @return 是否修改成功
     */
    int updateUserPwdById(User user);
}