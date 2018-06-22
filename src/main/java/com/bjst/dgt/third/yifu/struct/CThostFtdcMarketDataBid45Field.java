package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataBid45Field extends Structure {
    public double BidPrice4;
    public int BidVolume4;
    public double BidPrice5;
    public int BidVolume5;

    public static class ByReference extends CThostFtdcMarketDataBid45Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataBid45Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BidPrice4");
        a.add("BidVolume4");
        a.add("BidPrice5");
        a.add("BidVolume5");
        return a;
    }
};
