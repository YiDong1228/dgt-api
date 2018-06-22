package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReqUserLoginField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] Password = new byte[41];
    public byte[] UserProductInfo = new byte[11];
    public byte[] InterfaceProductInfo = new byte[11];
    public byte[] ProtocolInfo = new byte[11];
    public byte[] MacAddress = new byte[21];
    public byte[] OneTimePassword = new byte[41];
    public byte[] ClientIPAddress = new byte[16];
    public byte[] LoginRemark = new byte[36];

    public static class ByReference extends CThostFtdcReqUserLoginField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReqUserLoginField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("BrokerID");
        a.add("UserID");
        a.add("Password");
        a.add("UserProductInfo");
        a.add("InterfaceProductInfo");
        a.add("ProtocolInfo");
        a.add("MacAddress");
        a.add("OneTimePassword");
        a.add("ClientIPAddress");
        a.add("LoginRemark");
        return a;
    }
};
