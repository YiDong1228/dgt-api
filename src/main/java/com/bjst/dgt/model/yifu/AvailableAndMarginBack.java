package com.bjst.dgt.model.yifu;

import java.math.BigDecimal;

/**
 * @Description: 查询子账户可出资金和保证金接口返回
 * @Author: yd
 * @CreateDate: 2018/06/28 02:06 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 02:06 PM
 * @UpdateRemark: 查询子账户可出资金和保证金接口返回
 * @Version: 1.0
 */
public class AvailableAndMarginBack {
    private BigDecimal AvailableFund;//	number	可出资金(单位:基础币种)
    private BigDecimal MarginFund;//	number	占用保证金(单位:子账户的基础币种)
    private String BaseCurrency;//	string	子账户的基础币种
    private BigDecimal ExecRate;//	number	执行汇率

    public BigDecimal getAvailableFund() {
        return AvailableFund;
    }

    public void setAvailableFund(BigDecimal availableFund) {
        AvailableFund = availableFund;
    }

    public BigDecimal getMarginFund() {
        return MarginFund;
    }

    public void setMarginFund(BigDecimal marginFund) {
        MarginFund = marginFund;
    }

    public String getBaseCurrency() {
        return BaseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        BaseCurrency = baseCurrency;
    }

    public BigDecimal getExecRate() {
        return ExecRate;
    }

    public void setExecRate(BigDecimal execRate) {
        ExecRate = execRate;
    }
}
