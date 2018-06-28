package com.bjst.dgt.model.yifu;

import java.io.Serializable;

/**
 * 3.5 查询子账户可出资金和保证金
 * 接口功能
 * 根据子账户代码查询子账户的可出资金和占用保证金,用于判断出金金额和是否有持仓和挂单。
 * URL
 * /api/subaccounts/fund
 * HTTP请求方式
 * GET
 * 支持格式
 * JSON
 */
public class AvailableAndMargin implements Serializable {
    private String subAccountID;//	string	16	是	子账户代码
    private String currency;//		string	10	是	币种，参考币种列表
    private String timeStamp;//		string	13	是	时间戳,13位时间格式
    private String version;//		string	10	是	版本号，默认值：1.0
    private String signMsg;//		string	32	是	签名串

    public String getSubAccountID() {
        return subAccountID;
    }

    public void setSubAccountID(String subAccountID) {
        this.subAccountID = subAccountID;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
