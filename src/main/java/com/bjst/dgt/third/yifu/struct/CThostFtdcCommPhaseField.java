package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCommPhaseField extends Structure {
    public byte[] TradingDay = new byte[9];
    public short CommPhaseNo;
    public byte[] SystemID = new byte[21];

    public static class ByReference extends CThostFtdcCommPhaseField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCommPhaseField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("CommPhaseNo");
        a.add("SystemID");
        return a;
    }
};
