package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserPasswordField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] Password = new byte[41];
    public byte[] LastUpdateTime = new byte[17];
    public byte[] LastLoginTime = new byte[17];
    public byte[] ExpireDate = new byte[9];
    public byte[] WeakExpireDate = new byte[9];

    public static class ByReference extends CThostFtdcBrokerUserPasswordField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserPasswordField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("Password");
        a.add("LastUpdateTime");
        a.add("LastLoginTime");
        a.add("ExpireDate");
        a.add("WeakExpireDate");
        return a;
    }
};
