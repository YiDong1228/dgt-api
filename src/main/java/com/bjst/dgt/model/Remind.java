package com.bjst.dgt.model;

import java.math.BigDecimal;
import javax.persistence.*;

public class Remind {
    /**
     * 预警id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品CODE
     */
    private String code;

    /**
     * 价格涨到
     */
    @Column(name = "max_price")
    private BigDecimal maxPrice;

    /**
     * 价格跌到
     */
    @Column(name = "min_price")
    private BigDecimal minPrice;

    /**
     * 涨幅超过
     */
    @Column(name = "max_count")
    private BigDecimal maxCount;

    /**
     * 跌幅超过
     */
    @Column(name = "min_count")
    private BigDecimal minCount;

    /**
     * 提醒策略1：一次，2：每日提醒
     */
    private Byte remind;

    /**
     * 获取预警id
     *
     * @return id - 预警id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置预警id
     *
     * @param id 预警id
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
     * 获取价格涨到
     *
     * @return max_price - 价格涨到
     */
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    /**
     * 设置价格涨到
     *
     * @param maxPrice 价格涨到
     */
    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * 获取价格跌到
     *
     * @return min_price - 价格跌到
     */
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    /**
     * 设置价格跌到
     *
     * @param minPrice 价格跌到
     */
    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * 获取涨幅超过
     *
     * @return max_count - 涨幅超过
     */
    public BigDecimal getMaxCount() {
        return maxCount;
    }

    /**
     * 设置涨幅超过
     *
     * @param maxCount 涨幅超过
     */
    public void setMaxCount(BigDecimal maxCount) {
        this.maxCount = maxCount;
    }

    /**
     * 获取跌幅超过
     *
     * @return min_count - 跌幅超过
     */
    public BigDecimal getMinCount() {
        return minCount;
    }

    /**
     * 设置跌幅超过
     *
     * @param minCount 跌幅超过
     */
    public void setMinCount(BigDecimal minCount) {
        this.minCount = minCount;
    }

    /**
     * 获取提醒策略1：一次，2：每日提醒
     *
     * @return remind - 提醒策略1：一次，2：每日提醒
     */
    public Byte getRemind() {
        return remind;
    }

    /**
     * 设置提醒策略1：一次，2：每日提醒
     *
     * @param remind 提醒策略1：一次，2：每日提醒
     */
    public void setRemind(Byte remind) {
        this.remind = remind;
    }
}