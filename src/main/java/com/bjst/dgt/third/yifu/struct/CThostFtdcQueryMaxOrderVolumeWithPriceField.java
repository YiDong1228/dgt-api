package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQueryMaxOrderVolumeWithPriceField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte Direction;
    public byte OffsetFlag;
    public byte HedgeFlag;
    public int MaxVolume;
    public double Price;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQueryMaxOrderVolumeWithPriceField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQueryMaxOrderVolumeWithPriceField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("Direction");
        a.add("OffsetFlag");
        a.add("HedgeFlag");
        a.add("MaxVolume");
        a.add("Price");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
