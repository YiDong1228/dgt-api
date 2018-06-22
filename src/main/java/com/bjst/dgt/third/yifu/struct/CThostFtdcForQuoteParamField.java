package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcForQuoteParamField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public double LastPrice;
    public double PriceInterval;

    public static class ByReference extends CThostFtdcForQuoteParamField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcForQuoteParamField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InstrumentID");
        a.add("ExchangeID");
        a.add("LastPrice");
        a.add("PriceInterval");
        return a;
    }
};
