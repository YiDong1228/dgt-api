package com.bjst.dgt.model;

import javax.persistence.*;

public class Rule {
    /**
     * 产品CODE
     */
    @Id
    private String code;

    @Column(name = "is_domestic")
    private String isDomestic;

    /**
     * 货币单位
     */
    private String monetaryunit;

    /**
     * 交易单位
     */
    private String tradingunit;

    /**
     * 交易所
     */
    private String exchange;

    /**
     * 最小波动
     */
    private String minimumfluctuation;

    /**
     * 波动盈亏
     */
    private String fluctuatingprofitandloss;

    /**
     * 履约保证金
     */
    private String performancebond;

    /**
     * 交易时间
     */
    private String tradingtime;

    /**
     * 清仓时间
     */
    private String clearingtime;

    /**
     * 交易综合费
     */
    private String comprehensivefee;

    /**
     * 汇率
     */
    private String exchangerate;

    /**
     * 交易开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 交易结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    @Column(name = "start_time_1")
    private String startTime1;

    @Column(name = "end_time_1")
    private String endTime1;

    /**
     * 获取产品CODE
     *
     * @return code - 产品CODE
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置产品CODE
     *
     * @param code 产品CODE
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return is_domestic
     */
    public String getIsDomestic() {
        return isDomestic;
    }

    /**
     * @param isDomestic
     */
    public void setIsDomestic(String isDomestic) {
        this.isDomestic = isDomestic;
    }

    /**
     * 获取货币单位
     *
     * @return monetaryunit - 货币单位
     */
    public String getMonetaryunit() {
        return monetaryunit;
    }

    /**
     * 设置货币单位
     *
     * @param monetaryunit 货币单位
     */
    public void setMonetaryunit(String monetaryunit) {
        this.monetaryunit = monetaryunit;
    }

    /**
     * 获取交易单位
     *
     * @return tradingunit - 交易单位
     */
    public String getTradingunit() {
        return tradingunit;
    }

    /**
     * 设置交易单位
     *
     * @param tradingunit 交易单位
     */
    public void setTradingunit(String tradingunit) {
        this.tradingunit = tradingunit;
    }

    /**
     * 获取交易所
     *
     * @return exchange - 交易所
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * 设置交易所
     *
     * @param exchange 交易所
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * 获取最小波动
     *
     * @return minimumfluctuation - 最小波动
     */
    public String getMinimumfluctuation() {
        return minimumfluctuation;
    }

    /**
     * 设置最小波动
     *
     * @param minimumfluctuation 最小波动
     */
    public void setMinimumfluctuation(String minimumfluctuation) {
        this.minimumfluctuation = minimumfluctuation;
    }

    /**
     * 获取波动盈亏
     *
     * @return fluctuatingprofitandloss - 波动盈亏
     */
    public String getFluctuatingprofitandloss() {
        return fluctuatingprofitandloss;
    }

    /**
     * 设置波动盈亏
     *
     * @param fluctuatingprofitandloss 波动盈亏
     */
    public void setFluctuatingprofitandloss(String fluctuatingprofitandloss) {
        this.fluctuatingprofitandloss = fluctuatingprofitandloss;
    }

    /**
     * 获取履约保证金
     *
     * @return performancebond - 履约保证金
     */
    public String getPerformancebond() {
        return performancebond;
    }

    /**
     * 设置履约保证金
     *
     * @param performancebond 履约保证金
     */
    public void setPerformancebond(String performancebond) {
        this.performancebond = performancebond;
    }

    /**
     * 获取交易时间
     *
     * @return tradingtime - 交易时间
     */
    public String getTradingtime() {
        return tradingtime;
    }

    /**
     * 设置交易时间
     *
     * @param tradingtime 交易时间
     */
    public void setTradingtime(String tradingtime) {
        this.tradingtime = tradingtime;
    }

    /**
     * 获取清仓时间
     *
     * @return clearingtime - 清仓时间
     */
    public String getClearingtime() {
        return clearingtime;
    }

    /**
     * 设置清仓时间
     *
     * @param clearingtime 清仓时间
     */
    public void setClearingtime(String clearingtime) {
        this.clearingtime = clearingtime;
    }

    /**
     * 获取交易综合费
     *
     * @return comprehensivefee - 交易综合费
     */
    public String getComprehensivefee() {
        return comprehensivefee;
    }

    /**
     * 设置交易综合费
     *
     * @param comprehensivefee 交易综合费
     */
    public void setComprehensivefee(String comprehensivefee) {
        this.comprehensivefee = comprehensivefee;
    }

    /**
     * 获取汇率
     *
     * @return exchangerate - 汇率
     */
    public String getExchangerate() {
        return exchangerate;
    }

    /**
     * 设置汇率
     *
     * @param exchangerate 汇率
     */
    public void setExchangerate(String exchangerate) {
        this.exchangerate = exchangerate;
    }

    /**
     * 获取交易开始时间
     *
     * @return start_time - 交易开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置交易开始时间
     *
     * @param startTime 交易开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取交易结束时间
     *
     * @return end_time - 交易结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置交易结束时间
     *
     * @param endTime 交易结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * @return start_time_1
     */
    public String getStartTime1() {
        return startTime1;
    }

    /**
     * @param startTime1
     */
    public void setStartTime1(String startTime1) {
        this.startTime1 = startTime1;
    }

    /**
     * @return end_time_1
     */
    public String getEndTime1() {
        return endTime1;
    }

    /**
     * @param endTime1
     */
    public void setEndTime1(String endTime1) {
        this.endTime1 = endTime1;
    }

    /**
     * 交易状态	例如：交易中（交易时间18:00-次日17:00）
     */
    private String tradeStatus;

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * 交易窗口用于显示说明1
     */
    private String shuoming1;

    /**
     * 交易窗口用于显示说明2
     */
    private String shuoming2;

    @Column(name = "shuoming1_moon")
    private String shuoming1Moon;

    public String getShuoming1Moon() {
        return shuoming1Moon;
    }

    public void setShuoming1Moon(String shuoming1Moon) {
        this.shuoming1Moon = shuoming1Moon;
    }

    public String getShuoming1() {
        return shuoming1;
    }

    public void setShuoming1(String shuoming1) {
        this.shuoming1 = shuoming1;
    }

    public String getShuoming2() {
        return shuoming2;
    }

    public void setShuoming2(String shuoming2) {
        this.shuoming2 = shuoming2;
    }

    private int userId;

    public int getUserId(int i) {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}