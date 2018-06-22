package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeExecOrderActionField extends Structure {
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
    public byte[] BranchID = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeExecOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeExecOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
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
        a.add("BranchID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
