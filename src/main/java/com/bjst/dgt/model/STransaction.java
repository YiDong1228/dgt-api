package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "s_transaction")
public class STransaction {
    /**
     * 交易id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 开仓价
     */
    @Column(name = "open_price")
    private String openPrice;

    /**
     * 交易数量
     */
    @Column(name = "transaction_number")
    private Integer transactionNumber;

    /**
     * 止盈点数
     */
    @Column(name = "target_profit_number")
    private String targetProfitNumber;

    /**
     * 止盈金额
     */
    @Column(name = "target_profit_money")
    private String targetProfitMoney;

    /**
     * 止损点数
     */
    @Column(name = "stop_loss_number")
    private String stopLossNumber;

    /**
     * 止损金额
     */
    @Column(name = "stop_loss_money")
    private String stopLossMoney;

    /**
     * 是否触发止盈
     */
    @Column(name = "target_profit")
    private String targetProfit;

    /**
     * 是否触发移动保本
     */
    @Column(name = "mobile_insurance")
    private String mobileInsurance;

    /**
     * 移动点数
     */
    @Column(name = "movement_point_number")
    private String movementPointNumber;

    /**
     * 保本点数
     */
    @Column(name = "mobile_insurance_number")
    private String mobileInsuranceNumber;

    /**
     * 交易费用
     */
    @Column(name = "transaction_cost")
    private String transactionCost;

    /**
     * 保证金
     */
    private String bond;

    /**
     * 合计
     */
    private String total;

    /**
     * 获取交易id
     *
     * @return id - 交易id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置交易id
     *
     * @param id 交易id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取开仓价
     *
     * @return open_price - 开仓价
     */
    public String getOpenPrice() {
        return openPrice;
    }

    /**
     * 设置开仓价
     *
     * @param openPrice 开仓价
     */
    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    /**
     * 获取交易数量
     *
     * @return transaction_number - 交易数量
     */
    public Integer getTransactionNumber() {
        return transactionNumber;
    }

    /**
     * 设置交易数量
     *
     * @param transactionNumber 交易数量
     */
    public void setTransactionNumber(Integer transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    /**
     * 获取止盈点数
     *
     * @return target_profit_number - 止盈点数
     */
    public String getTargetProfitNumber() {
        return targetProfitNumber;
    }

    /**
     * 设置止盈点数
     *
     * @param targetProfitNumber 止盈点数
     */
    public void setTargetProfitNumber(String targetProfitNumber) {
        this.targetProfitNumber = targetProfitNumber;
    }

    /**
     * 获取止盈金额
     *
     * @return target_profit_money - 止盈金额
     */
    public String getTargetProfitMoney() {
        return targetProfitMoney;
    }

    /**
     * 设置止盈金额
     *
     * @param targetProfitMoney 止盈金额
     */
    public void setTargetProfitMoney(String targetProfitMoney) {
        this.targetProfitMoney = targetProfitMoney;
    }

    /**
     * 获取止损点数
     *
     * @return stop_loss_number - 止损点数
     */
    public String getStopLossNumber() {
        return stopLossNumber;
    }

    /**
     * 设置止损点数
     *
     * @param stopLossNumber 止损点数
     */
    public void setStopLossNumber(String stopLossNumber) {
        this.stopLossNumber = stopLossNumber;
    }

    /**
     * 获取止损金额
     *
     * @return stop_loss_money - 止损金额
     */
    public String getStopLossMoney() {
        return stopLossMoney;
    }

    /**
     * 设置止损金额
     *
     * @param stopLossMoney 止损金额
     */
    public void setStopLossMoney(String stopLossMoney) {
        this.stopLossMoney = stopLossMoney;
    }

    /**
     * 获取是否触发止盈
     *
     * @return target_profit - 是否触发止盈
     */
    public String getTargetProfit() {
        return targetProfit;
    }

    /**
     * 设置是否触发止盈
     *
     * @param targetProfit 是否触发止盈
     */
    public void setTargetProfit(String targetProfit) {
        this.targetProfit = targetProfit;
    }

    /**
     * 获取是否触发移动保本
     *
     * @return mobile_insurance - 是否触发移动保本
     */
    public String getMobileInsurance() {
        return mobileInsurance;
    }

    /**
     * 设置是否触发移动保本
     *
     * @param mobileInsurance 是否触发移动保本
     */
    public void setMobileInsurance(String mobileInsurance) {
        this.mobileInsurance = mobileInsurance;
    }

    /**
     * 获取移动点数
     *
     * @return movement_point_number - 移动点数
     */
    public String getMovementPointNumber() {
        return movementPointNumber;
    }

    /**
     * 设置移动点数
     *
     * @param movementPointNumber 移动点数
     */
    public void setMovementPointNumber(String movementPointNumber) {
        this.movementPointNumber = movementPointNumber;
    }

    /**
     * 获取保本点数
     *
     * @return mobile_insurance_number - 保本点数
     */
    public String getMobileInsuranceNumber() {
        return mobileInsuranceNumber;
    }

    /**
     * 设置保本点数
     *
     * @param mobileInsuranceNumber 保本点数
     */
    public void setMobileInsuranceNumber(String mobileInsuranceNumber) {
        this.mobileInsuranceNumber = mobileInsuranceNumber;
    }

    /**
     * 获取交易费用
     *
     * @return transaction_cost - 交易费用
     */
    public String getTransactionCost() {
        return transactionCost;
    }

    /**
     * 设置交易费用
     *
     * @param transactionCost 交易费用
     */
    public void setTransactionCost(String transactionCost) {
        this.transactionCost = transactionCost;
    }

    /**
     * 获取保证金
     *
     * @return bond - 保证金
     */
    public String getBond() {
        return bond;
    }

    /**
     * 设置保证金
     *
     * @param bond 保证金
     */
    public void setBond(String bond) {
        this.bond = bond;
    }

    /**
     * 获取合计
     *
     * @return total - 合计
     */
    public String getTotal() {
        return total;
    }

    /**
     * 设置合计
     *
     * @param total 合计
     */
    public void setTotal(String total) {
        this.total = total;
    }
}