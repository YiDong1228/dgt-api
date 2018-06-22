package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataBestPriceField extends Structure {
    public double BidPrice1;
    public int BidVolume1;
    public double AskPrice1;
    public int AskVolume1;

    public static class ByReference extends CThostFtdcMarketDataBestPriceField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataBestPriceField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BidPrice1");
        a.add("BidVolume1");
        a.add("AskPrice1");
        a.add("AskVolume1");
        return a;
    }
};
