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

    @Column(name = "bankName")
    private String bankname;

    private String name;

    @Column(name = "bankAccount")
    private String bankaccount;

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
     * @return bankName
     */
    public String getBankname() {
        return bankname;
    }

    /**
     * @param bankname
     */
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return bankAccount
     */
    public String getBankaccount() {
        return bankaccount;
    }

    /**
     * @param bankaccount
     */
    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }
}