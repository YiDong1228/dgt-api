package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryDepthMarketDataField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryDepthMarketDataField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryDepthMarketDataField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("ExchangeID");
        return a;
    }
};
