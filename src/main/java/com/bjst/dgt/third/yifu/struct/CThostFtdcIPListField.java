package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcIPListField extends Structure {
    public byte[] IPAddress = new byte[16];
    public int IsWhite;

    public static class ByReference extends CThostFtdcIPListField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcIPListField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("IPAddress");
        a.add("IsWhite");
        return a;
    }
};
