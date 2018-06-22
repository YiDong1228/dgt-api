package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySyncStatusField extends Structure {
    public byte[] TradingDay = new byte[9];

    public static class ByReference extends CThostFtdcQrySyncStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySyncStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        return a;
    }
};
