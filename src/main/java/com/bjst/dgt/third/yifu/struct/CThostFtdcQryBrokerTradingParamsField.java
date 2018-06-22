package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryBrokerTradingParamsField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] AccountID = new byte[13];

    public static class ByReference extends CThostFtdcQryBrokerTradingParamsField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryBrokerTradingParamsField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("CurrencyID");
        a.add("AccountID");
        return a;
    }
};
