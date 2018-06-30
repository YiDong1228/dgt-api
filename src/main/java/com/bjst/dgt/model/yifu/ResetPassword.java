package com.bjst.dgt.model.yifu;

import java.io.Serializable;

/**
 * 3.10 重置密码
 * 接口功能
 * 根据子账户所属的手机号重置当前子账户密码
 * URL
 * /api/subaccounts/password
 * HTTP请求方式
 * POST
 * 支持格式
 * JSON
 */
public class ResetPassword implements Serializable {
    private String password;//	string	32	是	新密码
    private String subAccountID;//	string	16	是	子账户代码
    private String timeStamp;//	string	13	是	时间戳,13位时间格式
    private String version;//	string	10	是	版本号，默认值：1.0
    private String signMsg;//	string	32	是	签名串

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
