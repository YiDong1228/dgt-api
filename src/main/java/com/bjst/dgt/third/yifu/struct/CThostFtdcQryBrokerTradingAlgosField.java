package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryBrokerTradingAlgosField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public byte[] InstrumentID = new byte[31];

    public static class ByReference extends CThostFtdcQryBrokerTradingAlgosField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryBrokerTradingAlgosField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ExchangeID");
        a.add("InstrumentID");
        return a;
    }
};
