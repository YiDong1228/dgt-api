package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcRspUserLogin2Field extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] LoginTime = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] UserID = new byte[16];
    public byte[] SystemName = new byte[41];
    public int FrontID;
    public int SessionID;
    public byte[] MaxOrderRef = new byte[13];
    public byte[] SHFETime = new byte[9];
    public byte[] DCETime = new byte[9];
    public byte[] CZCETime = new byte[9];
    public byte[] FFEXTime = new byte[9];
    public byte[] INETime = new byte[9];
    public byte[] RandomString = new byte[17];

    public static class ByReference extends CThostFtdcRspUserLogin2Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcRspUserLogin2Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("LoginTime");
        a.add("BrokerID");
        a.add("UserID");
        a.add("SystemName");
        a.add("FrontID");
        a.add("SessionID");
        a.add("MaxOrderRef");
        a.add("SHFETime");
        a.add("DCETime");
        a.add("CZCETime");
        a.add("FFEXTime");
        a.add("INETime");
        a.add("RandomString");
        return a;
    }
};
