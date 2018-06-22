package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataLastMatchField extends Structure {
    public double LastPrice;
    public int Volume;
    public double Turnover;
    public double OpenInterest;

    public static class ByReference extends CThostFtdcMarketDataLastMatchField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataLastMatchField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("LastPrice");
        a.add("Volume");
        a.add("Turnover");
        a.add("OpenInterest");
        return a;
    }
};
