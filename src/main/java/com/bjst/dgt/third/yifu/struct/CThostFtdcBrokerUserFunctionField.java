package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserFunctionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte BrokerFunctionCode;

    public static class ByReference extends CThostFtdcBrokerUserFunctionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserFunctionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("BrokerFunctionCode");
        return a;
    }
};
