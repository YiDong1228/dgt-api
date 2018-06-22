package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncStatusField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte DataSyncStatus;

    public static class ByReference extends CThostFtdcSyncStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("DataSyncStatus");
        return a;
    }
};
