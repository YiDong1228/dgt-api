package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradingNoticeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte InvestorRange;
    public byte[] InvestorID = new byte[13];
    public short SequenceSeries;
    public byte[] UserID = new byte[16];
    public byte[] SendTime = new byte[9];
    public int SequenceNo;
    public byte[] FieldContent = new byte[501];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcTradingNoticeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradingNoticeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorRange");
        a.add("InvestorID");
        a.add("SequenceSeries");
        a.add("UserID");
        a.add("SendTime");
        a.add("SequenceNo");
        a.add("FieldContent");
        a.add("InvestUnitID");
        return a;
    }
};
