package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryTradingAccountField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte BizType;
    public byte[] AccountID = new byte[13];

    public static class ByReference extends CThostFtdcQryTradingAccountField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryTradingAccountField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("CurrencyID");
        a.add("BizType");
        a.add("AccountID");
        return a;
    }
};
