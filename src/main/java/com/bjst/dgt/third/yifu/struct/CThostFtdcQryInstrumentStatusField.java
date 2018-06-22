package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryInstrumentStatusField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ExchangeInstID = new byte[31];

    public static class ByReference extends CThostFtdcQryInstrumentStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryInstrumentStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ExchangeInstID");
        return a;
    }
};
