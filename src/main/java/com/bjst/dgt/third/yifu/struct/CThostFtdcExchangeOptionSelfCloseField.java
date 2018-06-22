package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeOptionSelfCloseField extends Structure {
    public int Volume;
    public int RequestID;
    public byte[] BusinessUnit = new byte[21];
    public byte HedgeFlag;
    public byte OptSelfCloseFlag;
    public byte[] OptionSelfCloseLocalID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte OrderSubmitStatus;
    public int NotifySequence;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public byte[] OptionSelfCloseSysID = new byte[21];
    public byte[] InsertDate = new byte[9];
    public byte[] InsertTime = new byte[9];
    public byte[] CancelTime = new byte[9];
    public byte ExecResult;
    public byte[] ClearingPartID = new byte[11];
    public int SequenceNo;
    public byte[] BranchID = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeOptionSelfCloseField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeOptionSelfCloseField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("Volume");
        a.add("RequestID");
        a.add("BusinessUnit");
        a.add("HedgeFlag");
        a.add("OptSelfCloseFlag");
        a.add("OptionSelfCloseLocalID");
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("ExchangeInstID");
        a.add("TraderID");
        a.add("InstallID");
        a.add("OrderSubmitStatus");
        a.add("NotifySequence");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("OptionSelfCloseSysID");
        a.add("InsertDate");
        a.add("InsertTime");
        a.add("CancelTime");
        a.add("ExecResult");
        a.add("ClearingPartID");
        a.add("SequenceNo");
        a.add("BranchID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
