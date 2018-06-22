package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataStaticField extends Structure {
    public double OpenPrice;
    public double HighestPrice;
    public double LowestPrice;
    public double ClosePrice;
    public double UpperLimitPrice;
    public double LowerLimitPrice;
    public double SettlementPrice;
    public double CurrDelta;

    public static class ByReference extends CThostFtdcMarketDataStaticField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataStaticField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("OpenPrice");
        a.add("HighestPrice");
        a.add("LowestPrice");
        a.add("ClosePrice");
        a.add("UpperLimitPrice");
        a.add("LowerLimitPrice");
        a.add("SettlementPrice");
        a.add("CurrDelta");
        return a;
    }
};
