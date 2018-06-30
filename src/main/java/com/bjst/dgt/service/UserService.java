package com.bjst.dgt.service;

import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.dao.UserMapper;
import com.bjst.dgt.model.User;
import com.bjst.dgt.util.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: UserService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:20 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月28日21:37:49
 * @UpdateRemark: UserService
 * @Version: 1.0
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisService redisService;

    /**
     * 是否存在该用户
     *
     * @param user 手机号
     * @return 是否存在
     */
    public boolean existsUserByMobile(User user) {
        int i = userMapper.existsUserByMobile(user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 注册
     *
     * @param user User对象
     * @return 是否注册成功
     */
    public boolean registerUser(User user) {
        user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
        user.setAvailableFund("0");
        user.setBaseCurrency("CNY");
        user.setDataStatus(2);
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

    /**
     * 登录
     *
     * @param user User对象
     * @return 是否登录成功
     */
    public boolean loginUser(User user) {
        String passwprd = user.getPassword();
        user.setPassword(MD5Util.MD5(user.getMobile(), passwprd));
        User loginUser = userMapper.loginUser(user);
        System.out.println(loginUser);
        if (loginUser != null) {
            //使用uuid作为源token
            String token = UUID.randomUUID().toString().replace("-", "");
            //存储到redis并设置过期时间
            loginUser.setPassword(passwprd);
            redisService.set(ProjectConstant.DGT_LOGIN_TOKEN_KEY + loginUser.getId(), token, new Long(7), TimeUnit.DAYS);
            redisService.set(ProjectConstant.DGT_LOGIN_USER_ID_KEY + loginUser.getId(), loginUser, new Long(7), TimeUnit.DAYS);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 忘记密码
     *
     * @param user User对象
     * @return 是否重置成功
     */
    public boolean forgetPwd(User user) {
        User use = getUesrList(user);
        user.setId(use.getId());
        user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
        int i = userMapper.updateUserPwdByMobile(user);
        if (i > 0) {
            boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
            if (exists) {
                redisService.remove(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
            } else {
                return false;
            }
            exists = redisService.exists(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
            if (exists) {
                redisService.remove(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * 修改密码
     *
     * @param user User对象
     * @return 是否修改成功
     */
    public boolean alterPwd(User user) {
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
        if (exists) {
            User u = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
            user.setPassword(MD5Util.MD5(u.getMobile(), user.getPassword()));
            int i = userMapper.updateUserPwdById(user);
            if (i > 0) {
                exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
                if (exists) {
                    redisService.remove(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
                } else {
                    return false;
                }
                exists = redisService.exists(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
                if (exists) {
                    redisService.remove(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
                } else {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 查询某个用户信息
     *
     * @param user User对象
     * @return 用户信息
     */
    public User getUesrList(User user) {
        User u = userMapper.getUserList(user);
        if (u != null) {
            return u;
        } else {
            return null;
        }
    }


    /**
     * 检查旧密码是否一致
     *
     * @param user User对象
     * @return 是否一致
     */
    public boolean checkPwd(User user) {
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
        if (exists) {
            User u = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
            if (u.getPassword().equalsIgnoreCase(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 检查验证码是否正确
     *
     * @param user User
     * @return 验证码状态结果集
     */
    public Result checkSMS(User user) {
        if (user.getType() != 0 && user.getSms() != null) {
            boolean exists;
            String sms = "";
            if (user.getType() == ProjectConstant.SENDSMS_TYPE_1) {
                exists = redisService.exists(ProjectConstant.REGISTER_SMS + user.getMobile());
                if (exists) {
                    sms = (String) redisService.get(ProjectConstant.REGISTER_SMS + user.getMobile());
                    if (user.getSms().equals(sms)) {
                        return ResultGenerator.genSuccessResult("验证码正确", ResultCode.SUCCESS);
                    } else {
                        return ResultGenerator.genFailResult("验证码错误", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("验证码已过期", ResultCode.FAIL);
                }
            } else {
                exists = redisService.exists(ProjectConstant.PASSWORD_SMS + user.getMobile());
                if (exists) {
                    redisService.get(ProjectConstant.PASSWORD_SMS + user.getMobile());
                    if (user.getSms().equals(sms)) {
                        return ResultGenerator.genSuccessResult("验证码正确", ResultCode.SUCCESS);
                    } else {
                        return ResultGenerator.genFailResult("验证码错误", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("验证码已过期", ResultCode.FAIL);
                }
            }
        } else {
            return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
        }
    }
}
