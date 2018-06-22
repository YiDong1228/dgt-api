package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerTradingAlgosField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public byte[] InstrumentID = new byte[31];
    public byte HandlePositionAlgoID;
    public byte FindMarginRateAlgoID;
    public byte HandleTradingAccountAlgoID;

    public static class ByReference extends CThostFtdcBrokerTradingAlgosField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerTradingAlgosField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ExchangeID");
        a.add("InstrumentID");
        a.add("HandlePositionAlgoID");
        a.add("FindMarginRateAlgoID");
        a.add("HandleTradingAccountAlgoID");
        return a;
    }
};
