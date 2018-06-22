package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcLoginForbiddenIPField extends Structure {
    public byte[] IPAddress = new byte[16];

    public static class ByReference extends CThostFtdcLoginForbiddenIPField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcLoginForbiddenIPField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("IPAddress");
        return a;
    }
};
