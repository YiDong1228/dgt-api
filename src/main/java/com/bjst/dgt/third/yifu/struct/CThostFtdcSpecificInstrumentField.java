package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSpecificInstrumentField extends Structure {
    public byte[] InstrumentID = new byte[31];

    public static class ByReference extends CThostFtdcSpecificInstrumentField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSpecificInstrumentField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        return a;
    }
};
