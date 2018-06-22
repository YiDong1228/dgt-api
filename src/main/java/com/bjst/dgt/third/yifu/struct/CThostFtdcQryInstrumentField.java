package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryInstrumentField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] ProductID = new byte[31];

    public static class ByReference extends CThostFtdcQryInstrumentField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryInstrumentField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("ExchangeID");
        a.add("ExchangeInstID");
        a.add("ProductID");
        return a;
    }
};
