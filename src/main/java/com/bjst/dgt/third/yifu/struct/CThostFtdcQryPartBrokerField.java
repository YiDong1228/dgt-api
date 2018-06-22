package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryPartBrokerField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] ParticipantID = new byte[11];

    public static class ByReference extends CThostFtdcQryPartBrokerField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryPartBrokerField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("BrokerID");
        a.add("ParticipantID");
        return a;
    }
};
