package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryTradingCodeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] ClientID = new byte[11];
    public byte ClientIDType;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcQryTradingCodeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryTradingCodeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ExchangeID");
        a.add("ClientID");
        a.add("ClientIDType");
        a.add("InvestUnitID");
        return a;
    }
};
