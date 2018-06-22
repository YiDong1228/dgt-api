package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcEWarrantOffsetField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] InstrumentID = new byte[31];
    public byte Direction;
    public byte HedgeFlag;
    public int Volume;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcEWarrantOffsetField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcEWarrantOffsetField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ExchangeID");
        a.add("InstrumentID");
        a.add("Direction");
        a.add("HedgeFlag");
        a.add("Volume");
        a.add("InvestUnitID");
        return a;
    }
};
