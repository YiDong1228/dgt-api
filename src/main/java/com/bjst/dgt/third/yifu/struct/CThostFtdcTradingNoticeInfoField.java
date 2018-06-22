package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradingNoticeInfoField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] SendTime = new byte[9];
    public byte[] FieldContent = new byte[501];
    public short SequenceSeries;
    public int SequenceNo;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcTradingNoticeInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradingNoticeInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("SendTime");
        a.add("FieldContent");
        a.add("SequenceSeries");
        a.add("SequenceNo");
        a.add("InvestUnitID");
        return a;
    }
};
