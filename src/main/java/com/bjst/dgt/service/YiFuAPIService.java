package com.bjst.dgt.service;

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
import org.springframework.beans.factory.annotation.Value;

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
public class YiFuAPIService {

    @Resource
    private static RedisService redisService;

    /**
     * 状态码
     */
    private static Integer status;
    /**
     * 信息
     */
    private static String message;

    /**
     * 时间戳
     */
    private static String time = String.valueOf(new Date().getTime());

    @Value("${dgt.web.untie.user-url}")
    private static String jiebang;
    @Value("${dgt.web.binding.user-url}")
    private static String bangding;
    @Value("${dgt.web.insert.user-url}")
    private static String insert;
    @Value("${dgt.web.margin.user-url}")
    private static String margin;
    @Value("${dgt.web.recharge.user-url}")
    private static String recharge;
    @Value("${dgt.web.reset.user-trl}")
    private static String reset;


    /**
     * 逸富新增子账户
     *
     * @param user User对象
     * @param in   内外盘
     * @return RegisterBack对象
     */
    public static RegisterBack registerAPI(User user, Integer in) {
        Register register = new Register();
        RegisterBack registerBack = new RegisterBack();
        Map<String, String> registerMap = new LinkedHashMap<String, String>();
        String SignMsg = "";
        //内外盘 0内 1外
        if (in == 0) {
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
            register.setVersion("1.0");
            SignMsg = MD5Util.MD5_Register(0, register.getOrgID(), register.getAgentID(), register.getPhone(), register.getSubAccountName(), register.getPassword(), register.getParentAccountID(), register.getSystemID(), register.getAccountType(), register.getMarginTemplateID(), register.getCommissionTemplateID(), register.getRiskTemplateID(), register.getMonitorID(), register.getTimeStamp(), register.getVersion());
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
            register.setVersion("1.0");
            SignMsg = MD5Util.MD5_Register(1, register.getOrgID(), register.getAgentID(), register.getPhone(), register.getSubAccountName(), register.getPassword(), register.getParentAccountID(), register.getSystemID(), register.getAccountType(), register.getMarginTemplateID(), register.getCommissionTemplateID(), register.getRiskTemplateID(), register.getMonitorID(), register.getTimeStamp(), register.getVersion());
        }
        register.setSignMsg(SignMsg);

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
            if (in == 0) {
                result = HttpClientUtil.putProcessRuntimeTask(insert + "?" + query, registerMap);
            } else {
                result = HttpClientUtil.putProcessRuntimeTask(insert + "?" + query, registerMap);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result);
        JsonArray array = null;
        JsonObject subObject = null;
        status = object.get("status").getAsInt();
        if (status == 0) {
            array = object.get("data").getAsJsonArray();
            for (int i = 0; i < array.size(); i++) {
                subObject = array.get(i).getAsJsonObject();
                registerBack.setSubAccountID(subObject.get("SubAccountID").getAsString());
                registerBack.setSubLink(subObject.get("SubLink").getAsString());
                registerBack.setPassword(subObject.get("Password").getAsString());
            }
        } else {
            message = object.get("message").getAsString();
        }
        return registerBack;
    }

