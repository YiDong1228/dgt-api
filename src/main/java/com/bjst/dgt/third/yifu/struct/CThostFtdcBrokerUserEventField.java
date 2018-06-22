package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserEventField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte UserEventType;
    public int EventSequenceNo;
    public byte[] EventDate = new byte[9];
    public byte[] EventTime = new byte[9];
    public byte[] UserEventInfo = new byte[1025];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];

    public static class ByReference extends CThostFtdcBrokerUserEventField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserEventField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserEventType");
        a.add("EventSequenceNo");
        a.add("EventDate");
        a.add("EventTime");
        a.add("UserEventInfo");
        a.add("InvestorID");
        a.add("InstrumentID");
        return a;
    }
};
