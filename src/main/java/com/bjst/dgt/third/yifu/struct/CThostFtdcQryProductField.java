package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryProductField extends Structure {
    public byte[] ProductID = new byte[31];
    public byte ProductClass;
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryProductField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryProductField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ProductID");
        a.add("ProductClass");
        a.add("ExchangeID");
        return a;
    }
};
