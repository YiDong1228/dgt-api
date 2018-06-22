package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerUserRightAssignField extends Structure {
    public byte[] BrokerID = new byte[11];
    public int DRIdentityID;
    public int Tradeable;

    public static class ByReference extends CThostFtdcBrokerUserRightAssignField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerUserRightAssignField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("DRIdentityID");
        a.add("Tradeable");
        return a;
    }
};
