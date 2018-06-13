package com.bjst.dgt.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_stock_datas")
public class JStockDatas {
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
     * 最高
     */
    private BigDecimal high;

    /**
     * 最低
     */
    private BigDecimal low;

    /**
     * 开盘价
     */
    private BigDecimal open;

    /**
     * 昨收价
     */
    private BigDecimal close;

    /**
     * 成交量
     */
    private BigDecimal volume;

    /**
     * 成交额
     */
    private BigDecimal amount;

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

    @Column(name = "add_time")
    private Date addTime;

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
     * 获取最高
     *
     * @return high - 最高
     */
    public BigDecimal getHigh() {
        return high;
    }

    /**
     * 设置最高
     *
     * @param high 最高
     */
    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    /**
     * 获取最低
     *
     * @return low - 最低
     */
    public BigDecimal getLow() {
        return low;
    }

    /**
     * 设置最低
     *
     * @param low 最低
     */
    public void setLow(BigDecimal low) {
        this.low = low;
    }

    /**
     * 获取开盘价
     *
     * @return open - 开盘价
     */
    public BigDecimal getOpen() {
        return open;
    }

    /**
     * 设置开盘价
     *
     * @param open 开盘价
     */
    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    /**
     * 获取昨收价
     *
     * @return close - 昨收价
     */
    public BigDecimal getClose() {
        return close;
    }

    /**
     * 设置昨收价
     *
     * @param close 昨收价
     */
    public void setClose(BigDecimal close) {
        this.close = close;
    }

    /**
     * 获取成交量
     *
     * @return volume - 成交量
     */
    public BigDecimal getVolume() {
        return volume;
    }

    /**
     * 设置成交量
     *
     * @param volume 成交量
     */
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    /**
     * 获取成交额
     *
     * @return amount - 成交额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置成交额
     *
     * @param amount 成交额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
}