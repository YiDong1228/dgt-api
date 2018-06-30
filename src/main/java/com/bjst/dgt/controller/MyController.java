package com.bjst.dgt.controller;

import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.*;
import com.bjst.dgt.model.yifu.*;
import com.bjst.dgt.service.*;
import com.bjst.dgt.util.CodeUtils;
import com.bjst.dgt.util.ShortMessageUtil;
import net.sf.json.JSONObject;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 我的模块
 * @Author: yd
 * @CreateDate: 2018/06/27 05:54 PM
 * @UpdateUser: yd
 * @UpdateDate:  2018年6月30日21:19:58
 * @UpdateRemark: 我的模块controller层
 * @Version: 1.0
 */
@RestController
@RequestMapping("/my")
public class MyController {

    @Resource
    private UserService userService;
    @Resource
    private RedisService redisService;
    @Resource
    private YiFuAPIService yiFuAPIService;
    @Resource
    private TradeService tradeService;
    @Resource
    private BankCardTypeService bankCardTypeService;
    @Resource
    private BankCardService bankCardService;
    @Resource
    private MessageQuotationService messageQuotationService;
    @Resource
    private MessageSystemService messageSystemService;
    @Resource
    private QuestionService questionService;
    @Resource
    private QuestionTypeService questionTypeService;


