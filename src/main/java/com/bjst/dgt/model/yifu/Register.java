package com.bjst.dgt.model.yifu;

import java.io.Serializable;

/**
 * 3.4 新增子账户
 * 接口功能
 * 用于账户注册
 * URL
 * /api/subaccounts
 * HTTP请求方式
 * PUT
 * 支持格式
 * JSON
 */
public class Register implements Serializable {
    private String orgID;//	string	16	是	机构代码，当AgentID为空时有效
    private String agentID;//	string	16	是	代理人代码，为空时子账户所属机构
    private String phone;//	string	11	是	手机号码
    private String subAccountName;//	string	16	是	子账户名称
    private String password;//	string	32	是	子账户密码
    private String parentAccountID;//	string	16	是	总账户代码
    private String systemID;//	string	16	是	交易系统代码
    private String accountType;//	string	1	是	账户类型
    private String marginTemplateID;//	string	16	是	保证金模版代码
    private String commissionTemplateID;//	string	16	是	子账户手续费模版代码
    private String riskTemplateID;//	string	16	是	风控模版代码
    private String monitorID;//	string	16	是	风控员代码。可为空，为空时不绑定风控员，多个以'|'分隔
    private String bankName;//	string	16	否	可选值。银行名称。如填写需要把银行卡号和真实姓名一并填写
    private String name;//	string	16	否	可选值。银行卡号对应的姓名。如填写需要把银行卡号和银行名称一并填写
    private String bankAccount;//	string	16	否	可选值。银行卡号。如填写需要把银行名称和真实姓名一并填写
    private boolean notify;//	boolean	4	否	可选值。默认false，为true时注册成功自动发送通知短信
    private String customAccount;//	string	16	否	可选值。自定义子账户代码，若填写则不用系统生成的子账户代码而使用这个，账户代码需要先判断唯一性
    private String timeStamp;//	string	13	是	时间戳,13位时间格式
    private String version;//	string	10	是	版本号，默认值：1.0
    private String signMsg;//	string	32	是	签名串


/*          错误列表
status	    message	                            说明
1004	    机构不存在	                        没有找到对应的机构
1005	    代理人不存在	                    没有找到对应的代理人
1006	    总账户不存在	                    没有找到对应的总账户
1007	    交易系统不存在	                    没有找到对应的交易系统
1008	    保证金模版不存在	                没有找到对应的保证金模版
1009	    子账户手续费模版不存在	            没有找到对应的子账户手续费模版
1010	    风控模版不存在	                    没有找到对应的风控模版
1011	    风控员不存在	                    没有找到对应的风控员
1012	    自定义子账户代码已存在	            子账户代码不能重复
1013	    手机号已存在	                    手机号不能重复
1014	    银行名称不存在	                    银行列表没有这个银行
1015	    不支持的子账户类型	                账户类型非法填写
1016	    机构子账户数量已满	                子账户数量超出机构限制
1017	    自定义子账户代码不能为空	        CustomAccount不能为空
1018	    子账户代码生成失败	                系统Broker非法
1019	    账户新增成功,开户通知短信发送失败	手机号错误或者短信配置错误
1020	    银行信息不全	                    银行名称、帐号、姓名必须有
3001	    短信发送失败	                    可能是手机号格式错误或未设置短信渠道
*/

    public String getOrgID() {
        return orgID;
    }

    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSubAccountName() {
        return subAccountName;
    }

    public void setSubAccountName(String subAccountName) {
        this.subAccountName = subAccountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParentAccountID() {
        return parentAccountID;
    }

    public void setParentAccountID(String parentAccountID) {
        this.parentAccountID = parentAccountID;
    }

    public String getSystemID() {
        return systemID;
    }

    public void setSystemID(String systemID) {
        this.systemID = systemID;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMarginTemplateID() {
        return marginTemplateID;
    }

    public void setMarginTemplateID(String marginTemplateID) {
        this.marginTemplateID = marginTemplateID;
    }

    public String getCommissionTemplateID() {
        return commissionTemplateID;
    }

    public void setCommissionTemplateID(String commissionTemplateID) {
        this.commissionTemplateID = commissionTemplateID;
    }

    public String getRiskTemplateID() {
        return riskTemplateID;
    }

    public void setRiskTemplateID(String riskTemplateID) {
        this.riskTemplateID = riskTemplateID;
    }

    public String getMonitorID() {
        return monitorID;
    }

    public void setMonitorID(String monitorID) {
        this.monitorID = monitorID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public String getCustomAccount() {
        return customAccount;
    }

    public void setCustomAccount(String customAccount) {
        this.customAccount = customAccount;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg;
    }
}
