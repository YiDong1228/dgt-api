package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeForQuoteField extends Structure {
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
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeForQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeForQuoteField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
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
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
