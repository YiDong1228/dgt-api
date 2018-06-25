package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

public class Trade {
    /**
     * 交易id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 总计
     */
    private Float aggregate;

    /**
     * 保本点数
     */
    @Column(name = "break_even_num")
    private Short breakEvenNum;

    /**
     * 组合开平标志（0:开仓、1:平仓）
     */
    @Column(name = "comb_offset_flag")
    private Byte combOffsetFlag;

    /**
     * 手续费
     */
    private Float commission;

    /**
     * 保证金
     */
    private Float deposit;

    /**
     * 买卖方向（0:买、1:卖）
     */
    private Byte direction;

    /**
     * 内外盘标志(0:内盘、1:外盘)
     */
    @Column(name = "inner_outer_disc")
    private Byte innerOuterDisc;

    /**
     * 合约代码
     */
    @Column(name = "instrument_id")
    private String instrumentId;

    /**
     * 是否移动保本（0:否、1:是）
     */
    @Column(name = "is_move_break_even")
    private Byte isMoveBreakEven;

    /**
     * 是否开启止盈（0:否、1:是）
     */
    @Column(name = "is_profit")
    private Byte isProfit;

    /**
     * 是否开启止损（0:否、1:是）
     */
    @Column(name = "is_stop")
    private Byte isStop;

    /**
     * 委托价格
     */
    @Column(name = "limit_price")
    private Float limitPrice;

    /**
     * 移动点数
     */
    @Column(name = "move_num")
    private Integer moveNum;

    /**
     * 止盈点数
     */
    @Column(name = "profit_num")
    private Integer profitNum;

    /**
     * 止盈价格
     */
    @Column(name = "profit_price")
    private Float profitPrice;

    /**
     * 止损点数
     */
    @Column(name = "stop_num")
    private Integer stopNum;

    /**
     * 止损价
     */
    @Column(name = "stop_price")
    private Float stopPrice;

    /**
     * 下单数量
     */
    @Column(name = "volume_total_original")
    private Integer volumeTotalOriginal;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 报单编号,api返回交易系统中id
     */
    @Column(name = "order_sys_id")
    private String orderSysId;

    /**
     * 交易状态（0:未成交，1:成交，2: 部分成交)
     */
    @Column(name = "trade_status")
    private Byte tradeStatus;

    /**
     * 实际成交价格
     */
    @Column(name = "transaction_price")
    private Float transactionPrice;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 交易所代码
     */
    @Column(name = "exchange_id")
    private String exchangeId;

    /**
     * 买方向没有成交数量（只有部分成交时候）
     */
    @Column(name = "buy_remaining_volume")
    private Integer buyRemainingVolume;

    /**
     * 卖方向没有成交数量（只有部分成交时候）
     */
    @Column(name = "sell_remaining_volume")
    private Integer sellRemainingVolume;

    /**
     * 获取交易id
     *
     * @return id - 交易id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置交易id
     *
     * @param id 交易id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取总计
     *
     * @return aggregate - 总计
     */
    public Float getAggregate() {
        return aggregate;
    }

    /**
     * 设置总计
     *
     * @param aggregate 总计
     */
    public void setAggregate(Float aggregate) {
        this.aggregate = aggregate;
    }

    /**
     * 获取保本点数
     *
     * @return break_even_num - 保本点数
     */
    public Short getBreakEvenNum() {
        return breakEvenNum;
    }

    /**
     * 设置保本点数
     *
     * @param breakEvenNum 保本点数
     */
    public void setBreakEvenNum(Short breakEvenNum) {
        this.breakEvenNum = breakEvenNum;
    }

    /**
     * 获取组合开平标志（0:开仓、1:平仓）
     *
     * @return comb_offset_flag - 组合开平标志（0:开仓、1:平仓）
     */
    public Byte getCombOffsetFlag() {
        return combOffsetFlag;
    }

    /**
     * 设置组合开平标志（0:开仓、1:平仓）
     *
     * @param combOffsetFlag 组合开平标志（0:开仓、1:平仓）
     */
    public void setCombOffsetFlag(Byte combOffsetFlag) {
        this.combOffsetFlag = combOffsetFlag;
    }

