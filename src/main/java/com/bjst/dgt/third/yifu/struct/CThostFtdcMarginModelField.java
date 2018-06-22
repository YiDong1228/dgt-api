package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMarginModelField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] MarginModelID = new byte[13];
    public byte[] MarginModelName = new byte[161];

    public static class ByReference extends CThostFtdcMarginModelField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMarginModelField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("MarginModelID");
        a.add("MarginModelName");
        return a;
    }
};
