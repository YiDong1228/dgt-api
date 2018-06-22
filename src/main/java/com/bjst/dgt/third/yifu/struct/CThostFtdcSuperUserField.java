package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSuperUserField extends Structure {
    public byte[] UserID = new byte[16];
    public byte[] UserName = new byte[81];
    public byte[] Password = new byte[41];
    public int IsActive;

    public static class ByReference extends CThostFtdcSuperUserField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSuperUserField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("UserID");
        a.add("UserName");
        a.add("Password");
        a.add("IsActive");
        return a;
    }
};
