package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcRspInfoField extends Structure {
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcRspInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcRspInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
