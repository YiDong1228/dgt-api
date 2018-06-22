package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcManualSyncBrokerUserOTPField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte OTPType;
    public byte[] FirstOTP = new byte[41];
    public byte[] SecondOTP = new byte[41];

    public static class ByReference extends CThostFtdcManualSyncBrokerUserOTPField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcManualSyncBrokerUserOTPField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("OTPType");
        a.add("FirstOTP");
        a.add("SecondOTP");
        return a;
    }
};
