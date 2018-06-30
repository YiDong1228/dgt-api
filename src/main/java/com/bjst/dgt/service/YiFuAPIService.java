package com.bjst.dgt.service;

import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultCode;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.User;
import com.bjst.dgt.model.yifu.*;
import com.bjst.dgt.util.HttpClientUtil;
import com.bjst.dgt.util.MD5Util;
import com.bjst.dgt.util.MapToStringSplicing;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: 逸富API接口
 * @Author: yd
 * @CreateDate: 2018/06/27 06:31 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 06:31 PM
 * @UpdateRemark: 逸富API接口
 * @Version: 1.0
 */
@Service
public class YiFuAPIService {

    @Value("${dgt.web.version}")
    private String version;

    /**
     * 逸富内盘接口地址
     */

    @Value("${dgt.web.untie.user.inner-url}")
    private String jiebang_inner;
    @Value("${dgt.web.binding.user.inner-url}")
    private String bangding_inner;
    @Value("${dgt.web.insert.user.inner-url}")
    private String insert_inner;
    @Value("${dgt.web.margin.user.inner-url}")
    private String margin_inner;
    @Value("${dgt.web.recharge.user.inner-url}")
    private String recharge_inner;
    @Value("${dgt.web.reset.user.inner-trl}")
    private String reset_inner;

    /**
     * 逸富外盘接口地址
     */

    @Value("${dgt.web.untie.user.outer-url}")
    private String jiebang_outer;
    @Value("${dgt.web.binding.user.outer-url}")
    private String bangding_outer;
    @Value("${dgt.web.insert.user.outer-url}")
    private String insert_outer;
    @Value("${dgt.web.margin.user.outer-url}")
    private String margin_outer;
    @Value("${dgt.web.recharge.user.outer-url}")
    private String recharge_outer;
    @Value("${dgt.web.reset.user.outer-trl}")
    private String reset_outer;


    @Resource
    private RedisService redisService;

    /**
     * 时间戳
     */
    private String time = String.valueOf(System.currentTimeMillis());

    /**
     * MD5工具类
     */
    @Resource
    private MD5Util md5Util;


    /**
     * 逸富新增子账户
     *
     * @param user 逸富新增子账户参数
     * @param type 内外盘:0-内盘 1-外盘
     * @return 逸富新增子账户接口返回参数封装
     */
    public RegisterBack registerAPI(User user, Integer type) {
        Register register = new Register();
        RegisterBack registerBack = new RegisterBack();
        Map<String, String> registerMap = new LinkedHashMap<String, String>();
        String SignMsg;
        //内外盘 0内 1外
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            register.setOrgID("lxw");
            register.setAgentID("test");
            register.setPhone(user.getMobile());
            register.setSubAccountName(user.getMobile());
            register.setPassword(user.getPassword());
            register.setParentAccountID("8888061");
            register.setSystemID("1");
            register.setAccountType("1");
            register.setMarginTemplateID("110");
            register.setCommissionTemplateID("74");
            register.setRiskTemplateID("68");
            register.setMonitorID("test");
            register.setTimeStamp(time);
            register.setVersion(version);
            SignMsg = md5Util.MD5_Register(type, register.getOrgID(), register.getAgentID(), register.getPhone(), register.getSubAccountName(), register.getPassword(), register.getParentAccountID(), register.getSystemID(), register.getAccountType(), register.getMarginTemplateID(), register.getCommissionTemplateID(), register.getRiskTemplateID(), register.getMonitorID(), register.getTimeStamp(), register.getVersion());
            register.setSignMsg(SignMsg);
        } else {
            register.setOrgID("lxw");
            register.setAgentID("");
            register.setPhone(user.getMobile());
            register.setSubAccountName(user.getMobile());
            register.setPassword(user.getPassword());
            register.setParentAccountID("1000023");
            register.setSystemID("1");
            register.setAccountType("1");
            register.setMarginTemplateID("367");
            register.setCommissionTemplateID("589");
            register.setRiskTemplateID("357");
            register.setMonitorID("0001");
            register.setTimeStamp(time);
            register.setVersion(version);
            SignMsg = md5Util.MD5_Register(type, register.getOrgID(), register.getAgentID(), register.getPhone(), register.getSubAccountName(), register.getPassword(), register.getParentAccountID(), register.getSystemID(), register.getAccountType(), register.getMarginTemplateID(), register.getCommissionTemplateID(), register.getRiskTemplateID(), register.getMonitorID(), register.getTimeStamp(), register.getVersion());
            register.setSignMsg(SignMsg);
        }

