package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public byte[] ExchangeInstID = new byte[31];
    public double LastPrice;
    public double PreSettlementPrice;
    public double PreClosePrice;
    public double PreOpenInterest;
    public double OpenPrice;
    public double HighestPrice;
    public double LowestPrice;
    public int Volume;
    public double Turnover;
    public double OpenInterest;
    public double ClosePrice;
    public double SettlementPrice;
    public double UpperLimitPrice;
    public double LowerLimitPrice;
    public double PreDelta;
    public double CurrDelta;
    public byte[] UpdateTime = new byte[9];
    public int UpdateMillisec;
    public byte[] ActionDay = new byte[9];

    public static class ByReference extends CThostFtdcMarketDataField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("InstrumentID");
        a.add("ExchangeID");
        a.add("ExchangeInstID");
        a.add("LastPrice");
        a.add("PreSettlementPrice");
        a.add("PreClosePrice");
        a.add("PreOpenInterest");
        a.add("OpenPrice");
        a.add("HighestPrice");
        a.add("LowestPrice");
        a.add("Volume");
        a.add("Turnover");
        a.add("OpenInterest");
        a.add("ClosePrice");
        a.add("SettlementPrice");
        a.add("UpperLimitPrice");
        a.add("LowerLimitPrice");
        a.add("PreDelta");
        a.add("CurrDelta");
        a.add("UpdateTime");
        a.add("UpdateMillisec");
        a.add("ActionDay");
        return a;
    }
};
