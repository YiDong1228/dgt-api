package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataBid23Field extends Structure {
    public double BidPrice2;
    public int BidVolume2;
    public double BidPrice3;
    public int BidVolume3;

    public static class ByReference extends CThostFtdcMarketDataBid23Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataBid23Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BidPrice2");
        a.add("BidVolume2");
        a.add("BidPrice3");
        a.add("BidVolume3");
        return a;
    }
};
