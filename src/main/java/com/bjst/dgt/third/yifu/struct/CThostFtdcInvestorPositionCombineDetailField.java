package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorPositionCombineDetailField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] OpenDate = new byte[9];
    public byte[] ExchangeID = new byte[9];
    public int SettlementID;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ComTradeID = new byte[21];
    public byte[] TradeID = new byte[21];
    public byte[] InstrumentID = new byte[31];
    public byte HedgeFlag;
    public byte Direction;
    public int TotalAmt;
    public double Margin;
    public double ExchMargin;
    public double MarginRateByMoney;
    public double MarginRateByVolume;
    public int LegID;
    public int LegMultiple;
    public byte[] CombInstrumentID = new byte[31];
    public int TradeGroupID;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInvestorPositionCombineDetailField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorPositionCombineDetailField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("OpenDate");
        a.add("ExchangeID");
        a.add("SettlementID");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ComTradeID");
        a.add("TradeID");
        a.add("InstrumentID");
        a.add("HedgeFlag");
        a.add("Direction");
        a.add("TotalAmt");
        a.add("Margin");
        a.add("ExchMargin");
        a.add("MarginRateByMoney");
        a.add("MarginRateByVolume");
        a.add("LegID");
        a.add("LegMultiple");
        a.add("CombInstrumentID");
        a.add("TradeGroupID");
        a.add("InvestUnitID");
        return a;
    }
};
