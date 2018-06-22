package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncingInvestorGroupField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorGroupID = new byte[13];
    public byte[] InvestorGroupName = new byte[41];

    public static class ByReference extends CThostFtdcSyncingInvestorGroupField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncingInvestorGroupField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorGroupID");
        a.add("InvestorGroupName");
        return a;
    }
};
