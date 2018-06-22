package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestUnitField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InvestUnitID = new byte[17];
    public byte[] InvestorUnitName = new byte[81];
    public byte[] InvestorGroupID = new byte[13];
    public byte[] CommModelID = new byte[13];
    public byte[] MarginModelID = new byte[13];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcInvestUnitField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestUnitField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InvestUnitID");
        a.add("InvestorUnitName");
        a.add("InvestorGroupID");
        a.add("CommModelID");
        a.add("MarginModelID");
        a.add("AccountID");
        a.add("CurrencyID");
        return a;
    }
};
