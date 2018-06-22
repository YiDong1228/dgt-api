package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryLoginForbiddenIPField extends Structure {
    public byte[] IPAddress = new byte[16];

    public static class ByReference extends CThostFtdcQryLoginForbiddenIPField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryLoginForbiddenIPField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("IPAddress");
        return a;
    }
};
