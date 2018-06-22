package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcUserPasswordUpdateField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] OldPassword = new byte[41];
    public byte[] NewPassword = new byte[41];

    public static class ByReference extends CThostFtdcUserPasswordUpdateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcUserPasswordUpdateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("OldPassword");
        a.add("NewPassword");
        return a;
    }
};
