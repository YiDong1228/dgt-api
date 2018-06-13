package com.bjst.dgt.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "s_remind")
public class SRemind {
    /**
     * 预警id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品CODE
     */
    private String code;

    /**
     * 最新价格
     */
    @Column(name = "last_price")
    private BigDecimal lastPrice;

    /**
     * 涨幅
     */
    @Column(name = "change_count")
    private BigDecimal changeCount;

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
     * 提醒次数
     */
    private Integer number;

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
     * 获取最新价格
     *
     * @return last_price - 最新价格
     */
    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    /**
     * 设置最新价格
     *
     * @param lastPrice 最新价格
     */
    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * 获取涨幅
     *
     * @return change_count - 涨幅
     */
    public BigDecimal getChangeCount() {
        return changeCount;
    }

    /**
     * 设置涨幅
     *
     * @param changeCount 涨幅
     */
    public void setChangeCount(BigDecimal changeCount) {
        this.changeCount = changeCount;
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
     * 获取提醒次数
     *
     * @return number - 提醒次数
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置提醒次数
     *
     * @param number 提醒次数
     */
    public void setNumber(Integer number) {
        this.number = number;
    }
}