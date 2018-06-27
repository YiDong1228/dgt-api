package com.bjst.dgt.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "investor_position_detail")
public class InvestorPositionDetail {
    /**
     * 标识
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 合约代码
     */
    @Column(name = "instrument_id")
    private String instrumentId;

    /**
     * 买卖方向
     */
    private Byte direction;

    /**
     * 开仓日期
     */
    @Column(name = "open_date")
    private Date openDate;

    /**
     * 成交编号
     */
    @Column(name = "trade_id")
    private String tradeId;

    /**
     * 数量
     */
    private Integer volume;

    /**
     * 开仓价
     */
    @Column(name = "open_price")
    private Double openPrice;

    /**
     * 结算编号
     */
    @Column(name = "settlement_id")
    private Integer settlementId;

    /**
     * 组合合约代码 
     */
    @Column(name = "combInstrument_id")
    private String combinstrumentId;

    /**
     * 创建时间
     */
    @Column(name = "create_time",insertable = false, updatable = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time",insertable = false, updatable = false)
    private Date updateTime;

    /**
     * 获取标识
     *
     * @return id - 标识
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置标识
     *
     * @param id 标识
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取合约代码
     *
     * @return instrument_id - 合约代码
     */
    public String getInstrumentId() {
        return instrumentId;
    }

    /**
     * 设置合约代码
     *
     * @param instrumentId 合约代码
     */
    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId;
    }

    /**
     * 获取买卖方向
     *
     * @return direction - 买卖方向
     */
    public Byte getDirection() {
        return direction;
    }

    /**
     * 设置买卖方向
     *
     * @param direction 买卖方向
     */
    public void setDirection(Byte direction) {
        this.direction = direction;
    }

    /**
     * 获取开仓日期
     *
     * @return open_date - 开仓日期
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * 设置开仓日期
     *
     * @param openDate 开仓日期
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * 获取成交编号
     *
     * @return trade_id - 成交编号
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * 设置成交编号
     *
     * @param tradeId 成交编号
     */
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * 获取数量
     *
     * @return volume - 数量
     */
    public Integer getVolume() {
        return volume;
    }

    /**
     * 设置数量
     *
     * @param volume 数量
     */
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     * 获取开仓价
     *
     * @return open_price - 开仓价
     */
    public Double getOpenPrice() {
        return openPrice;
    }

    /**
     * 设置开仓价
     *
     * @param openPrice 开仓价
     */
    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    /**
     * 获取结算编号
     *
     * @return settlement_id - 结算编号
     */
    public Integer getSettlementId() {
        return settlementId;
    }

    /**
     * 设置结算编号
     *
     * @param settlementId 结算编号
     */
    public void setSettlementId(Integer settlementId) {
        this.settlementId = settlementId;
    }

    /**
     * 获取组合合约代码 
     *
     * @return combInstrument_id - 组合合约代码 
     */
    public String getCombinstrumentId() {
        return combinstrumentId;
    }

    /**
     * 设置组合合约代码 
     *
     * @param combinstrumentId 组合合约代码 
     */
    public void setCombinstrumentId(String combinstrumentId) {
        this.combinstrumentId = combinstrumentId;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}