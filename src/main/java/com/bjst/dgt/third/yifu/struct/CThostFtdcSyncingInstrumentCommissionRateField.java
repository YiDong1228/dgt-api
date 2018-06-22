package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncingInstrumentCommissionRateField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public double OpenRatioByMoney;
    public double OpenRatioByVolume;
    public double CloseRatioByMoney;
    public double CloseRatioByVolume;
    public double CloseTodayRatioByMoney;
    public double CloseTodayRatioByVolume;

    public static class ByReference extends CThostFtdcSyncingInstrumentCommissionRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncingInstrumentCommissionRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OpenRatioByMoney");
        a.add("OpenRatioByVolume");
        a.add("CloseRatioByMoney");
        a.add("CloseRatioByVolume");
        a.add("CloseTodayRatioByMoney");
        a.add("CloseTodayRatioByVolume");
        return a;
    }
};
