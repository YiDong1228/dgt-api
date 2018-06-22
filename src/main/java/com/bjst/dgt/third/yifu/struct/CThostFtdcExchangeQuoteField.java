package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeQuoteField extends Structure {
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
    public byte[] QuoteLocalID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public int NotifySequence;
    public byte OrderSubmitStatus;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public byte[] QuoteSysID = new byte[21];
    public byte[] InsertDate = new byte[9];
    public byte[] InsertTime = new byte[9];
    public byte[] CancelTime = new byte[9];
    public byte QuoteStatus;
    public byte[] ClearingPartID = new byte[11];
    public int SequenceNo;
    public byte[] AskOrderSysID = new byte[21];
    public byte[] BidOrderSysID = new byte[21];
    public byte[] ForQuoteSysID = new byte[21];
    public byte[] BranchID = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeQuoteField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
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
        a.add("QuoteLocalID");
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("ExchangeInstID");
        a.add("TraderID");
        a.add("InstallID");
        a.add("NotifySequence");
        a.add("OrderSubmitStatus");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("QuoteSysID");
        a.add("InsertDate");
        a.add("InsertTime");
        a.add("CancelTime");
        a.add("QuoteStatus");
        a.add("ClearingPartID");
        a.add("SequenceNo");
        a.add("AskOrderSysID");
        a.add("BidOrderSysID");
        a.add("ForQuoteSysID");
        a.add("BranchID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
