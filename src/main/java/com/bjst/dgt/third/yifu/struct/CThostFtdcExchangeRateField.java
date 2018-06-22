package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeRateField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] FromCurrencyID = new byte[4];
    public double FromCurrencyUnit;
    public byte[] ToCurrencyID = new byte[4];
    public double ExchangeRate;

    public static class ByReference extends CThostFtdcExchangeRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("FromCurrencyID");
        a.add("FromCurrencyUnit");
        a.add("ToCurrencyID");
        a.add("ExchangeRate");
        return a;
    }
};
