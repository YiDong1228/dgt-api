package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserOTPParamField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] OTPVendorsID = new byte[2];
    public byte[] SerialNumber = new byte[17];
    public byte[] AuthKey = new byte[41];
    public int LastDrift;
    public int LastSuccess;
    public byte OTPType;

    public static class ByReference extends CThostFtdcBrokerUserOTPParamField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserOTPParamField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("OTPVendorsID");
        a.add("SerialNumber");
        a.add("AuthKey");
        a.add("LastDrift");
        a.add("LastSuccess");
        a.add("OTPType");
        return a;
    }
};
