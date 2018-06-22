package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcProductExchRateField extends Structure {
    public byte[] ProductID = new byte[31];
    public byte[] QuoteCurrencyID = new byte[4];
    public double ExchangeRate;
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcProductExchRateField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcProductExchRateField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ProductID");
        a.add("QuoteCurrencyID");
        a.add("ExchangeRate");
        a.add("ExchangeID");
        return a;
    }
};
