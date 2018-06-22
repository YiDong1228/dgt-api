package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataUpdateTimeField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] UpdateTime = new byte[9];
    public int UpdateMillisec;
    public byte[] ActionDay = new byte[9];

    public static class ByReference extends CThostFtdcMarketDataUpdateTimeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataUpdateTimeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("UpdateTime");
        a.add("UpdateMillisec");
        a.add("ActionDay");
        return a;
    }
};
