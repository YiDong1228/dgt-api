package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] UserName = new byte[81];
    public byte UserType;
    public int IsActive;
    public int IsUsingOTP;
    public int IsAuthForce;

    public static class ByReference extends CThostFtdcBrokerUserField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserName");
        a.add("UserType");
        a.add("IsActive");
        a.add("IsUsingOTP");
        a.add("IsAuthForce");
        return a;
    }
};
