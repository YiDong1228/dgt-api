package com.bjst.dgt.model.yifu;

import java.math.BigDecimal;

/**
 * @Description: 出入金接口返回
 * @Author: yd
 * @CreateDate: 2018/06/28 02:49 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 02:49 PM
 * @UpdateRemark: 出入金接口返回
 * @Version: 1.0
 */
public class RechargeAndWithdrawalBack {
    private BigDecimal arrivalAmount;//	number	到账金额。(参数金额*参数币种对基础币种汇率)
    private BigDecimal availableFund;//	number	可出资金(单位:基础币种)
    private BigDecimal marginFund;//	number	占用保证金(单位:子账户的基础币种)
    private String baseCurrency;//	string	子账户的基础币种
    private BigDecimal execRate;//	number	执行汇率

    public BigDecimal getArrivalAmount() {
        return arrivalAmount;
    }

    public void setArrivalAmount(BigDecimal arrivalAmount) {
        this.arrivalAmount = arrivalAmount;
    }

    public BigDecimal getAvailableFund() {
        return availableFund;
    }

    public void setAvailableFund(BigDecimal availableFund) {
        this.availableFund = availableFund;
    }

    public BigDecimal getMarginFund() {
        return marginFund;
    }

    public void setMarginFund(BigDecimal marginFund) {
        this.marginFund = marginFund;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public BigDecimal getExecRate() {
        return execRate;
    }

    public void setExecRate(BigDecimal execRate) {
        this.execRate = execRate;
    }
}
