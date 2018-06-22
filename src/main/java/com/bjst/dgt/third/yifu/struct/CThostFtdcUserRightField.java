package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcUserRightField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte UserRightType;
    public int IsForbidden;

    public static class ByReference extends CThostFtdcUserRightField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcUserRightField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("UserRightType");
        a.add("IsForbidden");
        return a;
    }
};
