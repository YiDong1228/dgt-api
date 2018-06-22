package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataAsk23Field extends Structure {
    public double AskPrice2;
    public int AskVolume2;
    public double AskPrice3;
    public int AskVolume3;

    public static class ByReference extends CThostFtdcMarketDataAsk23Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataAsk23Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("AskPrice2");
        a.add("AskVolume2");
        a.add("AskPrice3");
        a.add("AskVolume3");
        return a;
    }
};
