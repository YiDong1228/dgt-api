package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryQuoteField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public byte[] QuoteSysID = new byte[21];
    public byte[] InsertTimeStart = new byte[9];
    public byte[] InsertTimeEnd = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQryQuoteField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryQuoteField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("ExchangeID");
        a.add("QuoteSysID");
        a.add("InsertTimeStart");
        a.add("InsertTimeEnd");
        a.add("InvestUnitID");
        return a;
    }
};
