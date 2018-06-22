package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSuperUserFunctionField extends Structure {
    public byte[] UserID = new byte[16];
    public byte FunctionCode;

    public static class ByReference extends CThostFtdcSuperUserFunctionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSuperUserFunctionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("UserID");
        a.add("FunctionCode");
        return a;
    }
};
