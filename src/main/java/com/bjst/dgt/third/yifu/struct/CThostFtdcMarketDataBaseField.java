package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarketDataBaseField extends Structure {
    public byte[] TradingDay = new byte[9];
    public double PreSettlementPrice;
    public double PreClosePrice;
    public double PreOpenInterest;
    public double PreDelta;

    public static class ByReference extends CThostFtdcMarketDataBaseField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarketDataBaseField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("PreSettlementPrice");
        a.add("PreClosePrice");
        a.add("PreOpenInterest");
        a.add("PreDelta");
        return a;
    }
};
