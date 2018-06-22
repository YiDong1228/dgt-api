package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcPartBrokerField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public int IsActive;

    public static class ByReference extends CThostFtdcPartBrokerField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcPartBrokerField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("IsActive");
        return a;
    }
};
