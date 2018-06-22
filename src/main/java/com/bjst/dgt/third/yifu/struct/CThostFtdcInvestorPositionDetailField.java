package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorPositionDetailField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte HedgeFlag;
    public byte Direction;
    public byte[] OpenDate = new byte[9];
    public byte[] TradeID = new byte[21];
    public int Volume;
    public double OpenPrice;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public byte TradeType;
    public byte[] CombInstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public double CloseProfitByDate;
    public double CloseProfitByTrade;
    public double PositionProfitByDate;
    public double PositionProfitByTrade;
    public double Margin;
    public double ExchMargin;
    public double MarginRateByMoney;
    public double MarginRateByVolume;
    public double LastSettlementPrice;
    public double SettlementPrice;
    public int CloseVolume;
    public double CloseAmount;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInvestorPositionDetailField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorPositionDetailField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("HedgeFlag");
        a.add("Direction");
        a.add("OpenDate");
        a.add("TradeID");
        a.add("Volume");
        a.add("OpenPrice");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("TradeType");
        a.add("CombInstrumentID");
        a.add("ExchangeID");
        a.add("CloseProfitByDate");
        a.add("CloseProfitByTrade");
        a.add("PositionProfitByDate");
        a.add("PositionProfitByTrade");
        a.add("Margin");
        a.add("ExchMargin");
        a.add("MarginRateByMoney");
        a.add("MarginRateByVolume");
        a.add("LastSettlementPrice");
        a.add("SettlementPrice");
        a.add("CloseVolume");
        a.add("CloseAmount");
        a.add("InvestUnitID");
        return a;
    }
};
