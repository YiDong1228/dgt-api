package com.bjst.dgt.model.yifu;

import java.io.Serializable;

/**
 * 3.13 绑定银行卡
 * 接口功能
 * 对子账户出金绑定银行卡
 * URL
 * /api/subaccounts/banks
 * HTTP请求方式
 * PUT
 * 支持格式
 * JSON
 */
public class BindingBankCard implements Serializable {
    private String bankName;//	string	16	是	银行名称
    private String name;//	string	16	是	姓名
    private String bankAccount;//	string	19	是	银行卡号(16-19位)
    private String subAccountID;//	string	16	是	子账户代码
    private String timeStamp;//	string	13	是	时间戳,13位时间格式
    private String version;//	string	10	是	版本号，默认值：1.0
    private String signMsg;//	string	32	是	签名串

    private String user_id;

    private String id;

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

    public String getSubAccountID() {
        return subAccountID;
    }

    public void setSubAccountID(String subAccountID) {
        this.subAccountID = subAccountID;
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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
