package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryMarginModelField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] MarginModelID = new byte[13];

    public static class ByReference extends CThostFtdcQryMarginModelField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryMarginModelField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("MarginModelID");
        return a;
    }
};
