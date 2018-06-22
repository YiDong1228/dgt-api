package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcLogoutAllField extends Structure {
    public int FrontID;
    public int SessionID;
    public byte[] SystemName = new byte[41];

    public static class ByReference extends CThostFtdcLogoutAllField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcLogoutAllField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FrontID");
        a.add("SessionID");
        a.add("SystemName");
        return a;
    }
};
