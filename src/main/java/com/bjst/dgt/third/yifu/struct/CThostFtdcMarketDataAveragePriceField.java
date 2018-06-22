package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataAveragePriceField extends Structure {
    public double AveragePrice;

    public static class ByReference extends CThostFtdcMarketDataAveragePriceField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataAveragePriceField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("AveragePrice");
        return a;
    }
};
