package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcDepthMarketDataField extends Structure {
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
    public double BidPrice1;
    public int BidVolume1;
    public double AskPrice1;
    public int AskVolume1;
    public double BidPrice2;
    public int BidVolume2;
    public double AskPrice2;
    public int AskVolume2;
    public double BidPrice3;
    public int BidVolume3;
    public double AskPrice3;
    public int AskVolume3;
    public double BidPrice4;
    public int BidVolume4;
    public double AskPrice4;
    public int AskVolume4;
    public double BidPrice5;
    public int BidVolume5;
    public double AskPrice5;
    public int AskVolume5;
    public double AveragePrice;
    public byte[] ActionDay = new byte[9];

    public static class ByReference extends CThostFtdcDepthMarketDataField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcDepthMarketDataField implements Structure.ByValue {}

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
        a.add("BidPrice1");
        a.add("BidVolume1");
        a.add("AskPrice1");
        a.add("AskVolume1");
        a.add("BidPrice2");
        a.add("BidVolume2");
        a.add("AskPrice2");
        a.add("AskVolume2");
        a.add("BidPrice3");
        a.add("BidVolume3");
        a.add("AskPrice3");
        a.add("AskVolume3");
        a.add("BidPrice4");
        a.add("BidVolume4");
        a.add("AskPrice4");
        a.add("AskVolume4");
        a.add("BidPrice5");
        a.add("BidVolume5");
        a.add("AskPrice5");
        a.add("AskVolume5");
        a.add("AveragePrice");
        a.add("ActionDay");
        return a;
    }
};
