package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcParkedOrderActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int OrderActionRef;
    public byte[] OrderRef = new byte[13];
    public int RequestID;
    public int FrontID;
    public int SessionID;
    public byte[] ExchangeID = new byte[9];
    public byte[] OrderSysID = new byte[21];
    public byte ActionFlag;
    public double LimitPrice;
    public int VolumeChange;
    public byte[] UserID = new byte[16];
    public byte[] InstrumentID = new byte[31];
    public byte[] ParkedOrderActionID = new byte[13];
    public byte UserType;
    public byte Status;
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcParkedOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcParkedOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OrderActionRef");
        a.add("OrderRef");
        a.add("RequestID");
        a.add("FrontID");
        a.add("SessionID");
        a.add("ExchangeID");
        a.add("OrderSysID");
        a.add("ActionFlag");
        a.add("LimitPrice");
        a.add("VolumeChange");
        a.add("UserID");
        a.add("InstrumentID");
        a.add("ParkedOrderActionID");
        a.add("UserType");
        a.add("Status");
        a.add("ErrorID");
        a.add("ErrorMsg");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
