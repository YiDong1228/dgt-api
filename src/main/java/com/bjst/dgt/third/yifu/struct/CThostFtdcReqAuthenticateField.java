package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReqAuthenticateField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] UserProductInfo = new byte[11];
    public byte[] AuthCode = new byte[17];

    public static class ByReference extends CThostFtdcReqAuthenticateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReqAuthenticateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserProductInfo");
        a.add("AuthCode");
        return a;
    }
};
