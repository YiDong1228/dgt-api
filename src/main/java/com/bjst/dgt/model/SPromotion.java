package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "s_promotion")
public class SPromotion {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 推广用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 被推广用户id
     */
    @Column(name = "promotion_id")
    private Integer promotionId;

    /**
     * 是否交易
     */
    private Integer transaction;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取推广用户id
     *
     * @return user_id - 推广用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置推广用户id
     *
     * @param userId 推广用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取被推广用户id
     *
     * @return promotion_id - 被推广用户id
     */
    public Integer getPromotionId() {
        return promotionId;
    }

    /**
     * 设置被推广用户id
     *
     * @param promotionId 被推广用户id
     */
    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * 获取是否交易
     *
     * @return transaction - 是否交易
     */
    public Integer getTransaction() {
        return transaction;
    }

    /**
     * 设置是否交易
     *
     * @param transaction 是否交易
     */
    public void setTransaction(Integer transaction) {
        this.transaction = transaction;
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