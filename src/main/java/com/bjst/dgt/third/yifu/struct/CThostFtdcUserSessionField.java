package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcUserSessionField extends Structure {
    public int FrontID;
    public int SessionID;
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] LoginDate = new byte[9];
    public byte[] LoginTime = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] UserProductInfo = new byte[11];
    public byte[] InterfaceProductInfo = new byte[11];
    public byte[] ProtocolInfo = new byte[11];
    public byte[] MacAddress = new byte[21];
    public byte[] LoginRemark = new byte[36];

    public static class ByReference extends CThostFtdcUserSessionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcUserSessionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FrontID");
        a.add("SessionID");
        a.add("BrokerID");
        a.add("UserID");
        a.add("LoginDate");
        a.add("LoginTime");
        a.add("IPAddress");
        a.add("UserProductInfo");
        a.add("InterfaceProductInfo");
        a.add("ProtocolInfo");
        a.add("MacAddress");
        a.add("LoginRemark");
        return a;
    }
};
