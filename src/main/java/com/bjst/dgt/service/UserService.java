package com.bjst.dgt.service;

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
        if (loginUser != null) {
            //使用uuid作为源token
            String token = UUID.randomUUID().toString().replace("-", "");
            //存储到redis并设置过期时间
            redisService.set("token", token, new Long(7), TimeUnit.DAYS);
            redisService.set("User", loginUser, new Long(7), TimeUnit.DAYS);
            return true;
        } else {
            return false;
        }
    }

    public boolean forgetPwd(User user) {
        user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
        int i = userMapper.updateUserPwdByMobile(user);
        if (i > 0) {
            boolean exists = redisService.exists("User");
            if (exists) {
                redisService.remove("User");
            } else {
                return false;
            }
            exists = redisService.exists("token");
            if (exists) {
                redisService.remove("token");
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean alterPwd(User user) {
        boolean exists = redisService.exists("User");
        if (exists) {
            User u = (User) redisService.get("User");
            user.setPassword(MD5Util.MD5(u.getMobile(), user.getPassword()));
            int i = userMapper.updateUserPwdById(user);
            if (i > 0) {
                exists = redisService.exists("User");
                if (exists) {
                    redisService.remove("User");
                } else {
                    return false;
                }
                exists = redisService.exists("token");
                if (exists) {
                    redisService.remove("token");
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

    public User getUesrList(User user) {
        User u = userMapper.getUserList(user);
        if (u != null) {
            return u;
        } else {
            return null;
        }
    }

    public boolean checkPwd(User user) {
        boolean exists = redisService.exists("User");
        if (exists) {
            User u = (User) redisService.get("User");
            user.setPassword(MD5Util.MD5(user.getMobile(), user.getPassword()));
            if (u.getPassword().equalsIgnoreCase(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public Result checkSMS(User user) {
        if ((user.getType() == 1 || user.getType() == 2) && user.getSms() != null) {
            boolean exists = false;
            String sms = "";
            if (user.getType() == 1) {
                exists = redisService.exists("registerSMS");
                if (exists) {
                    sms = (String) redisService.get("registerSMS");
                    if (user.getSms().equals(sms)) {
                        return ResultGenerator.genSuccessResult("验证码正确", ResultCode.SUCCESS);
                    } else {
                        return ResultGenerator.genFailResult("验证码错误", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("验证码已过期", ResultCode.FAIL);
                }
            } else {
                exists = redisService.exists("passwordSMS");
                if (exists) {
                    redisService.get("passwordSMS");
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
