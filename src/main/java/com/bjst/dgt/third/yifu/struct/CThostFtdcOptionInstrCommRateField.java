package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcOptionInstrCommRateField extends Structure {
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
    public double StrikeRatioByMoney;
    public double StrikeRatioByVolume;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcOptionInstrCommRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcOptionInstrCommRateField implements Structure.ByValue {}

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
        a.add("StrikeRatioByMoney");
        a.add("StrikeRatioByVolume");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
