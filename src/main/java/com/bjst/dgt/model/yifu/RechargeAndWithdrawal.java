package com.bjst.dgt.model.yifu;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 3.6 出入金
 * 接口功能
 * 对子账户可用资金进行出金或入金
 * URL
 * /api/subtransfers
 * HTTP请求方式
 * PUT
 * 支持格式
 * JSON
 */
public class RechargeAndWithdrawal implements Serializable {
    private String subAccountID;//	string	16	是	子账户代码
    private String currency;//	string	10	是	币种，参考币种列表
    private String direction;//	string	1	是	出金或入金。0-入金，1-出金
    private BigDecimal amount;//	number	10	是	金额，保留2位小数
    private boolean position;//	boolean	4	是	当Direction为1时是否判断占用保证金大于0，如果大于0则不能出金
    private String source;//	string	16	否	来源, 本字段不参与加密
    private String timeStamp;//	string	13	是	时间戳,13位时间格式
    private String version;//	string	10	是	版本号，默认值：1.0
    private String signMsg;//	string	32	是	签名串

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
