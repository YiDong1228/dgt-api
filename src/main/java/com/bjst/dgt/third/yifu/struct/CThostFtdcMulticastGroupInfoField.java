package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMulticastGroupInfoField extends Structure {
    public byte[] GroupIP = new byte[16];
    public int GroupPort;
    public byte[] SourceIP = new byte[16];

    public static class ByReference extends CThostFtdcMulticastGroupInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMulticastGroupInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("GroupIP");
        a.add("GroupPort");
        a.add("SourceIP");
        return a;
    }
};
