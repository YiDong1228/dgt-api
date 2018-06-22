package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcErrExecOrderActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int ExecOrderActionRef;
    public byte[] ExecOrderRef = new byte[13];
    public int RequestID;
    public int FrontID;
    public int SessionID;
    public byte[] ExchangeID = new byte[9];
    public byte[] ExecOrderSysID = new byte[21];
    public byte ActionFlag;
    public byte[] UserID = new byte[16];
    public byte[] InstrumentID = new byte[31];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcErrExecOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcErrExecOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ExecOrderActionRef");
        a.add("ExecOrderRef");
        a.add("RequestID");
        a.add("FrontID");
        a.add("SessionID");
        a.add("ExchangeID");
        a.add("ExecOrderSysID");
        a.add("ActionFlag");
        a.add("UserID");
        a.add("InstrumentID");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
