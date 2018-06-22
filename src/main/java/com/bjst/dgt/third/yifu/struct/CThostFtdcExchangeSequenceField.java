package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeSequenceField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public int SequenceNo;
    public byte MarketStatus;

    public static class ByReference extends CThostFtdcExchangeSequenceField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeSequenceField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("SequenceNo");
        a.add("MarketStatus");
        return a;
    }
};
