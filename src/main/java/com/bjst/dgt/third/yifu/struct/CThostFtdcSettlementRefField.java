package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSettlementRefField extends Structure {
    public byte[] TradingDay = new byte[9];
    public int SettlementID;

    public static class ByReference extends CThostFtdcSettlementRefField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSettlementRefField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("SettlementID");
        return a;
    }
};
