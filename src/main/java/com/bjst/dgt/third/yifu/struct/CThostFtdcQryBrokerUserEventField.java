package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryBrokerUserEventField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte UserEventType;

    public static class ByReference extends CThostFtdcQryBrokerUserEventField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryBrokerUserEventField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserEventType");
        return a;
    }
};
