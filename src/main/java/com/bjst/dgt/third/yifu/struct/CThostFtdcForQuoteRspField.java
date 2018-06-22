package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcForQuoteRspField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] InstrumentID = new byte[31];
    public byte[] ForQuoteSysID = new byte[21];
    public byte[] ForQuoteTime = new byte[9];
    public byte[] ActionDay = new byte[9];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcForQuoteRspField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcForQuoteRspField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("InstrumentID");
        a.add("ForQuoteSysID");
        a.add("ForQuoteTime");
        a.add("ActionDay");
        a.add("ExchangeID");
        return a;
    }
};
