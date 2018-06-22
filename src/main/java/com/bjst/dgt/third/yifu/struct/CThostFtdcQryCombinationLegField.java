package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryCombinationLegField extends Structure {
    public byte[] CombInstrumentID = new byte[31];
    public int LegID;
    public byte[] LegInstrumentID = new byte[31];

    public static class ByReference extends CThostFtdcQryCombinationLegField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryCombinationLegField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("CombInstrumentID");
        a.add("LegID");
        a.add("LegInstrumentID");
        return a;
    }
};
