package com.bjst.dgt.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_user_balance_log")
public class SUserBalanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 1:充值
     */
    @Column(name = "data_type")
    private Byte dataType;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 充值金额
     */
    private BigDecimal money;

    /**
     * 2：正常,256：失败
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    @Column(name = "add_time")
    private Date addTime;

    /**
     * 描述
     */
    @Column(name = "data_desc")
    private String dataDesc;

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
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取1:充值
     *
     * @return data_type - 1:充值
     */
    public Byte getDataType() {
        return dataType;
    }

    /**
     * 设置1:充值
     *
     * @param dataType 1:充值
     */
    public void setDataType(Byte dataType) {
        this.dataType = dataType;
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
     * 获取充值金额
     *
     * @return money - 充值金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置充值金额
     *
     * @param money 充值金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取2：正常,256：失败
     *
     * @return data_status - 2：正常,256：失败
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置2：正常,256：失败
     *
     * @param dataStatus 2：正常,256：失败
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
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
     * 获取描述
     *
     * @return data_desc - 描述
     */
    public String getDataDesc() {
        return dataDesc;
    }

    /**
     * 设置描述
     *
     * @param dataDesc 描述
     */
    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }
}