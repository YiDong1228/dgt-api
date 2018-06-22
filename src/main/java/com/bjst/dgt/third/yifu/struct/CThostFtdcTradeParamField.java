package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradeParamField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte TradeParamID;
    public byte[] TradeParamValue = new byte[256];
    public byte[] Memo = new byte[161];

    public static class ByReference extends CThostFtdcTradeParamField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradeParamField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("TradeParamID");
        a.add("TradeParamValue");
        a.add("Memo");
        return a;
    }
};
