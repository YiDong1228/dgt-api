package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInstrumentStatusField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] SettlementGroupID = new byte[9];
    public byte[] InstrumentID = new byte[31];
    public byte InstrumentStatus;
    public int TradingSegmentSN;
    public byte[] EnterTime = new byte[9];
    public byte EnterReason;

    public static class ByReference extends CThostFtdcInstrumentStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInstrumentStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ExchangeInstID");
        a.add("SettlementGroupID");
        a.add("InstrumentID");
        a.add("InstrumentStatus");
        a.add("TradingSegmentSN");
        a.add("EnterTime");
        a.add("EnterReason");
        return a;
    }
};
