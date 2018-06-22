package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] BrokerAbbr = new byte[9];
    public byte[] BrokerName = new byte[81];
    public int IsActive;

    public static class ByReference extends CThostFtdcBrokerField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("BrokerAbbr");
        a.add("BrokerName");
        a.add("IsActive");
        return a;
    }
};
