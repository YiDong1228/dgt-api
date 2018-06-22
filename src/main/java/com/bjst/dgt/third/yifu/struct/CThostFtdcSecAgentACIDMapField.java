package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSecAgentACIDMapField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] BrokerSecAgentID = new byte[13];

    public static class ByReference extends CThostFtdcSecAgentACIDMapField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSecAgentACIDMapField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("BrokerSecAgentID");
        return a;
    }
};
