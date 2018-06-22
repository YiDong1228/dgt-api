package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInstrumentOrderCommRateField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte HedgeFlag;
    public double OrderCommByVolume;
    public double OrderActionCommByVolume;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInstrumentOrderCommRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInstrumentOrderCommRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("HedgeFlag");
        a.add("OrderCommByVolume");
        a.add("OrderActionCommByVolume");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
