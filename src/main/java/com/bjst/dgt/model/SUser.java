package com.bjst.dgt.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_user")
public class SUser {
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

    @Column(name = "availableFund")
    private String availablefund;

    @Column(name = "marginFund")
    private String marginfund;

    @Column(name = "baseCurrency")
    private String basecurrency;

    @Column(name = "execRate")
    private String execrate;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 1:禁用，2:有效
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    @Column(name = "subAccountID")
    private String subaccountid;

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
     * @return availableFund
     */
    public String getAvailablefund() {
        return availablefund;
    }

    /**
     * @param availablefund
     */
    public void setAvailablefund(String availablefund) {
        this.availablefund = availablefund;
    }

    /**
     * @return marginFund
     */
    public String getMarginfund() {
        return marginfund;
    }

    /**
     * @param marginfund
     */
    public void setMarginfund(String marginfund) {
        this.marginfund = marginfund;
    }

    /**
     * @return baseCurrency
     */
    public String getBasecurrency() {
        return basecurrency;
    }

    /**
     * @param basecurrency
     */
    public void setBasecurrency(String basecurrency) {
        this.basecurrency = basecurrency;
    }

    /**
     * @return execRate
     */
    public String getExecrate() {
        return execrate;
    }

    /**
     * @param execrate
     */
    public void setExecrate(String execrate) {
        this.execrate = execrate;
    }

    /**
     * @return add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
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
     * @return subAccountID
     */
    public String getSubaccountid() {
        return subaccountid;
    }

    /**
     * @param subaccountid
     */
    public void setSubaccountid(String subaccountid) {
        this.subaccountid = subaccountid;
    }
}