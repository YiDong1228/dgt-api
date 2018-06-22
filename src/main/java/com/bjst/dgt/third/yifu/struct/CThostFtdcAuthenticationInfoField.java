package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcAuthenticationInfoField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] UserProductInfo = new byte[11];
    public byte[] AuthInfo = new byte[129];
    public int IsResult;

    public static class ByReference extends CThostFtdcAuthenticationInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcAuthenticationInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserProductInfo");
        a.add("AuthInfo");
        a.add("IsResult");
        return a;
    }
};
