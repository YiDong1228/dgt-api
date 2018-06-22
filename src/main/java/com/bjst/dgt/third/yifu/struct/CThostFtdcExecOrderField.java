package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExecOrderField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExecOrderRef = new byte[13];
    public byte[] UserID = new byte[16];
    public int Volume;
    public int RequestID;
    public byte[] BusinessUnit = new byte[21];
    public byte OffsetFlag;
    public byte HedgeFlag;
    public byte ActionType;
    public byte PosiDirection;
    public byte ReservePositionFlag;
    public byte CloseFlag;
    public byte[] ExecOrderLocalID = new byte[13];
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
    public byte[] ExecOrderSysID = new byte[21];
    public byte[] InsertDate = new byte[9];
    public byte[] InsertTime = new byte[9];
    public byte[] CancelTime = new byte[9];
    public byte ExecResult;
    public byte[] ClearingPartID = new byte[11];
    public int SequenceNo;
    public int FrontID;
    public int SessionID;
    public byte[] UserProductInfo = new byte[11];
    public byte[] StatusMsg = new byte[81];
    public byte[] ActiveUserID = new byte[16];
    public int BrokerExecOrderSeq;
    public byte[] BranchID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExecOrderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExecOrderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("ExecOrderRef");
        a.add("UserID");
        a.add("Volume");
        a.add("RequestID");
        a.add("BusinessUnit");
        a.add("OffsetFlag");
        a.add("HedgeFlag");
        a.add("ActionType");
        a.add("PosiDirection");
        a.add("ReservePositionFlag");
        a.add("CloseFlag");
        a.add("ExecOrderLocalID");
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
        a.add("ExecOrderSysID");
        a.add("InsertDate");
        a.add("InsertTime");
        a.add("CancelTime");
        a.add("ExecResult");
        a.add("ClearingPartID");
        a.add("SequenceNo");
        a.add("FrontID");
        a.add("SessionID");
        a.add("UserProductInfo");
        a.add("StatusMsg");
        a.add("ActiveUserID");
        a.add("BrokerExecOrderSeq");
        a.add("BranchID");
        a.add("InvestUnitID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
