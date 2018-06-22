package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorAccountField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcInvestorAccountField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorAccountField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("AccountID");
        a.add("CurrencyID");
        return a;
    }
};
