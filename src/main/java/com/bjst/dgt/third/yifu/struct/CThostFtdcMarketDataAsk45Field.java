package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataAsk45Field extends Structure {
    public double AskPrice4;
    public int AskVolume4;
    public double AskPrice5;
    public int AskVolume5;

    public static class ByReference extends CThostFtdcMarketDataAsk45Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataAsk45Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("AskPrice4");
        a.add("AskVolume4");
        a.add("AskPrice5");
        a.add("AskVolume5");
        return a;
    }
};
