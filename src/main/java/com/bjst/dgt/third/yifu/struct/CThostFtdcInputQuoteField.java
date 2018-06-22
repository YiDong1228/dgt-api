package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputQuoteField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] QuoteRef = new byte[13];
    public byte[] UserID = new byte[16];
    public double AskPrice;
    public double BidPrice;
    public int AskVolume;
    public int BidVolume;
    public int RequestID;
    public byte[] BusinessUnit = new byte[21];
    public byte AskOffsetFlag;
    public byte BidOffsetFlag;
    public byte AskHedgeFlag;
    public byte BidHedgeFlag;
    public byte[] AskOrderRef = new byte[13];
    public byte[] BidOrderRef = new byte[13];
    public byte[] ForQuoteSysID = new byte[21];
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] ClientID = new byte[11];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcInputQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputQuoteField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("QuoteRef");
        a.add("UserID");
        a.add("AskPrice");
        a.add("BidPrice");
        a.add("AskVolume");
        a.add("BidVolume");
        a.add("RequestID");
        a.add("BusinessUnit");
        a.add("AskOffsetFlag");
        a.add("BidOffsetFlag");
        a.add("AskHedgeFlag");
        a.add("BidHedgeFlag");
        a.add("AskOrderRef");
        a.add("BidOrderRef");
        a.add("ForQuoteSysID");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        a.add("ClientID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
