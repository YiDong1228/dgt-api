package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySuperUserFunctionField extends Structure {
    public byte[] UserID = new byte[16];

    public static class ByReference extends CThostFtdcQrySuperUserFunctionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySuperUserFunctionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("UserID");
        return a;
    }
};