    @PostMapping("/user/register")
    public Result register(@RequestBody User user) {
        if (user != null) {
            user.setType(ProjectConstant.SENDSMS_TYPE_1);
            Result result = userService.checkSMS(user);
            if (result.getCode() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                //内盘注册
                RegisterBack registerBack = yiFuAPIService.registerAPI(user, ProjectConstant.YIFU_TYPE_INNER);
                //外盘注册
                RegisterBack registerBack1 = yiFuAPIService.registerAPI(user, ProjectConstant.YIFU_TYPE_OUTER);
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

    @PostMapping("/user/checkMobile")
    public Result checkMobile(@RequestBody User user) {
        if (user.getMobile() != null) {
            boolean exists = userService.existsUserByMobile(user);
            if (exists) {
                return ResultGenerator.genFailResult("该手机号已注册", ResultCode.FAIL);
            } else {
                return ResultGenerator.genFailResult("该手机号可以注册", ResultCode.SUCCESS);
            }
        } else {
            return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
        }
    }

    @PostMapping("/user/sendSMS")
    public Result sendSMS(@RequestBody User user) {
        if (user.getMobile() != null && (user.getType() == ProjectConstant.SENDSMS_TYPE_1 || user.getType() == ProjectConstant.SENDSMS_TYPE_2)) {
            // 生成验证码
            String validateCode = CodeUtils.getNumber4FromRandom();
            if (user.getType() == ProjectConstant.SENDSMS_TYPE_1) {
                //注册
                redisService.set(ProjectConstant.REGISTER_SMS + user.getMobile(), validateCode, new Long(1), TimeUnit.MINUTES);
            } else {
                //忘记密码
                redisService.set(ProjectConstant.PASSWORD_SMS + user.getMobile(), validateCode, new Long(1), TimeUnit.MINUTES);
            }
            System.out.println("验证码：" + validateCode);
            String result = ShortMessageUtil.getRequest(user.getMobile(), validateCode);
            JSONObject object = JSONObject.fromObject(result);
            if (object.getInt(ProjectConstant.SMS_ERROR_CODE) == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0) {
                return ResultGenerator.genSuccessResult(result);
            } else {
                return ResultGenerator.genFailResult("发送验证码失败！", ResultCode.FAIL);
            }
        } else {
            return ResultGenerator.genFailResult("参数错误！", ResultCode.FAIL);
        }
    }

    @PostMapping("/user/login")
    public Result login(@RequestBody User user) {
        if (user.getMobile() != null && user.getPassword() != null) {
            //本地登录
            boolean falg = userService.loginUser(user);
            if (falg) {
                User u = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());

                //交易登录 内盘
                tradeService.tradeInnerLogin(user.getId().toString(), user.getSubAccountIdInner(), user.getPassword());
                //交易登录 外盘
                tradeService.tradeOuterLogin(user.getId().toString(), user.getSubAccountIdOuter(), user.getPassword());

                String token = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
                Long userId = u.getId();
                TokenModel tokenMode = new TokenModel(userId, token);
                return ResultGenerator.genSuccessResult(tokenMode);
            } else {
                return ResultGenerator.genFailResult("登录失败！用户名或密码错误！", ResultCode.FAIL);
            }
        } else {
            return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
        }
    }

    @PostMapping("/user/logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            if (token != null && userId != null) {
                User user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + userId);
                if (token.equals(redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId()))) {
                    if (userId.equals(user.getId())) {
                        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
                        if (exists) {
                            redisService.remove(ProjectConstant.DGT_LOGIN_USER_ID_KEY + user.getId());
                        } else {
                            return ResultGenerator.genFailResult("登录信息已过期，如需要，请重新登录", ResultCode.FAIL);
                        }
                        exists = redisService.exists(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
                        if (exists) {
                            redisService.remove(ProjectConstant.DGT_LOGIN_TOKEN_KEY + user.getId());
                        } else {
                            return ResultGenerator.genFailResult("登录信息已过期，如需要，请重新登录", ResultCode.FAIL);
                        }
                        //交易退出登录
                        tradeService.tradeLogout(userId);

                        return ResultGenerator.genSuccessResult("退出登录成功！");
                    } else {
                        return ResultGenerator.genFailResult("userId错误", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("token错误", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("参数错误", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/user/forgetPwd")
    public Result forgetPwd(@RequestBody Map<String, String> map) {
        User user = new User();
        user.setPassword(map.get("newPwd"));
        user.setMobile(map.get("mobile"));
        user.setType(ProjectConstant.SENDSMS_TYPE_2);
        Result result = userService.checkSMS(user);
        if (result.getCode() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
            boolean falg = userService.forgetPwd(user);
            if (falg) {
                user = userService.getUesrList(user);
                ResetPassword resetPassword = new ResetPassword();
                resetPassword.setPassword(map.get("newPwd"));
                resetPassword.setSubAccountID(user.getSubAccountIdInner());
                ResetPassword resetPassword1 = new ResetPassword();
                resetPassword1.setPassword(map.get("newPwd"));
                resetPassword1.setSubAccountID(user.getSubAccountIdOuter());
                //内盘修改密码
                ResetPasswordBack resetPasswordBack = yiFuAPIService.setResetPassword(resetPassword, ProjectConstant.YIFU_TYPE_INNER);
                //外盘修改密码
                ResetPasswordBack resetPasswordBack1 = yiFuAPIService.setResetPassword(resetPassword1, ProjectConstant.YIFU_TYPE_OUTER);
                if (resetPasswordBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                    return ResultGenerator.genSuccessResult(resetPasswordBack);
                } else if (resetPasswordBack1.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                    return ResultGenerator.genSuccessResult(resetPasswordBack1);
                } else {
                    return ResultGenerator.genFailResult("【逸富】重置密码错误", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("用户名或密码错误！", ResultCode.FAIL);
            }
        } else {
            return result;
        }
    }

    @PostMapping("/user/alterPwd")
    public Result alterPwd(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            User user = new User();
            user.setId(Long.getLong(userId));
            user.setPassword(map.get("oldPwd"));
            boolean falg = userService.checkPwd(user);
            if (falg) {
                user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + userId);
                user.setPassword(map.get("newPwd"));
                falg = userService.alterPwd(user);
                if (falg) {
                    ResetPassword resetPassword = new ResetPassword();
                    resetPassword.setUserId(userId);
                    resetPassword.setPassword(map.get("newPwd"));
                    resetPassword.setSubAccountID(user.getSubAccountIdInner());
                    ResetPassword resetPassword1 = new ResetPassword();
                    resetPassword1.setUserId(userId);
                    resetPassword1.setPassword(map.get("newPwd"));
                    resetPassword1.setSubAccountID(user.getSubAccountIdOuter());
                    //内盘修改密码
                    ResetPasswordBack resetPasswordBack = yiFuAPIService.setResetPassword(resetPassword, ProjectConstant.YIFU_TYPE_INNER);
                    //外盘修改密码
                    ResetPasswordBack resetPasswordBack1 = yiFuAPIService.setResetPassword(resetPassword1, ProjectConstant.YIFU_TYPE_OUTER);
                    if (resetPasswordBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                        return ResultGenerator.genSuccessResult(resetPasswordBack);
                    } else if (resetPasswordBack1.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                        return ResultGenerator.genSuccessResult(resetPasswordBack1);
                    } else {
                        return ResultGenerator.genFailResult("【逸富】重置密码错误", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("修改密码失败", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("两次密码不一致", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/user/getBankTypeList")
    public Result getBankTypeList(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            List<BankCardType> bankCardTypeList = bankCardTypeService.getBankTypeList();
            if (bankCardTypeList != null && bankCardTypeList.size() > 0) {
                return ResultGenerator.genSuccessResult(bankCardTypeList);
            } else {
                return ResultGenerator.genFailResult("银行列表为空", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/user/bindingBank")
    public Result bindingBank(@RequestBody BankCard bankCard, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            //本地绑定银行卡
            boolean falg = bankCardService.bindingBank(bankCard);
            if (falg) {
                User user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + userId);
                //逸富绑定银行卡 内盘
                BindingBankCard bindingBankCard = new BindingBankCard();
                bindingBankCard.setUserId(userId);
                bindingBankCard.setSubAccountID(user.getSubAccountIdInner());
                BindingBankCardBack bindingBankCardBack = yiFuAPIService.setBindingBankCard(bindingBankCard, ProjectConstant.YIFU_TYPE_INNER);
                //逸富绑定银行卡 外盘
                BindingBankCard bindingBankCard1 = new BindingBankCard();
                bindingBankCard1.setUserId(userId);
                bindingBankCard1.setSubAccountID(user.getSubAccountIdOuter());
                BindingBankCardBack bindingBankCardBack1 = yiFuAPIService.setBindingBankCard(bindingBankCard1, ProjectConstant.YIFU_TYPE_OUTER);
                if (bindingBankCardBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                    if (bindingBankCardBack1.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                        return ResultGenerator.genSuccessResult("绑定银行卡成功", ResultCode.SUCCESS);
                    } else {
                        return ResultGenerator.genFailResult("【逸富外盘】绑定银行卡失败", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("【逸富内盘】绑定银行卡失败", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("绑定失败！", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/user/getBankList")
    public Result getBankList(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            BankCard bankCard = new BankCard();
            bankCard.setUserId(Integer.parseInt(userId));
            bankCard = bankCardService.getBankList(bankCard);
            if (bankCard != null) {
                return ResultGenerator.genSuccessResult(bankCard);
            } else {
                return ResultGenerator.genFailResult("未绑定银行卡", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/user/removeBank")
    public Result removeBank(@RequestBody BankCard bankCard, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            //本地解绑银行卡
            boolean falg = bankCardService.removeBank(bankCard);
            if (falg) {
                User user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + userId);
                //逸富解绑银行卡 内盘
                UntieBankCard untieBankCard = new UntieBankCard();
                untieBankCard.setUserId(userId);
                untieBankCard.setBankAccount(bankCard.getBankAccount());
                untieBankCard.setSubAccountID(user.getSubAccountIdInner());
                UntieBankCardBack untieBankCardBack = yiFuAPIService.setUntieBankCard(untieBankCard, ProjectConstant.YIFU_TYPE_INNER);

                //逸富解绑银行卡 外盘
                UntieBankCard untieBankCard1 = new UntieBankCard();
                untieBankCard.setUserId(userId);
                untieBankCard.setBankAccount(bankCard.getBankAccount());
                untieBankCard1.setSubAccountID(user.getSubAccountIdOuter());
                UntieBankCardBack untieBankCardBack1 = yiFuAPIService.setUntieBankCard(untieBankCard1, ProjectConstant.YIFU_TYPE_OUTER);

                if (untieBankCardBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                    if (untieBankCardBack1.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_200) {
                        return ResultGenerator.genSuccessResult("解绑银行卡成功", ResultCode.SUCCESS);
                    } else {
                        return ResultGenerator.genFailResult("【逸富外盘】解绑银行卡失败", ResultCode.FAIL);
                    }
                } else {
                    return ResultGenerator.genFailResult("【逸富内盘】解绑银行卡失败", ResultCode.FAIL);
                }
            } else {
                return ResultGenerator.genFailResult("解绑银行卡失败", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/message/getPriceWarning")
    public Result getPriceWarning(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            MessageQuotation messageQuotation = new MessageQuotation();
            messageQuotation.setUserId(userId);
            List<MessageQuotation> messageQuotationList = messageQuotationService.getPriceWarning(messageQuotation);
            if (messageQuotationList != null && messageQuotationList.size() > 0) {
                return ResultGenerator.genSuccessResult(messageQuotation);
            } else {
                return ResultGenerator.genFailResult("无价格预警通知", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/message/getSystemNotic")
    public Result getSystemNotic(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            List<MessageSystem> messageSystemList = messageSystemService.getSystemNotic();
            if (messageSystemList != null && messageSystemList.size() > 0) {
                return ResultGenerator.genSuccessResult(messageSystemList);
            } else {
                return ResultGenerator.genFailResult("无系统通知", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/question/getCommonProblems")
    public Result getCommonProblems(@RequestBody Question question, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            List<Question> questionList = questionService.getCommonProblems(question);
            if (questionList != null && questionList.size() > 0) {
                return ResultGenerator.genSuccessResult(questionList);
            } else {
                return ResultGenerator.genFailResult("无常见问题列表", ResultCode.FAIL);
            }
        }
    }

    @PostMapping("/question/getCommonProblemsById")
    public Result getCommonProblemsById(HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equals(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误", ResultCode.FAIL);
        } else {
            List<QuestionType> questionTypeList = questionTypeService.getCommonProblemsById();
            if (questionTypeList != null && questionTypeList.size() > 0) {
                return ResultGenerator.genSuccessResult(questionTypeList);
            } else {
                return ResultGenerator.genFailResult("无常见问题具体列表", ResultCode.FAIL);
            }
        }
    }

}