    /**
     * 获取手续费
     *
     * @return commission - 手续费
     */
    public Float getCommission() {
        return commission;
    }

    /**
     * 设置手续费
     *
     * @param commission 手续费
     */
    public void setCommission(Float commission) {
        this.commission = commission;
    }

    /**
     * 获取保证金
     *
     * @return deposit - 保证金
     */
    public Float getDeposit() {
        return deposit;
    }

    /**
     * 设置保证金
     *
     * @param deposit 保证金
     */
    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    /**
     * 获取买卖方向（0:买、1:卖）
     *
     * @return direction - 买卖方向（0:买、1:卖）
     */
    public Byte getDirection() {
        return direction;
    }

    /**
     * 设置买卖方向（0:买、1:卖）
     *
     * @param direction 买卖方向（0:买、1:卖）
     */
    public void setDirection(Byte direction) {
        this.direction = direction;
    }

    /**
     * 获取内外盘标志(0:内盘、1:外盘)
     *
     * @return inner_outer_disc - 内外盘标志(0:内盘、1:外盘)
     */
    public Byte getInnerOuterDisc() {
        return innerOuterDisc;
    }

    /**
     * 设置内外盘标志(0:内盘、1:外盘)
     *
     * @param innerOuterDisc 内外盘标志(0:内盘、1:外盘)
     */
    public void setInnerOuterDisc(Byte innerOuterDisc) {
        this.innerOuterDisc = innerOuterDisc;
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
     * 获取是否移动保本（0:否、1:是）
     *
     * @return is_move_break_even - 是否移动保本（0:否、1:是）
     */
    public Byte getIsMoveBreakEven() {
        return isMoveBreakEven;
    }

    /**
     * 设置是否移动保本（0:否、1:是）
     *
     * @param isMoveBreakEven 是否移动保本（0:否、1:是）
     */
    public void setIsMoveBreakEven(Byte isMoveBreakEven) {
        this.isMoveBreakEven = isMoveBreakEven;
    }

    /**
     * 获取是否开启止盈（0:否、1:是）
     *
     * @return is_profit - 是否开启止盈（0:否、1:是）
     */
    public Byte getIsProfit() {
        return isProfit;
    }

    /**
     * 设置是否开启止盈（0:否、1:是）
     *
     * @param isProfit 是否开启止盈（0:否、1:是）
     */
    public void setIsProfit(Byte isProfit) {
        this.isProfit = isProfit;
    }

    /**
     * 获取是否开启止损（0:否、1:是）
     *
     * @return is_stop - 是否开启止损（0:否、1:是）
     */
    public Byte getIsStop() {
        return isStop;
    }

    /**
     * 设置是否开启止损（0:否、1:是）
     *
     * @param isStop 是否开启止损（0:否、1:是）
     */
    public void setIsStop(Byte isStop) {
        this.isStop = isStop;
    }

    /**
     * 获取委托价格
     *
     * @return limit_price - 委托价格
     */
    public Float getLimitPrice() {
        return limitPrice;
    }

    /**
     * 设置委托价格
     *
     * @param limitPrice 委托价格
     */
    public void setLimitPrice(Float limitPrice) {
        this.limitPrice = limitPrice;
    }

    /**
     * 获取移动点数
     *
     * @return move_num - 移动点数
     */
    public Integer getMoveNum() {
        return moveNum;
    }

    /**
     * 设置移动点数
     *
     * @param moveNum 移动点数
     */
    public void setMoveNum(Integer moveNum) {
        this.moveNum = moveNum;
    }

    /**
     * 获取止盈点数
     *
     * @return profit_num - 止盈点数
     */
    public Integer getProfitNum() {
        return profitNum;
    }

    /**
     * 设置止盈点数
     *
     * @param profitNum 止盈点数
     */
    public void setProfitNum(Integer profitNum) {
        this.profitNum = profitNum;
    }

    /**
     * 获取止盈价格
     *
     * @return profit_price - 止盈价格
     */
    public Float getProfitPrice() {
        return profitPrice;
    }

    /**
     * 设置止盈价格
     *
     * @param profitPrice 止盈价格
     */
    public void setProfitPrice(Float profitPrice) {
        this.profitPrice = profitPrice;
    }

    /**
     * 获取止损点数
     *
     * @return stop_num - 止损点数
     */
    public Integer getStopNum() {
        return stopNum;
    }

    /**
     * 设置止损点数
     *
     * @param stopNum 止损点数
     */
    public void setStopNum(Integer stopNum) {
        this.stopNum = stopNum;
    }

    /**
     * 获取止损价
     *
     * @return stop_price - 止损价
     */
    public Float getStopPrice() {
        return stopPrice;
    }

    /**
     * 设置止损价
     *
     * @param stopPrice 止损价
     */
    public void setStopPrice(Float stopPrice) {
        this.stopPrice = stopPrice;
    }

    /**
     * 获取下单数量
     *
     * @return volume_total_original - 下单数量
     */
    public Integer getVolumeTotalOriginal() {
        return volumeTotalOriginal;
    }

    /**
     * 设置下单数量
     *
     * @param volumeTotalOriginal 下单数量
     */
    public void setVolumeTotalOriginal(Integer volumeTotalOriginal) {
        this.volumeTotalOriginal = volumeTotalOriginal;
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

    /**
     * 获取报单编号,api返回交易系统中id
     *
     * @return order_sys_id - 报单编号,api返回交易系统中id
     */
    public String getOrderSysId() {
        return orderSysId;
    }

    /**
     * 设置报单编号,api返回交易系统中id
     *
     * @param orderSysId 报单编号,api返回交易系统中id
     */
    public void setOrderSysId(String orderSysId) {
        this.orderSysId = orderSysId;
    }

    /**
     * 获取交易状态（0:未成交，1:成交，2: 部分成交)
     *
     * @return trade_status - 交易状态（0:未成交，1:成交，2: 部分成交)
     */
    public Byte getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 设置交易状态（0:未成交，1:成交，2: 部分成交)
     *
     * @param tradeStatus 交易状态（0:未成交，1:成交，2: 部分成交)
     */
    public void setTradeStatus(Byte tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * 获取实际成交价格
     *
     * @return transaction_price - 实际成交价格
     */
    public Float getTransactionPrice() {
        return transactionPrice;
    }

    /**
     * 设置实际成交价格
     *
     * @param transactionPrice 实际成交价格
     */
    public void setTransactionPrice(Float transactionPrice) {
        this.transactionPrice = transactionPrice;
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
     * 获取交易所代码
     *
     * @return exchange_id - 交易所代码
     */
    public String getExchangeId() {
        return exchangeId;
    }

    /**
     * 设置交易所代码
     *
     * @param exchangeId 交易所代码
     */
    public void setExchangeId(String exchangeId) {
        this.exchangeId = exchangeId;
    }

    /**
     * 获取买方向没有成交数量（只有部分成交时候）
     *
     * @return buy_remaining_volume - 买方向没有成交数量（只有部分成交时候）
     */
    public Integer getBuyRemainingVolume() {
        return buyRemainingVolume;
    }

    /**
     * 设置买方向没有成交数量（只有部分成交时候）
     *
     * @param buyRemainingVolume 买方向没有成交数量（只有部分成交时候）
     */
    public void setBuyRemainingVolume(Integer buyRemainingVolume) {
        this.buyRemainingVolume = buyRemainingVolume;
    }

    /**
     * 获取卖方向没有成交数量（只有部分成交时候）
     *
     * @return sell_remaining_volume - 卖方向没有成交数量（只有部分成交时候）
     */
    public Integer getSellRemainingVolume() {
        return sellRemainingVolume;
    }

    /**
     * 设置卖方向没有成交数量（只有部分成交时候）
     *
     * @param sellRemainingVolume 卖方向没有成交数量（只有部分成交时候）
     */
    public void setSellRemainingVolume(Integer sellRemainingVolume) {
        this.sellRemainingVolume = sellRemainingVolume;
    }
}