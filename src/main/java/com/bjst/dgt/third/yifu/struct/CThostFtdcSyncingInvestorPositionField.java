package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncingInvestorPositionField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte PosiDirection;
    public byte HedgeFlag;
    public byte PositionDate;
    public int YdPosition;
    public int Position;
    public int LongFrozen;
    public int ShortFrozen;
    public double LongFrozenAmount;
    public double ShortFrozenAmount;
    public int OpenVolume;
    public int CloseVolume;
    public double OpenAmount;
    public double CloseAmount;
    public double PositionCost;
    public double PreMargin;
    public double UseMargin;
    public double FrozenMargin;
    public double FrozenCash;
    public double FrozenCommission;
    public double CashIn;
    public double Commission;
    public double CloseProfit;
    public double PositionProfit;
    public double PreSettlementPrice;
    public double SettlementPrice;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public double OpenCost;
    public double ExchangeMargin;
    public int CombPosition;
    public int CombLongFrozen;
    public int CombShortFrozen;
    public double CloseProfitByDate;
    public double CloseProfitByTrade;
    public int TodayPosition;
    public double MarginRateByMoney;
    public double MarginRateByVolume;
    public int StrikeFrozen;
    public double StrikeFrozenAmount;
    public int AbandonFrozen;
    public byte[] ExchangeID = new byte[9];
    public int YdStrikeFrozen;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcSyncingInvestorPositionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncingInvestorPositionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("PosiDirection");
        a.add("HedgeFlag");
        a.add("PositionDate");
        a.add("YdPosition");
        a.add("Position");
        a.add("LongFrozen");
        a.add("ShortFrozen");
        a.add("LongFrozenAmount");
        a.add("ShortFrozenAmount");
        a.add("OpenVolume");
        a.add("CloseVolume");
        a.add("OpenAmount");
        a.add("CloseAmount");
        a.add("PositionCost");
        a.add("PreMargin");
        a.add("UseMargin");
        a.add("FrozenMargin");
        a.add("FrozenCash");
        a.add("FrozenCommission");
        a.add("CashIn");
        a.add("Commission");
        a.add("CloseProfit");
        a.add("PositionProfit");
        a.add("PreSettlementPrice");
        a.add("SettlementPrice");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("OpenCost");
        a.add("ExchangeMargin");
        a.add("CombPosition");
        a.add("CombLongFrozen");
        a.add("CombShortFrozen");
        a.add("CloseProfitByDate");
        a.add("CloseProfitByTrade");
        a.add("TodayPosition");
        a.add("MarginRateByMoney");
        a.add("MarginRateByVolume");
        a.add("StrikeFrozen");
        a.add("StrikeFrozenAmount");
        a.add("AbandonFrozen");
        a.add("ExchangeID");
        a.add("YdStrikeFrozen");
        a.add("InvestUnitID");
        return a;
    }
};
