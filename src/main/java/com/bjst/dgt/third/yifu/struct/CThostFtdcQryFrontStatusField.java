package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryFrontStatusField extends Structure {
    public int FrontID;

    public static class ByReference extends CThostFtdcQryFrontStatusField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryFrontStatusField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FrontID");
        return a;
    }
};
