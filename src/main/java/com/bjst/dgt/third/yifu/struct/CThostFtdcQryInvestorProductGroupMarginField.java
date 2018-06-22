package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryInvestorProductGroupMarginField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ProductGroupID = new byte[31];
    public byte HedgeFlag;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQryInvestorProductGroupMarginField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryInvestorProductGroupMarginField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ProductGroupID");
        a.add("HedgeFlag");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
