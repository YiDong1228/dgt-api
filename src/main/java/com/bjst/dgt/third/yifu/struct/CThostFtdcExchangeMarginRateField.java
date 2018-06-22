package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeMarginRateField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InstrumentID = new byte[31];
    public byte HedgeFlag;
    public double LongMarginRatioByMoney;
    public double LongMarginRatioByVolume;
    public double ShortMarginRatioByMoney;
    public double ShortMarginRatioByVolume;
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcExchangeMarginRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeMarginRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InstrumentID");
        a.add("HedgeFlag");
        a.add("LongMarginRatioByMoney");
        a.add("LongMarginRatioByVolume");
        a.add("ShortMarginRatioByMoney");
        a.add("ShortMarginRatioByVolume");
        a.add("ExchangeID");
        return a;
    }
};
