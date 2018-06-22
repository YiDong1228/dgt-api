package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradingCodeField extends Structure {
    public byte[] InvestorID = new byte[13];
    public byte[] BrokerID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public byte[] ClientID = new byte[11];
    public int IsActive;
    public byte ClientIDType;
    public byte[] BranchID = new byte[9];
    public byte BizType;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcTradingCodeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradingCodeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InvestorID");
        a.add("BrokerID");
        a.add("ExchangeID");
        a.add("ClientID");
        a.add("IsActive");
        a.add("ClientIDType");
        a.add("BranchID");
        a.add("BizType");
        a.add("InvestUnitID");
        return a;
    }
};
