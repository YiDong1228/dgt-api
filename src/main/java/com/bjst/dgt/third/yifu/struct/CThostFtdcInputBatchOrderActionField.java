package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputBatchOrderActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int OrderActionRef;
    public int RequestID;
    public int FrontID;
    public int SessionID;
    public byte[] ExchangeID = new byte[9];
    public byte[] UserID = new byte[16];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcInputBatchOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputBatchOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OrderActionRef");
        a.add("RequestID");
        a.add("FrontID");
        a.add("SessionID");
        a.add("ExchangeID");
        a.add("UserID");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
