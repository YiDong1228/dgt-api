package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInstrumentMarginRateULField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte HedgeFlag;
    public double LongMarginRatioByMoney;
    public double LongMarginRatioByVolume;
    public double ShortMarginRatioByMoney;
    public double ShortMarginRatioByVolume;

    public static class ByReference extends CThostFtdcInstrumentMarginRateULField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInstrumentMarginRateULField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("HedgeFlag");
        a.add("LongMarginRatioByMoney");
        a.add("LongMarginRatioByVolume");
        a.add("ShortMarginRatioByMoney");
        a.add("ShortMarginRatioByVolume");
        return a;
    }
};
