package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryUserSessionField extends Structure {
    public int FrontID;
    public int SessionID;
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];

    public static class ByReference extends CThostFtdcQryUserSessionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryUserSessionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FrontID");
        a.add("SessionID");
        a.add("BrokerID");
        a.add("UserID");
        return a;
    }
};
