package com.bjst.dgt.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 余额
     */
    private BigDecimal balance;

    @Column(name = "available_fund")
    private String availableFund;

    @Column(name = "margin_fund")
    private String marginFund;

    @Column(name = "base_currency")
    private String baseCurrency;

    @Column(name = "exec_rate")
    private String execRate;

    /**
     * 1:禁用，2:有效
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    /**
     * 内盘账号
     */
    @Column(name = "sub_account_id_inner")
    private String subAccountIdInner;

    /**
     * 外盘账号
     */
    @Column(name = "sub_account_id_outer")
    private String subAccountIdOuter;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取余额
     *
     * @return balance - 余额
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 设置余额
     *
     * @param balance 余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return available_fund
     */
    public String getAvailableFund() {
        return availableFund;
    }

    /**
     * @param availableFund
     */
    public void setAvailableFund(String availableFund) {
        this.availableFund = availableFund;
    }

    /**
     * @return margin_fund
     */
    public String getMarginFund() {
        return marginFund;
    }

    /**
     * @param marginFund
     */
    public void setMarginFund(String marginFund) {
        this.marginFund = marginFund;
    }

    /**
     * @return base_currency
     */
    public String getBaseCurrency() {
        return baseCurrency;
    }

    /**
     * @param baseCurrency
     */
    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    /**
     * @return exec_rate
     */
    public String getExecRate() {
        return execRate;
    }

    /**
     * @param execRate
     */
    public void setExecRate(String execRate) {
        this.execRate = execRate;
    }

    /**
     * 获取1:禁用，2:有效
     *
     * @return data_status - 1:禁用，2:有效
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置1:禁用，2:有效
     *
     * @param dataStatus 1:禁用，2:有效
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * 获取内盘账号
     *
     * @return sub_account_id_inner - 内盘账号
     */
    public String getSubAccountIdInner() {
        return subAccountIdInner;
    }

    /**
     * 设置内盘账号
     *
     * @param subAccountIdInner 内盘账号
     */
    public void setSubAccountIdInner(String subAccountIdInner) {
        this.subAccountIdInner = subAccountIdInner;
    }

    /**
     * 获取外盘账号
     *
     * @return sub_account_id_outer - 外盘账号
     */
    public String getSubAccountIdOuter() {
        return subAccountIdOuter;
    }

    /**
     * 设置外盘账号
     *
     * @param subAccountIdOuter 外盘账号
     */
    public void setSubAccountIdOuter(String subAccountIdOuter) {
        this.subAccountIdOuter = subAccountIdOuter;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    private String sms;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}