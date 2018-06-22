package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcForQuoteField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] ForQuoteRef = new byte[13];
    public byte[] UserID = new byte[16];
    public byte[] ForQuoteLocalID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte[] InsertDate = new byte[9];
    public byte[] InsertTime = new byte[9];
    public byte ForQuoteStatus;
    public int FrontID;
    public int SessionID;
    public byte[] StatusMsg = new byte[81];
    public byte[] ActiveUserID = new byte[16];
    public int BrokerForQutoSeq;
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcForQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcForQuoteField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("ForQuoteRef");
        a.add("UserID");
        a.add("ForQuoteLocalID");
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("ExchangeInstID");
        a.add("TraderID");
        a.add("InstallID");
        a.add("InsertDate");
        a.add("InsertTime");
        a.add("ForQuoteStatus");
        a.add("FrontID");
        a.add("SessionID");
        a.add("StatusMsg");
        a.add("ActiveUserID");
        a.add("BrokerForQutoSeq");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
