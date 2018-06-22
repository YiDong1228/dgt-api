package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcLoginInfoField extends Structure {
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
    public byte[] SystemName = new byte[41];
    public byte[] PasswordDeprecated = new byte[41];
    public byte[] MaxOrderRef = new byte[13];
    public byte[] SHFETime = new byte[9];
    public byte[] DCETime = new byte[9];
    public byte[] CZCETime = new byte[9];
    public byte[] FFEXTime = new byte[9];
    public byte[] MacAddress = new byte[21];
    public byte[] OneTimePassword = new byte[41];
    public byte[] INETime = new byte[9];
    public int IsQryControl;
    public byte[] LoginRemark = new byte[36];
    public byte[] Password = new byte[41];

    public static class ByReference extends CThostFtdcLoginInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcLoginInfoField implements Structure.ByValue {}

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
        a.add("SystemName");
        a.add("PasswordDeprecated");
        a.add("MaxOrderRef");
        a.add("SHFETime");
        a.add("DCETime");
        a.add("CZCETime");
        a.add("FFEXTime");
        a.add("MacAddress");
        a.add("OneTimePassword");
        a.add("INETime");
        a.add("IsQryControl");
        a.add("LoginRemark");
        a.add("Password");
        return a;
    }
};
