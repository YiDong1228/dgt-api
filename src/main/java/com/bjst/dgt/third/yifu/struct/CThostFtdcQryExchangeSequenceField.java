package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryExchangeSequenceField extends Structure {
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryExchangeSequenceField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryExchangeSequenceField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        return a;
    }
};
