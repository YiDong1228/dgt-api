package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCurrentTimeField extends Structure {
    public byte[] CurrDate = new byte[9];
    public byte[] CurrTime = new byte[9];
    public int CurrMillisec;
    public byte[] ActionDay = new byte[9];

    public static class ByReference extends CThostFtdcCurrentTimeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCurrentTimeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("CurrDate");
        a.add("CurrTime");
        a.add("CurrMillisec");
        a.add("ActionDay");
        return a;
    }
};