    /**
     * 查询子账户可出资金和保证金
     *
     * @param availableAndMargin AvailableAndMargin对象
     * @return AvailableAndMarginBack对象
     */
    public static AvailableAndMarginBack getAvailableAndMargin(AvailableAndMargin availableAndMargin) {
        AvailableAndMarginBack availableAndMarginBack = new AvailableAndMarginBack();
        Map<String, String> AvailableAndMarginMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists("User");
        User user = new User();
        if (exists) {
            user = (User) redisService.get("User");
        } else {
            return null;
        }
        availableAndMargin.setSubAccountID(user.getSubAccountIdInner());
        availableAndMargin.setCurrency("CNY");
        availableAndMargin.setTimeStamp(time);
        availableAndMargin.setVersion("1.0");
        String SignMsg = MD5Util.MD5_money(availableAndMargin.getSubAccountID(), availableAndMargin.getCurrency(), availableAndMargin.getTimeStamp(), availableAndMargin.getVersion());
        availableAndMargin.setSignMsg(SignMsg);

        AvailableAndMarginMap.put("SubAccountID", availableAndMargin.getSubAccountID());
        AvailableAndMarginMap.put("Currency", availableAndMargin.getCurrency());
        AvailableAndMarginMap.put("TimeStamp", availableAndMargin.getTimeStamp());
        AvailableAndMarginMap.put("Version", availableAndMargin.getVersion());
        AvailableAndMarginMap.put("SignMsg", availableAndMargin.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(AvailableAndMarginMap);

        String result = null;
        try {
            result = HttpClientUtil.getProcessDefinitionList(margin + "?" + query, AvailableAndMarginMap);
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array = null;
            JsonObject subObject = null;
            status = object.get("status").getAsInt();
            if (status == 0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    availableAndMarginBack.setAvailableFund(BigDecimal.valueOf(subObject.get("AvailableFund").getAsLong()));//可出资金(单位:基础币种)
                    availableAndMarginBack.setMarginFund(BigDecimal.valueOf(subObject.get("MarginFund").getAsLong()));//占用保证金(单位:子账户的基础币种)
                    availableAndMarginBack.setBaseCurrency(subObject.get("BaseCurrency").getAsString());//	子账户的基础币种
                    availableAndMarginBack.setExecRate(BigDecimal.valueOf(subObject.get("ExecRate").getAsLong()));//	执行汇率
                }
            } else {
                message = object.get("message").getAsString();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return availableAndMarginBack;
    }

    /**
     * 出入金
     *
     * @param rechargeAndWithdrawal RechargeAndWithdrawal对象
     * @return RechargeAndWithdrawalBack对象
     */
    public static RechargeAndWithdrawalBack setRechargeAndWithdrawal(RechargeAndWithdrawal rechargeAndWithdrawal) {
        RechargeAndWithdrawalBack rechargeAndWithdrawalBack = new RechargeAndWithdrawalBack();
        Map<String, String> RechargeAndWithdrawalMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists("User");
        User user = new User();
        if (exists) {
            user = (User) redisService.get("User");
            //内
            rechargeAndWithdrawal.setSubAccountID(user.getSubAccountIdInner());
            //TODO 外
        } else {
            return null;
        }
        rechargeAndWithdrawal.setCurrency("CNY");
        if (rechargeAndWithdrawal.getDirection().equals("1")) {
            // 当Direction为1时 判断占用保证金是否大于0，如果大于0则不能出金
            if (BigDecimal.valueOf(new Long(user.getMarginFund().toString())).compareTo(new BigDecimal(1)) > 0) {
                rechargeAndWithdrawal.setPosition(false);
            }
        } else {
            rechargeAndWithdrawal.setPosition(true);
        }
        rechargeAndWithdrawal.setTimeStamp(time);
        rechargeAndWithdrawal.setVersion("1.0");
        String str = MD5Util.MD5_rujin(rechargeAndWithdrawal.getSubAccountID(), rechargeAndWithdrawal.getCurrency(), rechargeAndWithdrawal.getDirection(), String.valueOf(rechargeAndWithdrawal.getAmount()), String.valueOf(rechargeAndWithdrawal.isPosition()), rechargeAndWithdrawal.getTimeStamp(), rechargeAndWithdrawal.getVersion());
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
            result = HttpClientUtil.putProcessRuntimeTask(recharge + "?" + query, RechargeAndWithdrawalMap);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result);
        JsonArray array = null;
        JsonObject subObject = null;
        status = object.get("status").getAsInt();
        if (status == 0 || status == 2003 || status == 2004) {
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
            message = object.get("message").getAsString();
        }

        return rechargeAndWithdrawalBack;
    }

    /**
     * 重置密码
     *
     * @param resetPassword ResetPassword对象
     * @return Result结果
     */
    public static Result ResetPassword(ResetPassword resetPassword) {
        Map<String, String> ResetPasswordMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists("User");
        User user = new User();
        if (exists) {
            user = (User) redisService.get("User");
            //内
            resetPassword.setSubAccountID(user.getSubAccountIdInner());
            //TODO 外
        } else {
            return null;
        }
        resetPassword.setTimeStamp(time);
        resetPassword.setVersion("1.0");
        String str = MD5Util.MD5_password(resetPassword.getPassword(), resetPassword.getSubAccountID(), resetPassword.getTimeStamp(), resetPassword.getVersion());
        resetPassword.setSignMsg(str);

        ResetPasswordMap.put("Password", resetPassword.getPassword());
        ResetPasswordMap.put("SubAccountID", resetPassword.getSubAccountID());
        ResetPasswordMap.put("TimeStamp", resetPassword.getTimeStamp());
        ResetPasswordMap.put("Version", resetPassword.getVersion());
        ResetPasswordMap.put("SignMsg", resetPassword.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(ResetPasswordMap);

        String result = null;
        try {
            result = HttpClientUtil.postHistoryProcessInstancesList(reset + "?" + query, ResetPasswordMap);
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array = null;
            JsonObject subObject = null;
            status = object.get("status").getAsInt();
            message = object.get("message").getAsString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (status == 0) {
            redisService.remove("User");
            return ResultGenerator.genSuccessResult("重置密码成功", ResultCode.SUCCESS);
        } else {
            return ResultGenerator.genSuccessResult("重置密码失败", ResultCode.FAIL);
        }
    }

    /**
     * 绑定银行卡
     *
     * @param bindingBankCard BindingBankCard对象
     * @return BindingBankCardBack对象
     */
    public static BindingBankCardBack setBindingBankCard(BindingBankCard bindingBankCard) {
        BindingBankCardBack bindingBankCardBack = new BindingBankCardBack();
        Map<String, String> BindingBankCardMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists("User");
        User user = new User();
        if (exists) {
            user = (User) redisService.get("User");
            //内
            bindingBankCard.setSubAccountID(user.getSubAccountIdInner());
            //TODO 外
        } else {
            return null;
        }
        bindingBankCard.setTimeStamp(time);
        bindingBankCard.setVersion("1.0");
        String str = MD5Util.MD5_bangding(bindingBankCard.getBankName(), bindingBankCard.getName(), bindingBankCard.getBankAccount(), bindingBankCard.getSubAccountID(), bindingBankCard.getTimeStamp(), bindingBankCard.getVersion());
        bindingBankCard.setSignMsg(str);

        BindingBankCardMap.put("BankName", bindingBankCard.getBankName());
        BindingBankCardMap.put("Name", bindingBankCard.getName());
        BindingBankCardMap.put("BankAccount", bindingBankCard.getBankAccount());
        BindingBankCardMap.put("SubAccountID", bindingBankCard.getSubAccountID());
        BindingBankCardMap.put("TimeStamp", bindingBankCard.getTimeStamp());
        BindingBankCardMap.put("Version", bindingBankCard.getVersion());
        BindingBankCardMap.put("SignMsg", bindingBankCard.getSignMsg());


        String query = MapToStringSplicing.createLinkStringByGet(BindingBankCardMap);

        String result = null;
        try {
            result = HttpClientUtil.putProcessRuntimeTask(bangding + "?" + query, BindingBankCardMap);
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array = null;
            JsonObject subObject = null;
            status = object.get("status").getAsInt();
            if (status == 0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    bindingBankCardBack.setBankName(subObject.get("BankName").getAsString());//	银行名称
                    bindingBankCardBack.setName(subObject.get("Name").getAsString());//	姓名
                    bindingBankCardBack.setBankAccount(subObject.get("BankAccount").getAsString());//	银行卡号
                }
            } else {
                message = object.get("message").getAsString();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bindingBankCardBack;
    }

    /**
     * 解绑银行卡
     *
     * @param untieBankCard UntieBankCard对象
     * @return UntieBankCardBack对象
     */
    public static UntieBankCardBack setUntieBankCard(UntieBankCard untieBankCard) {
        UntieBankCardBack untieBankCardBack = new UntieBankCardBack();
        Map<String, String> UntieBankCardMap = new LinkedHashMap<String, String>();
        boolean exists = redisService.exists("User");
        User user = new User();
        if (exists) {
            user = (User) redisService.get("User");
            //内
            untieBankCard.setSubAccountID(user.getSubAccountIdInner());
            //TODO 外
        } else {
            return null;
        }
        untieBankCard.setBankAccount(untieBankCard.getBankAccount().replace(" ", ""));
        untieBankCard.setTimeStamp(time);
        untieBankCard.setVersion("1.0");
        String str = MD5Util.MD5_jiebang(untieBankCard.getBankAccount(), untieBankCard.getSubAccountID(), untieBankCard.getTimeStamp(), untieBankCard.getVersion());
        untieBankCard.setSignMsg(str);

        UntieBankCardMap.put("BankAccount", untieBankCard.getBankAccount());
        UntieBankCardMap.put("SubAccountID", untieBankCard.getSubAccountID());
        UntieBankCardMap.put("TimeStamp", untieBankCard.getTimeStamp());
        UntieBankCardMap.put("Version", untieBankCard.getVersion());
        UntieBankCardMap.put("SignMsg", untieBankCard.getSignMsg());

        String query = MapToStringSplicing.createLinkStringByGet(UntieBankCardMap);

        try {
            String result = HttpClientUtil.deleteProcessRuntimeIdentityLink(jiebang + "?" + query, UntieBankCardMap);
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(result);
            JsonArray array = null;
            JsonObject subObject = null;
            status = object.get("status").getAsInt();
            if (status == 0) {
                array = object.get("data").getAsJsonArray();
                for (int i = 0; i < array.size(); i++) {
                    subObject = array.get(i).getAsJsonObject();
                    untieBankCardBack.setBankName(subObject.get("BankName").getAsString());//	银行名称
                    untieBankCardBack.setName(subObject.get("Name").getAsString());//	姓名
                    untieBankCardBack.setBankAccount(subObject.get("BankAccount").getAsString());//	银行卡号
                }
            } else {
                message = object.get("message").getAsString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return untieBankCardBack;
    }

}
