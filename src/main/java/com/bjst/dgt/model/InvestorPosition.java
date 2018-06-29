package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "investor_position")
public class InvestorPosition {
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
     * 净：'1',多头：'2',空头：‘3’
     */
    @Column(name = "posi_direction")
    private Byte posiDirection;

    /**
     * 投机
： '1'
，套利： '2'，套保
： '3'
，做市商：
 '5'
     */
    @Column(name = "hedge_flag")
    private Byte hedgeFlag;

    /**
     * 今日持仓
：'1'，
历史持仓
： '2'
     */
    @Column(name = "position_date")
    private Byte positionDate;

    /**
     * 上日持仓
     */
    @Column(name = "yd_position")
    private Integer ydPosition;

    /**
     * 今日持仓
     */
    private Integer position;

    /**
     * 多头冻结
     */
    @Column(name = "long_frozen")
    private Integer longFrozen;

    /**
     * 空头冻结
     */
    @Column(name = "short_frozen")
    private Integer shortFrozen;

    /**
     * 多头冻结金额
     */
    @Column(name = "long_frozen_amount")
    private Double longFrozenAmount;

    /**
     * 空头冻结金额
     */
    @Column(name = "short_frozen_amount")
    private Double shortFrozenAmount;

    /**
     * 开仓量
     */
    @Column(name = "open_volume")
    private Integer openVolume;

    /**
     * 平仓量
     */
    @Column(name = "close_volume")
    private Integer closeVolume;

    /**
     * 开仓金额 
     */
    @Column(name = "open_amount")
    private Double openAmount;

    /**
     * 平仓金额 
     */
    @Column(name = "close_amount")
    private Double closeAmount;

    /**
     * 持仓成本
     */
    @Column(name = "position_cost")
    private Double positionCost;

    /**
     * 上次占用的保证金
     */
    @Column(name = "pre_margin")
    private Double preMargin;

    /**
     * 占用的保证金
     */
    @Column(name = "use_margin")
    private Double useMargin;

    /**
     * 冻结的保证金
     */
    @Column(name = "frozen_margin")
    private Double frozenMargin;

    /**
     * 冻结的资
     */
    @Column(name = "frozen_cash")
    private Double frozenCash;

    /**
     * 冻结的手续费
     */
    @Column(name = "frozen_commission")
    private Double frozenCommission;

    /**
     * 资金差额
     */
    @Column(name = "cash_in")
    private Double cashIn;

    /**
     * 手续费
     */
    private Double commission;

    /**
     * 平仓盈亏
     */
    @Column(name = "close_profit")
    private Double closeProfit;

    /**
     * 持仓盈亏
     */
    @Column(name = "position_profit")
    private Double positionProfit;

    /**
     * 上次结算价
     */
    @Column(name = "pre_settlement_price")
    private Double preSettlementPrice;

    /**
     * 本次结算价
     */
    @Column(name = "settlement_price")
    private Double settlementPrice;

    /**
     * 结算编号
     */
    @Column(name = "settlement_id")
    private Integer settlementId;

    /**
     * 用户代码 
     */
    @Column(name = "user_id")
    private Integer userId;

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
     * 持仓日期
     */
    @Column(name = "position_tdate")
    private String positionTdate;

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
     * 获取净：'1',多头：'2',空头：‘3’
     *
     * @return posi_direction - 净：'1',多头：'2',空头：‘3’
     */
    public Byte getPosiDirection() {
        return posiDirection;
    }

    /**
     * 设置净：'1',多头：'2',空头：‘3’
     *
     * @param posiDirection 净：'1',多头：'2',空头：‘3’
     */
    public void setPosiDirection(Byte posiDirection) {
        this.posiDirection = posiDirection;
    }

    /**
     * 获取投机
： '1'
，套利： '2'，套保
： '3'
，做市商：
 '5'
     *
     * @return hedge_flag - 投机
： '1'
，套利： '2'，套保
： '3'
，做市商：
 '5'
     */
    public Byte getHedgeFlag() {
        return hedgeFlag;
    }

    /**
     * 设置投机
： '1'
，套利： '2'，套保
： '3'
，做市商：
 '5'
     *
     * @param hedgeFlag 投机
： '1'
，套利： '2'，套保
： '3'
，做市商：
 '5'
     */
    public void setHedgeFlag(Byte hedgeFlag) {
        this.hedgeFlag = hedgeFlag;
    }

