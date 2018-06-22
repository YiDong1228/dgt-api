package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeCombActionField extends Structure {
    public byte Direction;
    public int Volume;
    public byte CombDirection;
    public byte HedgeFlag;
    public byte[] ActionLocalID = new byte[13];
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte ActionStatus;
    public int NotifySequence;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public int SequenceNo;
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];
    public byte[] ComTradeID = new byte[21];
    public byte[] BranchID = new byte[9];

    public static class ByReference extends CThostFtdcExchangeCombActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeCombActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("Direction");
        a.add("Volume");
        a.add("CombDirection");
        a.add("HedgeFlag");
        a.add("ActionLocalID");
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("ExchangeInstID");
        a.add("TraderID");
        a.add("InstallID");
        a.add("ActionStatus");
        a.add("NotifySequence");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("SequenceNo");
        a.add("IPAddress");
        a.add("MacAddress");
        a.add("ComTradeID");
        a.add("BranchID");
        return a;
    }
};
