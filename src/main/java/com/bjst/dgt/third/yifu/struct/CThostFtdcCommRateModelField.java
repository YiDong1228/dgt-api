package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCommRateModelField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] CommModelID = new byte[13];
    public byte[] CommModelName = new byte[161];

    public static class ByReference extends CThostFtdcCommRateModelField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCommRateModelField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("CommModelID");
        a.add("CommModelName");
        return a;
    }
};
