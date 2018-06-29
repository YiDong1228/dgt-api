package com.bjst.dgt.model.yifu;

import java.io.Serializable;

/**
 * 3.14 解绑银行卡
 * 接口功能
 * 对子账户出金解绑银行卡
 * URL
 * /api/subaccounts/banks
 * HTTP请求方式
 * DELETE
 * 支持格式
 * JSON
 */
public class UntieBankCard implements Serializable {
    private String BankAccount;//	string	19	是	银行卡号(16-19位)
    private String SubAccountID;//	string	16	是	子账户代码
    private String TimeStamp;//	string	13	是	时间戳,13位时间格式
    private String Version;//	string	10	是	版本号，默认值：1.0
    private String SignMsg;//	string	32	是	签名串

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }

    public String getSubAccountID() {
        return SubAccountID;
    }

    public void setSubAccountID(String subAccountID) {
        SubAccountID = subAccountID;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getSignMsg() {
        return SignMsg;
    }

    public void setSignMsg(String signMsg) {
        SignMsg = signMsg;
    }
}
