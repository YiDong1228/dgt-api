package com.bjst.dgt.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_product")
public class SProduct {
    /**
     * 产品CODE
     */
    @Id
    private String code;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 交易所
     */
    private String exchange;

    @Column(name = "last_price")
    private BigDecimal lastPrice;

    private String market;

    /**
     * 0：国内，1：内外
     */
    @Column(name = "is_domestic")
    private Byte isDomestic;

    /**
     * 1:禁用，2:有效
     */
    @Column(name = "data_status")
    private Byte dataStatus;

    /**
     * 涨幅
     */
    @Column(name = "change_count")
    private BigDecimal changeCount;

    @Column(name = "change_time")
    private Date changeTime;

    /**
     * 产品类型
     */
    @Column(name = "categroy_code")
    private String categroyCode;

    @Column(name = "add_time")
    private Date addTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取产品名称
     *
     * @return name - 产品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置产品名称
     *
     * @param name 产品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取交易所
     *
     * @return exchange - 交易所
     */
    public String getExchange() {
        return exchange;
    }

    /**
     * 设置交易所
     *
     * @param exchange 交易所
     */
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    /**
     * @return last_price
     */
    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    /**
     * @param lastPrice
     */
    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    /**
     * @return market
     */
    public String getMarket() {
        return market;
    }

    /**
     * @param market
     */
    public void setMarket(String market) {
        this.market = market;
    }

    /**
     * 获取0：国内，1：内外
     *
     * @return is_domestic - 0：国内，1：内外
     */
    public Byte getIsDomestic() {
        return isDomestic;
    }

    /**
     * 设置0：国内，1：内外
     *
     * @param isDomestic 0：国内，1：内外
     */
    public void setIsDomestic(Byte isDomestic) {
        this.isDomestic = isDomestic;
    }

    /**
     * 获取1:禁用，2:有效
     *
     * @return data_status - 1:禁用，2:有效
     */
    public Byte getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置1:禁用，2:有效
     *
     * @param dataStatus 1:禁用，2:有效
     */
    public void setDataStatus(Byte dataStatus) {
        this.dataStatus = dataStatus;
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
     * @return change_time
     */
    public Date getChangeTime() {
        return changeTime;
    }

    /**
     * @param changeTime
     */
    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }

    /**
     * 获取产品类型
     *
     * @return categroy_code - 产品类型
     */
    public String getCategroyCode() {
        return categroyCode;
    }

    /**
     * 设置产品类型
     *
     * @param categroyCode 产品类型
     */
    public void setCategroyCode(String categroyCode) {
        this.categroyCode = categroyCode;
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
}