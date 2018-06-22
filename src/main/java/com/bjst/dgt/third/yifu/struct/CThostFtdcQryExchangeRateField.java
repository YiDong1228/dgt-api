package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryExchangeRateField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] FromCurrencyID = new byte[4];
    public byte[] ToCurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcQryExchangeRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryExchangeRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("FromCurrencyID");
        a.add("ToCurrencyID");
        return a;
    }
};
