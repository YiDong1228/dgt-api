package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCombinationLegField extends Structure {
    public byte[] CombInstrumentID = new byte[31];
    public int LegID;
    public byte[] LegInstrumentID = new byte[31];
    public byte Direction;
    public int LegMultiple;
    public int ImplyLevel;

    public static class ByReference extends CThostFtdcCombinationLegField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCombinationLegField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("CombInstrumentID");
        a.add("LegID");
        a.add("LegInstrumentID");
        a.add("Direction");
        a.add("LegMultiple");
        a.add("ImplyLevel");
        return a;
    }
};
