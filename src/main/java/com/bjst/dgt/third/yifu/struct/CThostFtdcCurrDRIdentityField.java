package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCurrDRIdentityField extends Structure {
    public int DRIdentityID;

    public static class ByReference extends CThostFtdcCurrDRIdentityField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCurrDRIdentityField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("DRIdentityID");
        return a;
    }
};
