package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInstrumentMarginRateField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte HedgeFlag;
    public double LongMarginRatioByMoney;
    public double LongMarginRatioByVolume;
    public double ShortMarginRatioByMoney;
    public double ShortMarginRatioByVolume;
    public int IsRelative;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInstrumentMarginRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInstrumentMarginRateField implements Structure.ByValue {}

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
        a.add("IsRelative");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
