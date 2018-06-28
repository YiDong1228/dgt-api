package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "bank_card")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 银行id
     */
    @Column(name = "bank_id")
    private Integer bankId;

    /**
     * 银行图标地址
     */
    private String icon;

    /**
     * 持卡人姓名
     */
    private String name;

    /**
     * 银行卡号
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取银行id
     *
     * @return bank_id - 银行id
     */
    public Integer getBankId() {
        return bankId;
    }

    /**
     * 设置银行id
     *
     * @param bankId 银行id
     */
    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    /**
     * 获取银行图标地址
     *
     * @return icon - 银行图标地址
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置银行图标地址
     *
     * @param icon 银行图标地址
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取持卡人姓名
     *
     * @return name - 持卡人姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置持卡人姓名
     *
     * @param name 持卡人姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取银行卡号
     *
     * @return bank_account - 银行卡号
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行卡号
     *
     * @param bankAccount 银行卡号
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}