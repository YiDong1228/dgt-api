package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryBrokerUserField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];

    public static class ByReference extends CThostFtdcQryBrokerUserField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryBrokerUserField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        return a;
    }
};
