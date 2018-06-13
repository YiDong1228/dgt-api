package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "s_extension")
public class SExtension {
    /**
     * 推广级别id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 下线交易用户数量
     */
    @Column(name = "user_number")
    private String userNumber;

    /**
     * 交易提成佣金比例
     */
    @Column(name = "commission_rate")
    private Integer commissionRate;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 获取推广级别id
     *
     * @return id - 推广级别id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置推广级别id
     *
     * @param id 推广级别id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取下线交易用户数量
     *
     * @return user_number - 下线交易用户数量
     */
    public String getUserNumber() {
        return userNumber;
    }

    /**
     * 设置下线交易用户数量
     *
     * @param userNumber 下线交易用户数量
     */
    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    /**
     * 获取交易提成佣金比例
     *
     * @return commission_rate - 交易提成佣金比例
     */
    public Integer getCommissionRate() {
        return commissionRate;
    }

    /**
     * 设置交易提成佣金比例
     *
     * @param commissionRate 交易提成佣金比例
     */
    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
    }

    /**
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}