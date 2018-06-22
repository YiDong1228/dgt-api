package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcOptionInstrMarginAdjustField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public double SShortMarginRatioByMoney;
    public double SShortMarginRatioByVolume;
    public double HShortMarginRatioByMoney;
    public double HShortMarginRatioByVolume;
    public double AShortMarginRatioByMoney;
    public double AShortMarginRatioByVolume;
    public int IsRelative;
    public double MShortMarginRatioByMoney;
    public double MShortMarginRatioByVolume;

    public static class ByReference extends CThostFtdcOptionInstrMarginAdjustField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcOptionInstrMarginAdjustField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("SShortMarginRatioByMoney");
        a.add("SShortMarginRatioByVolume");
        a.add("HShortMarginRatioByMoney");
        a.add("HShortMarginRatioByVolume");
        a.add("AShortMarginRatioByMoney");
        a.add("AShortMarginRatioByVolume");
        a.add("IsRelative");
        a.add("MShortMarginRatioByMoney");
        a.add("MShortMarginRatioByVolume");
        return a;
    }
};