    /**
     * 获取今日持仓
：'1'，
历史持仓
： '2'
     *
     * @return position_date - 今日持仓
：'1'，
历史持仓
： '2'
     */
    public Byte getPositionDate() {
        return positionDate;
    }

    /**
     * 设置今日持仓
：'1'，
历史持仓
： '2'
     *
     * @param positionDate 今日持仓
：'1'，
历史持仓
： '2'
     */
    public void setPositionDate(Byte positionDate) {
        this.positionDate = positionDate;
    }

    /**
     * 获取上日持仓
     *
     * @return yd_position - 上日持仓
     */
    public Integer getYdPosition() {
        return ydPosition;
    }

    /**
     * 设置上日持仓
     *
     * @param ydPosition 上日持仓
     */
    public void setYdPosition(Integer ydPosition) {
        this.ydPosition = ydPosition;
    }

    /**
     * 获取今日持仓
     *
     * @return position - 今日持仓
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * 设置今日持仓
     *
     * @param position 今日持仓
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * 获取多头冻结
     *
     * @return long_frozen - 多头冻结
     */
    public Integer getLongFrozen() {
        return longFrozen;
    }

    /**
     * 设置多头冻结
     *
     * @param longFrozen 多头冻结
     */
    public void setLongFrozen(Integer longFrozen) {
        this.longFrozen = longFrozen;
    }

    /**
     * 获取空头冻结
     *
     * @return short_frozen - 空头冻结
     */
    public Integer getShortFrozen() {
        return shortFrozen;
    }

    /**
     * 设置空头冻结
     *
     * @param shortFrozen 空头冻结
     */
    public void setShortFrozen(Integer shortFrozen) {
        this.shortFrozen = shortFrozen;
    }

    /**
     * 获取多头冻结金额
     *
     * @return long_frozen_amount - 多头冻结金额
     */
    public Double getLongFrozenAmount() {
        return longFrozenAmount;
    }

    /**
     * 设置多头冻结金额
     *
     * @param longFrozenAmount 多头冻结金额
     */
    public void setLongFrozenAmount(Double longFrozenAmount) {
        this.longFrozenAmount = longFrozenAmount;
    }

    /**
     * 获取空头冻结金额
     *
     * @return short_frozen_amount - 空头冻结金额
     */
    public Double getShortFrozenAmount() {
        return shortFrozenAmount;
    }

    /**
     * 设置空头冻结金额
     *
     * @param shortFrozenAmount 空头冻结金额
     */
    public void setShortFrozenAmount(Double shortFrozenAmount) {
        this.shortFrozenAmount = shortFrozenAmount;
    }

    /**
     * 获取开仓量
     *
     * @return open_volume - 开仓量
     */
    public Integer getOpenVolume() {
        return openVolume;
    }

    /**
     * 设置开仓量
     *
     * @param openVolume 开仓量
     */
    public void setOpenVolume(Integer openVolume) {
        this.openVolume = openVolume;
    }

    /**
     * 获取平仓量
     *
     * @return close_volume - 平仓量
     */
    public Integer getCloseVolume() {
        return closeVolume;
    }

    /**
     * 设置平仓量
     *
     * @param closeVolume 平仓量
     */
    public void setCloseVolume(Integer closeVolume) {
        this.closeVolume = closeVolume;
    }

    /**
     * 获取开仓金额 
     *
     * @return open_amount - 开仓金额 
     */
    public Double getOpenAmount() {
        return openAmount;
    }

    /**
     * 设置开仓金额 
     *
     * @param openAmount 开仓金额 
     */
    public void setOpenAmount(Double openAmount) {
        this.openAmount = openAmount;
    }

    /**
     * 获取平仓金额 
     *
     * @return close_amount - 平仓金额 
     */
    public Double getCloseAmount() {
        return closeAmount;
    }

    /**
     * 设置平仓金额 
     *
     * @param closeAmount 平仓金额 
     */
    public void setCloseAmount(Double closeAmount) {
        this.closeAmount = closeAmount;
    }

    /**
     * 获取持仓成本
     *
     * @return position_cost - 持仓成本
     */
    public Double getPositionCost() {
        return positionCost;
    }

    /**
     * 设置持仓成本
     *
     * @param positionCost 持仓成本
     */
    public void setPositionCost(Double positionCost) {
        this.positionCost = positionCost;
    }

