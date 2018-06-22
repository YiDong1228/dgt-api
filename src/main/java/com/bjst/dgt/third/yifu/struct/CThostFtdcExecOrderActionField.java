package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExecOrderActionField extends Structure {
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
    public byte[] ActionDate = new byte[9];
    public byte[] ActionTime = new byte[9];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte[] ExecOrderLocalID = new byte[13];
    public byte[] ActionLocalID = new byte[13];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] BusinessUnit = new byte[21];
    public byte OrderActionStatus;
    public byte[] UserID = new byte[16];
    public byte ActionType;
    public byte[] StatusMsg = new byte[81];
    public byte[] InstrumentID = new byte[31];
    public byte[] BranchID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExecOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExecOrderActionField implements Structure.ByValue {}

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
        a.add("ActionDate");
        a.add("ActionTime");
        a.add("TraderID");
        a.add("InstallID");
        a.add("ExecOrderLocalID");
        a.add("ActionLocalID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("BusinessUnit");
        a.add("OrderActionStatus");
        a.add("UserID");
        a.add("ActionType");
        a.add("StatusMsg");
        a.add("InstrumentID");
        a.add("BranchID");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
