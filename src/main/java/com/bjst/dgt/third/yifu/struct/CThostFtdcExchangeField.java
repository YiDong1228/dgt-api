package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ExchangeName = new byte[61];
    public byte ExchangeProperty;

    public static class ByReference extends CThostFtdcExchangeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ExchangeName");
        a.add("ExchangeProperty");
        return a;
    }
};
