package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCurrTransferIdentityField extends Structure {
    public int IdentityID;

    public static class ByReference extends CThostFtdcCurrTransferIdentityField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCurrTransferIdentityField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("IdentityID");
        return a;
    }
};