        registerMap.put("OrgID", register.getOrgID());
        registerMap.put("AgentID", register.getAgentID());
        registerMap.put("Phone", register.getPhone());
        registerMap.put("SubAccountName", register.getSubAccountName());
        registerMap.put("Password", register.getPassword());
        registerMap.put("ParentAccountID", register.getParentAccountID());
        registerMap.put("SystemID", register.getSystemID());
        registerMap.put("AccountType", register.getAccountType());
        registerMap.put("MarginTemplateID", register.getMarginTemplateID());
        registerMap.put("CommissionTemplateID", register.getCommissionTemplateID());
        registerMap.put("RiskTemplateID", register.getRiskTemplateID());
        registerMap.put("MonitorID", register.getMonitorID());
        registerMap.put("TimeStamp", register.getTimeStamp());
        registerMap.put("Version", register.getVersion());
        registerMap.put("SignMsg", register.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(registerMap);

        String result = null;
        try {
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.putProcessRuntimeTask(insert_inner + "?" + query, registerMap);
            } else {
                result = HttpClientUtil.putProcessRuntimeTask(insert_outer + "?" + query, registerMap);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result);
        JsonArray array = null;
        JsonObject subObject = null;
        registerBack.setStatus(object.get("status").getAsInt());
        if (registerBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0) {
            array = object.get("data").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                subObject = array.get(i).getAsJsonObject();
                registerBack.setSubAccountID(subObject.get("SubAccountID").getAsString());
                registerBack.setSubLink(subObject.get("SubLink").getAsString());
                registerBack.setPassword(subObject.get("Password").getAsString());
            }
        } else {
            registerBack.setMessage(object.get("message").getAsString());
        }
        return registerBack;
    }

    /**
     * 查询子账户可出资金和保证金
     *
     * @param availableAndMargin 查询子账户可出资金和保证金所需呀的参数
     * @param type               内外盘:0-内盘 1-外盘
     * @return 查询子账户可出资金和保证金接口返回参数封装
     */
    public AvailableAndMarginBack getAvailableAndMargin(AvailableAndMargin availableAndMargin, Integer type) {
        AvailableAndMarginBack availableAndMarginBack = new AvailableAndMarginBack();
        Map<String, String> AvailableAndMarginMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + availableAndMargin.getUserId());
        User user;
        if (exists) {
            user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + availableAndMargin.getUserId());
        } else {
            return null;
        }
        availableAndMargin.setCurrency("CNY");
        availableAndMargin.setTimeStamp(time);
        availableAndMargin.setVersion(version);
        String SignMsg;
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            availableAndMargin.setSubAccountID(user.getSubAccountIdInner());
            SignMsg = md5Util.MD5_money(type, availableAndMargin.getSubAccountID(), availableAndMargin.getCurrency(), availableAndMargin.getTimeStamp(), availableAndMargin.getVersion());
        } else {
            availableAndMargin.setSubAccountID(user.getSubAccountIdOuter());
            SignMsg = md5Util.MD5_money(type, availableAndMargin.getSubAccountID(), availableAndMargin.getCurrency(), availableAndMargin.getTimeStamp(), availableAndMargin.getVersion());
        }
        availableAndMargin.setSignMsg(SignMsg);

        AvailableAndMarginMap.put("SubAccountID", availableAndMargin.getSubAccountID());
        AvailableAndMarginMap.put("Currency", availableAndMargin.getCurrency());
        AvailableAndMarginMap.put("TimeStamp", availableAndMargin.getTimeStamp());
        AvailableAndMarginMap.put("Version", availableAndMargin.getVersion());
        AvailableAndMarginMap.put("SignMsg", availableAndMargin.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(AvailableAndMarginMap);

        String result;
        try {
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.getProcessDefinitionList(margin_inner + "?" + query, AvailableAndMarginMap);
            } else {
                result = HttpClientUtil.getProcessDefinitionList(margin_outer + "?" + query, AvailableAndMarginMap);
            }
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array;
            JsonObject subObject;
            availableAndMarginBack.setStatus(object.get("status").getAsInt());
            if (availableAndMarginBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    //可出资金(单位:基础币种)
                    availableAndMarginBack.setAvailableFund(BigDecimal.valueOf(subObject.get("AvailableFund").getAsLong()));
                    //占用保证金(单位:子账户的基础币种)
                    availableAndMarginBack.setMarginFund(BigDecimal.valueOf(subObject.get("MarginFund").getAsLong()));
                    //子账户的基础币种
                    availableAndMarginBack.setBaseCurrency(subObject.get("BaseCurrency").getAsString());
                    //执行汇率
                    availableAndMarginBack.setExecRate(BigDecimal.valueOf(subObject.get("ExecRate").getAsLong()));
                }
            } else {
                availableAndMarginBack.setMessage(object.get("message").getAsString());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return availableAndMarginBack;
    }


    /**
     * 出入金
     *
     * @param rechargeAndWithdrawal 出入金参数
     * @param type                  内外盘:0-内盘 1-外盘
     * @return 出入金接口返回参数封装
     */
    public RechargeAndWithdrawalBack setRechargeAndWithdrawal(RechargeAndWithdrawal rechargeAndWithdrawal, Integer type) {
        RechargeAndWithdrawalBack rechargeAndWithdrawalBack = new RechargeAndWithdrawalBack();
        Map<String, String> RechargeAndWithdrawalMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + rechargeAndWithdrawal.getUserId());
        User user;
        if (exists) {
            user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + rechargeAndWithdrawal.getUserId());
        } else {
            return null;
        }
        rechargeAndWithdrawal.setCurrency("CNY");
        if (rechargeAndWithdrawal.getDirection().equals(ProjectConstant.SENDSMS_TYPE_1)) {
            // 当Direction为1时 判断占用保证金是否大于0，如果大于0则不能出金
            if (BigDecimal.valueOf(new Long(user.getMarginFund().toString())).compareTo(new BigDecimal(1)) > 0) {
                rechargeAndWithdrawal.setPosition(false);
            }
        } else {
            rechargeAndWithdrawal.setPosition(true);
        }
        rechargeAndWithdrawal.setTimeStamp(time);
        rechargeAndWithdrawal.setVersion(version);
        String str;
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            rechargeAndWithdrawal.setSubAccountID(user.getSubAccountIdInner());
            str = md5Util.MD5_rujin(type, rechargeAndWithdrawal.getSubAccountID(), rechargeAndWithdrawal.getCurrency(), rechargeAndWithdrawal.getDirection(), String.valueOf(rechargeAndWithdrawal.getAmount()), String.valueOf(rechargeAndWithdrawal.isPosition()), rechargeAndWithdrawal.getTimeStamp(), rechargeAndWithdrawal.getVersion());
        } else {
            rechargeAndWithdrawal.setSubAccountID(user.getSubAccountIdOuter());
            str = md5Util.MD5_rujin(type, rechargeAndWithdrawal.getSubAccountID(), rechargeAndWithdrawal.getCurrency(), rechargeAndWithdrawal.getDirection(), String.valueOf(rechargeAndWithdrawal.getAmount()), String.valueOf(rechargeAndWithdrawal.isPosition()), rechargeAndWithdrawal.getTimeStamp(), rechargeAndWithdrawal.getVersion());
        }
        rechargeAndWithdrawal.setSignMsg(str);


        RechargeAndWithdrawalMap.put("SubAccountID", rechargeAndWithdrawal.getSubAccountID());
        RechargeAndWithdrawalMap.put("Currency", rechargeAndWithdrawal.getCurrency());
        RechargeAndWithdrawalMap.put("Direction", rechargeAndWithdrawal.getDirection());
        RechargeAndWithdrawalMap.put("Amount", rechargeAndWithdrawal.getAmount().toString());
        RechargeAndWithdrawalMap.put("Position", String.valueOf(rechargeAndWithdrawal.isPosition()));
        RechargeAndWithdrawalMap.put("TimeStamp", rechargeAndWithdrawal.getTimeStamp());
        RechargeAndWithdrawalMap.put("Version", rechargeAndWithdrawal.getVersion());
        RechargeAndWithdrawalMap.put("SignMsg", rechargeAndWithdrawal.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(RechargeAndWithdrawalMap);

        String result = null;
        try {
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.putProcessRuntimeTask(recharge_inner + "?" + query, RechargeAndWithdrawalMap);
            } else {
                result = HttpClientUtil.putProcessRuntimeTask(recharge_outer + "?" + query, RechargeAndWithdrawalMap);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result);
        JsonArray array;
        JsonObject subObject;
        rechargeAndWithdrawalBack.setStatus(object.get("status").getAsInt());
        if (rechargeAndWithdrawalBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0 || rechargeAndWithdrawalBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_2003 || rechargeAndWithdrawalBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_2004) {
            array = object.get("data").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                subObject = array.get(i).getAsJsonObject();
                rechargeAndWithdrawalBack.setArrivalAmount(BigDecimal.valueOf(subObject.get("ArrivalAmount").getAsLong()));
                rechargeAndWithdrawalBack.setAvailableFund(BigDecimal.valueOf(subObject.get("AvailableFund").getAsLong()));
                rechargeAndWithdrawalBack.setMarginFund(BigDecimal.valueOf(subObject.get("MarginFund").getAsLong()));
                rechargeAndWithdrawalBack.setBaseCurrency(subObject.get("BaseCurrency").getAsString());
                rechargeAndWithdrawalBack.setExecRate(BigDecimal.valueOf(subObject.get("ExecRate").getAsLong()));
            }
        } else {
            rechargeAndWithdrawalBack.setMessage(object.get("message").getAsString());
        }
        return rechargeAndWithdrawalBack;
    }


    /**
     * 重置密码
     *
     * @param resetPassword 重置密码参数
     * @param type          内外盘:0-内盘 1-外盘
     * @return 重置密码接口返回参数封装
     */
    public ResetPasswordBack setResetPassword(ResetPassword resetPassword, Integer type) {
        ResetPasswordBack resetPasswordBack = new ResetPasswordBack();
        Map<String, String> ResetPasswordMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + resetPassword.getUserId());
        User user;
        if (exists) {
            user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + resetPassword.getUserId());
        } else {
            return null;
        }
        resetPassword.setTimeStamp(time);
        resetPassword.setVersion(version);
        String str;
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            resetPassword.setSubAccountID(user.getSubAccountIdInner());
            str = md5Util.MD5_password(type, resetPassword.getPassword(), resetPassword.getSubAccountID(), resetPassword.getTimeStamp(), resetPassword.getVersion());
        } else {
            resetPassword.setSubAccountID(user.getSubAccountIdOuter());
            str = md5Util.MD5_password(type, resetPassword.getPassword(), resetPassword.getSubAccountID(), resetPassword.getTimeStamp(), resetPassword.getVersion());
        }
        resetPassword.setSignMsg(str);

        ResetPasswordMap.put("Password", resetPassword.getPassword());
        ResetPasswordMap.put("SubAccountID", resetPassword.getSubAccountID());
        ResetPasswordMap.put("TimeStamp", resetPassword.getTimeStamp());
        ResetPasswordMap.put("Version", resetPassword.getVersion());
        ResetPasswordMap.put("SignMsg", resetPassword.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(ResetPasswordMap);

        String result;
        try {
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.postHistoryProcessInstancesList(reset_inner + "?" + query, ResetPasswordMap);
            } else {
                result = HttpClientUtil.postHistoryProcessInstancesList(reset_outer + "?" + query, ResetPasswordMap);
            }
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            resetPasswordBack.setStatus(object.get("status").getAsInt());
            resetPasswordBack.setMessage(object.get("message").getAsString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resetPasswordBack;
    }


    /**
     * 绑定银行卡
     *
     * @param bindingBankCard 绑定银行卡参数
     * @param type            内外盘:0-内盘 1-外盘
     * @return 绑定银行卡接口返回参数封装
     */
    public BindingBankCardBack setBindingBankCard(BindingBankCard bindingBankCard, Integer type) {
        BindingBankCardBack bindingBankCardBack = new BindingBankCardBack();
        Map<String, String> BindingBankCardMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + bindingBankCard.getUserId());
        User user;
        if (exists) {
            user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + bindingBankCard.getUserId());
        } else {
            return null;
        }
        bindingBankCard.setTimeStamp(time);
        bindingBankCard.setVersion(version);
        String str;
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            bindingBankCard.setSubAccountID(user.getSubAccountIdInner());
            str = md5Util.MD5_bangding(type, bindingBankCard.getBankName(), bindingBankCard.getName(), bindingBankCard.getBankAccount(), bindingBankCard.getSubAccountID(), bindingBankCard.getTimeStamp(), bindingBankCard.getVersion());
        } else {
            bindingBankCard.setSubAccountID(user.getSubAccountIdOuter());
            str = md5Util.MD5_bangding(type, bindingBankCard.getBankName(), bindingBankCard.getName(), bindingBankCard.getBankAccount(), bindingBankCard.getSubAccountID(), bindingBankCard.getTimeStamp(), bindingBankCard.getVersion());
        }
        bindingBankCard.setSignMsg(str);

        BindingBankCardMap.put("BankName", bindingBankCard.getBankName());
        BindingBankCardMap.put("Name", bindingBankCard.getName());
        BindingBankCardMap.put("BankAccount", bindingBankCard.getBankAccount());
        BindingBankCardMap.put("SubAccountID", bindingBankCard.getSubAccountID());
        BindingBankCardMap.put("TimeStamp", bindingBankCard.getTimeStamp());
        BindingBankCardMap.put("Version", bindingBankCard.getVersion());
        BindingBankCardMap.put("SignMsg", bindingBankCard.getSignMsg());


        String query = MapToStringSplicing.createLinkStringByGet(BindingBankCardMap);

        String result;
        try {
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.putProcessRuntimeTask(bangding_inner + "?" + query, BindingBankCardMap);
            } else {
                result = HttpClientUtil.putProcessRuntimeTask(bangding_outer + "?" + query, BindingBankCardMap);
            }
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array;
            JsonObject subObject;
            bindingBankCardBack.setStatus(object.get("status").getAsInt());
            if (bindingBankCardBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    //	银行名称
                    bindingBankCardBack.setBankName(subObject.get("BankName").getAsString());
                    //	姓名
                    bindingBankCardBack.setName(subObject.get("Name").getAsString());
                    //	银行卡号
                    bindingBankCardBack.setBankAccount(subObject.get("BankAccount").getAsString());
                }
            } else {
                bindingBankCardBack.setMessage(object.get("message").getAsString());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bindingBankCardBack;
    }

    /**
     * 解绑银行卡
     *
     * @param untieBankCard 解绑银行卡参数
     * @param type          内外盘:0-内盘 1-外盘
     * @return 解绑银行卡接口返回参数封装
     */
    public UntieBankCardBack setUntieBankCard(UntieBankCard untieBankCard, Integer type) {
        UntieBankCardBack untieBankCardBack = new UntieBankCardBack();
        Map<String, String> UntieBankCardMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists(ProjectConstant.DGT_LOGIN_USER_ID_KEY + untieBankCard.getUserId());
        User user;
        if (exists) {
            user = (User) redisService.get(ProjectConstant.DGT_LOGIN_USER_ID_KEY + untieBankCard.getUserId());
        } else {
            return null;
        }
        untieBankCard.setBankAccount(untieBankCard.getBankAccount().replace(" ", ""));
        untieBankCard.setTimeStamp(time);
        untieBankCard.setVersion(version);
        String str;
        if (type == ProjectConstant.YIFU_TYPE_INNER) {
            untieBankCard.setSubAccountID(user.getSubAccountIdInner());
            str = md5Util.MD5_jiebang(type, untieBankCard.getBankAccount(), untieBankCard.getSubAccountID(), untieBankCard.getTimeStamp(), untieBankCard.getVersion());
        } else {
            untieBankCard.setSubAccountID(user.getSubAccountIdOuter());
            str = md5Util.MD5_jiebang(type, untieBankCard.getBankAccount(), untieBankCard.getSubAccountID(), untieBankCard.getTimeStamp(), untieBankCard.getVersion());
        }
        untieBankCard.setSignMsg(str);

        UntieBankCardMap.put("BankAccount", untieBankCard.getBankAccount());
        UntieBankCardMap.put("SubAccountID", untieBankCard.getSubAccountID());
        UntieBankCardMap.put("TimeStamp", untieBankCard.getTimeStamp());
        UntieBankCardMap.put("Version", untieBankCard.getVersion());
        UntieBankCardMap.put("SignMsg", untieBankCard.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(UntieBankCardMap);

        try {
            String result;
            if (type == ProjectConstant.YIFU_TYPE_INNER) {
                result = HttpClientUtil.deleteProcessRuntimeIdentityLink(jiebang_inner + "?" + query, UntieBankCardMap);
            } else {
                result = HttpClientUtil.deleteProcessRuntimeIdentityLink(jiebang_outer + "?" + query, UntieBankCardMap);
            }
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array;
            JsonObject subObject;
            untieBankCardBack.setStatus(object.get("status").getAsInt());
            if (untieBankCardBack.getStatus() == ProjectConstant.RECHARGEANDWITHDRAWAL_CODE_0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    //银行名称
                    untieBankCardBack.setBankName(subObject.get("BankName").getAsString());
                    //姓名
                    untieBankCardBack.setName(subObject.get("Name").getAsString());
                    //银行卡号
                    untieBankCardBack.setBankAccount(subObject.get("BankAccount").getAsString());
                }
            } else {
                untieBankCardBack.setMessage(object.get("message").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return untieBankCardBack;
    }

}
