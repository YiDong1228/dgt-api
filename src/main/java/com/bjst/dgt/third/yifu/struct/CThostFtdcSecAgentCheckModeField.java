package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSecAgentCheckModeField extends Structure {
    public byte[] InvestorID = new byte[13];
    public byte[] BrokerID = new byte[11];
    public byte[] CurrencyID = new byte[4];
    public byte[] BrokerSecAgentID = new byte[13];
    public int CheckSelfAccount;

    public static class ByReference extends CThostFtdcSecAgentCheckModeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSecAgentCheckModeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InvestorID");
        a.add("BrokerID");
        a.add("CurrencyID");
        a.add("BrokerSecAgentID");
        a.add("CheckSelfAccount");
        return a;
    }
};
