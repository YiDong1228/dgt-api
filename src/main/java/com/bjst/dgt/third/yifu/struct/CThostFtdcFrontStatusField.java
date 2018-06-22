package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcFrontStatusField extends Structure {
    public int FrontID;
    public byte[] LastReportDate = new byte[9];
    public byte[] LastReportTime = new byte[9];
    public int IsActive;

    public static class ByReference extends CThostFtdcFrontStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcFrontStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FrontID");
        a.add("LastReportDate");
        a.add("LastReportTime");
        a.add("IsActive");
        return a;
    }
};
