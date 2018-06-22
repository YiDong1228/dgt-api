package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcStrikeOffsetField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public double Offset;
    public byte OffsetType;

    public static class ByReference extends CThostFtdcStrikeOffsetField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcStrikeOffsetField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("Offset");
        a.add("OffsetType");
        return a;
    }
};
