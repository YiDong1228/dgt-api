package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcUserIPField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] IPAddress = new byte[16];
    public byte[] IPMask = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcUserIPField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcUserIPField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("UserID");
        a.add("IPAddress");
        a.add("IPMask");
        a.add("MacAddress");
        return a;
    }
};
