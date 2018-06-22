package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQuoteField extends Structure {
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
    public int FrontID;
    public int SessionID;
    public byte[] UserProductInfo = new byte[11];
    public byte[] StatusMsg = new byte[81];
    public byte[] ActiveUserID = new byte[16];
    public int BrokerQuoteSeq;
    public byte[] AskOrderRef = new byte[13];
    public byte[] BidOrderRef = new byte[13];
    public byte[] ForQuoteSysID = new byte[21];
    public byte[] BranchID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQuoteField implements Structure.ByValue {}

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
        a.add("FrontID");
        a.add("SessionID");
        a.add("UserProductInfo");
        a.add("StatusMsg");
        a.add("ActiveUserID");
        a.add("BrokerQuoteSeq");
        a.add("AskOrderRef");
        a.add("BidOrderRef");
        a.add("ForQuoteSysID");
        a.add("BranchID");
        a.add("InvestUnitID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
