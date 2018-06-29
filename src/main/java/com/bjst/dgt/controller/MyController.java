package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.User;
import com.bjst.dgt.model.yifu.RegisterBack;
import com.bjst.dgt.model.yifu.ResetPassword;
import com.bjst.dgt.service.RedisService;
import com.bjst.dgt.service.UserService;
import com.bjst.dgt.service.YiFuAPIService;
import com.bjst.dgt.util.CodeUtils;
import com.bjst.dgt.util.ShortMessageUtil;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 我的模块
 * @Author: yd
 * @CreateDate: 2018/06/27 05:54 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月28日21:00:36
 * @UpdateRemark: 我的模块controller层
 * @Version: 1.0
 */
@RestController
@RequestMapping("/my/user")
public class MyController {

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        if (user != null) {
            user.setType(1);
            Result result = checkSMS(user);
            if (result.getCode() == Integer.parseInt(ResultCode.SUCCESS.toString())) {
                //内盘注册
                RegisterBack registerBack = YiFuAPIService.registerAPI(user, 0);
                //外盘注册
                RegisterBack registerBack1 = YiFuAPIService.registerAPI(user, 1);
                user.setSubAccountIdInner(registerBack.getSubAccountID());
                user.setSubAccountIdOuter(registerBack1.getSubAccountID());
                boolean falg = userService.registerUser(user);
                if (falg) {
                    return ResultGenerator.genSuccessResult("用户注册成功", ResultCode.SUCCESS);
                } else {
                    return ResultGenerator.genFailResult("用户注册失败", ResultCode.FAIL);
                }
            } else {
                return result;
            }
        } else {
            return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
        }
    }

    @PostMapping("/checkMobile")
    public Result checkMobile(@RequestBody User user) {
        if (user.getMobile() != null) {
            boolean exists = userService.existsUserByMobile(user);
            if (exists) {
                return ResultGenerator.genFailResult("该手机号已注册", ResultCode.FAIL);
            } else {
                return ResultGenerator.genFailResult("该手机号未注册", ResultCode.SUCCESS);
            }
        } else {
            return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
        }
    }

    @PostMapping("/sendSMS")
    public Result sendSMS(@RequestBody User user) {
        if (user.getMobile() != null && (user.getType() == 1 || user.getType() == 2)) {
            // 生成验证码
            String validateCode = CodeUtils.getNumber4FromRandom();
            if (user.getType() == 1) {
                //注册
                redisService.set("registerSMS", validateCode, new Long(1), TimeUnit.MINUTES);
            } else {
                //忘记密码
                redisService.set("passwordSMS", validateCode, new Long(1), TimeUnit.MINUTES);
            }
            String result = ShortMessageUtil.getRequest(user.getMobile(), validateCode);
            JSONObject object = JSONObject.fromObject(result);
            if (object.getInt("error_code") == 0) {
                return ResultGenerator.genSuccessResult(result);
            } else {
                return ResultGenerator.genFailResult("发送验证码失败！", ResultCode.FAIL);
            }
        } else {
            return ResultGenerator.genFailResult("参数错误！", ResultCode.FAIL);
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

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        boolean falg = userService.loginUser(user);
        if (falg) {
            return ResultGenerator.genSuccessResult("登录成功！", ResultCode.SUCCESS);
        } else {
            return ResultGenerator.genFailResult("登录失败！用户名或密码错误！", ResultCode.FAIL);
        }
    }

    @PostMapping("/logout")
    public Result logout(@RequestBody User user) {
        redisService.remove("User");
        return ResultGenerator.genSuccessResult("退出登录成功！");
    }

    @PostMapping("/forgetPwd")
    public Result forgetPwd(@RequestBody Map<String, String> map) {
        User user = new User();
        user.setPassword(map.get("newPwd"));
        user.setMobile(map.get("mobile"));
        boolean falg = userService.forgetPwd(user);
        if (falg) {
            user = userService.getUesrList(user);
            ResetPassword resetPassword = new ResetPassword();
            resetPassword.setPassword(map.get("newPwd"));
            resetPassword.setSubAccountID(user.getSubAccountIdInner());
            return YiFuAPIService.ResetPassword(resetPassword);
        } else {
            return ResultGenerator.genFailResult("用户名或密码错误！", ResultCode.FAIL);
        }
    }

    @PostMapping("/alterPwd")
    public Result alterPwd(@RequestBody Map<String, String> map) {
        User user = new User();
        boolean falg;
        user.setId(Long.getLong(map.get("userId")));
        user.setPassword(map.get("newPwd"));
        user.setType(2);
        Result result = checkSMS(user);
        if (result.getCode() == Integer.parseInt(ResultCode.SUCCESS.toString())) {
            falg = userService.checkPwd(user);
            if (falg) {
                falg = userService.alterPwd(user);
                if (falg) {
                    return ResultGenerator.genSuccessResult("修改密码成功");
                } else {
                    return ResultGenerator.genFailResult("修改密码失败", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("两次密码不一致", ResultCode.FAIL);
            }
        } else {
            return result;
        }
    }
}