    /**
     * 获取上次占用的保证金
     *
     * @return pre_margin - 上次占用的保证金
     */
    public Double getPreMargin() {
        return preMargin;
    }

    /**
     * 设置上次占用的保证金
     *
     * @param preMargin 上次占用的保证金
     */
    public void setPreMargin(Double preMargin) {
        this.preMargin = preMargin;
    }

    /**
     * 获取占用的保证金
     *
     * @return use_margin - 占用的保证金
     */
    public Double getUseMargin() {
        return useMargin;
    }

    /**
     * 设置占用的保证金
     *
     * @param useMargin 占用的保证金
     */
    public void setUseMargin(Double useMargin) {
        this.useMargin = useMargin;
    }

    /**
     * 获取冻结的保证金
     *
     * @return frozen_margin - 冻结的保证金
     */
    public Double getFrozenMargin() {
        return frozenMargin;
    }

    /**
     * 设置冻结的保证金
     *
     * @param frozenMargin 冻结的保证金
     */
    public void setFrozenMargin(Double frozenMargin) {
        this.frozenMargin = frozenMargin;
    }

    /**
     * 获取冻结的资
     *
     * @return frozen_cash - 冻结的资
     */
    public Double getFrozenCash() {
        return frozenCash;
    }

    /**
     * 设置冻结的资
     *
     * @param frozenCash 冻结的资
     */
    public void setFrozenCash(Double frozenCash) {
        this.frozenCash = frozenCash;
    }

    /**
     * 获取冻结的手续费
     *
     * @return frozen_commission - 冻结的手续费
     */
    public Double getFrozenCommission() {
        return frozenCommission;
    }

    /**
     * 设置冻结的手续费
     *
     * @param frozenCommission 冻结的手续费
     */
    public void setFrozenCommission(Double frozenCommission) {
        this.frozenCommission = frozenCommission;
    }

    /**
     * 获取资金差额
     *
     * @return cash_in - 资金差额
     */
    public Double getCashIn() {
        return cashIn;
    }

    /**
     * 设置资金差额
     *
     * @param cashIn 资金差额
     */
    public void setCashIn(Double cashIn) {
        this.cashIn = cashIn;
    }

    /**
     * 获取手续费
     *
     * @return commission - 手续费
     */
    public Double getCommission() {
        return commission;
    }

    /**
     * 设置手续费
     *
     * @param commission 手续费
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * 获取平仓盈亏
     *
     * @return close_profit - 平仓盈亏
     */
    public Double getCloseProfit() {
        return closeProfit;
    }

    /**
     * 设置平仓盈亏
     *
     * @param closeProfit 平仓盈亏
     */
    public void setCloseProfit(Double closeProfit) {
        this.closeProfit = closeProfit;
    }

    /**
     * 获取持仓盈亏
     *
     * @return position_profit - 持仓盈亏
     */
    public Double getPositionProfit() {
        return positionProfit;
    }

    /**
     * 设置持仓盈亏
     *
     * @param positionProfit 持仓盈亏
     */
    public void setPositionProfit(Double positionProfit) {
        this.positionProfit = positionProfit;
    }

    /**
     * 获取上次结算价
     *
     * @return pre_settlement_price - 上次结算价
     */
    public Double getPreSettlementPrice() {
        return preSettlementPrice;
    }

    /**
     * 设置上次结算价
     *
     * @param preSettlementPrice 上次结算价
     */
    public void setPreSettlementPrice(Double preSettlementPrice) {
        this.preSettlementPrice = preSettlementPrice;
    }

    /**
     * 获取本次结算价
     *
     * @return settlement_price - 本次结算价
     */
    public Double getSettlementPrice() {
        return settlementPrice;
    }

    /**
     * 设置本次结算价
     *
     * @param settlementPrice 本次结算价
     */
    public void setSettlementPrice(Double settlementPrice) {
        this.settlementPrice = settlementPrice;
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
     * 获取用户代码 
     *
     * @return user_id - 用户代码 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户代码 
     *
     * @param userId 用户代码 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 获取持仓日期
     *
     * @return position_tdate - 持仓日期
     */
    public String getPositionTdate() {
        return positionTdate;
    }

    /**
     * 设置持仓日期
     *
     * @param positionTdate 持仓日期
     */
    public void setPositionTdate(String positionTdate) {
        this.positionTdate = positionTdate;
    }
}