package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryExchangeMarginRateAdjustField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InstrumentID = new byte[31];
    public byte HedgeFlag;

    public static class ByReference extends CThostFtdcQryExchangeMarginRateAdjustField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryExchangeMarginRateAdjustField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InstrumentID");
        a.add("HedgeFlag");
        return a;
    }
};
