package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeMarginRateAdjustField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InstrumentID = new byte[31];
    public byte HedgeFlag;
    public double LongMarginRatioByMoney;
    public double LongMarginRatioByVolume;
    public double ShortMarginRatioByMoney;
    public double ShortMarginRatioByVolume;
    public double ExchLongMarginRatioByMoney;
    public double ExchLongMarginRatioByVolume;
    public double ExchShortMarginRatioByMoney;
    public double ExchShortMarginRatioByVolume;
    public double NoLongMarginRatioByMoney;
    public double NoLongMarginRatioByVolume;
    public double NoShortMarginRatioByMoney;
    public double NoShortMarginRatioByVolume;

    public static class ByReference extends CThostFtdcExchangeMarginRateAdjustField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeMarginRateAdjustField implements Structure.ByValue {}

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
        a.add("ExchLongMarginRatioByMoney");
        a.add("ExchLongMarginRatioByVolume");
        a.add("ExchShortMarginRatioByMoney");
        a.add("ExchShortMarginRatioByVolume");
        a.add("NoLongMarginRatioByMoney");
        a.add("NoLongMarginRatioByVolume");
        a.add("NoShortMarginRatioByMoney");
        a.add("NoShortMarginRatioByVolume");
        return a;
    }
};
