package com.bjst.dgt.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "trading_rules")
public class TradingRules {
    /**
     * 产品code
     */
    @Id
    private String code;

    /**
     * 波动价值
     */
    @Column(name = "volatility_price")
    private BigDecimal volatilityPrice;

    /**
     * 汇率
     */
    private BigDecimal exchangerate;

    /**
     * 单笔交易费用
     */
    @Column(name = "single_transaction_costs")
    private BigDecimal singleTransactionCosts;

    /**
     * 单笔默认保证金
     */
    @Column(name = "single_default_margin")
    private BigDecimal singleDefaultMargin;

    /**
     * 默认点数
     */
    @Column(name = "default_points")
    private BigDecimal defaultPoints;

    /**
     * 获取产品code
     *
     * @return code - 产品code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置产品code
     *
     * @param code 产品code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取波动价值
     *
     * @return volatility_price - 波动价值
     */
    public BigDecimal getVolatilityPrice() {
        return volatilityPrice;
    }

    /**
     * 设置波动价值
     *
     * @param volatilityPrice 波动价值
     */
    public void setVolatilityPrice(BigDecimal volatilityPrice) {
        this.volatilityPrice = volatilityPrice;
    }

    /**
     * 获取汇率
     *
     * @return exchangerate - 汇率
     */
    public BigDecimal getExchangerate() {
        return exchangerate;
    }

    /**
     * 设置汇率
     *
     * @param exchangerate 汇率
     */
    public void setExchangerate(BigDecimal exchangerate) {
        this.exchangerate = exchangerate;
    }

    /**
     * 获取单笔交易费用
     *
     * @return single_transaction_costs - 单笔交易费用
     */
    public BigDecimal getSingleTransactionCosts() {
        return singleTransactionCosts;
    }

    /**
     * 设置单笔交易费用
     *
     * @param singleTransactionCosts 单笔交易费用
     */
    public void setSingleTransactionCosts(BigDecimal singleTransactionCosts) {
        this.singleTransactionCosts = singleTransactionCosts;
    }

    /**
     * 获取单笔默认保证金
     *
     * @return single_default_margin - 单笔默认保证金
     */
    public BigDecimal getSingleDefaultMargin() {
        return singleDefaultMargin;
    }

    /**
     * 设置单笔默认保证金
     *
     * @param singleDefaultMargin 单笔默认保证金
     */
    public void setSingleDefaultMargin(BigDecimal singleDefaultMargin) {
        this.singleDefaultMargin = singleDefaultMargin;
    }

    /**
     * 获取默认点数
     *
     * @return default_points - 默认点数
     */
    public BigDecimal getDefaultPoints() {
        return defaultPoints;
    }

    /**
     * 设置默认点数
     *
     * @param defaultPoints 默认点数
     */
    public void setDefaultPoints(BigDecimal defaultPoints) {
        this.defaultPoints = defaultPoints;
    }

    private String token;
    private int userId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}