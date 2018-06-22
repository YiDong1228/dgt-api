package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeOrderField extends Structure {
    public byte OrderPriceType;
    public byte Direction;
    public byte[] CombOffsetFlag = new byte[5];
    public byte[] CombHedgeFlag = new byte[5];
    public double LimitPrice;
    public int VolumeTotalOriginal;
    public byte TimeCondition;
    public byte[] GTDDate = new byte[9];
    public byte VolumeCondition;
    public int MinVolume;
    public byte ContingentCondition;
    public double StopPrice;
    public byte ForceCloseReason;
    public int IsAutoSuspend;
    public byte[] BusinessUnit = new byte[21];
    public int RequestID;
    public byte[] OrderLocalID = new byte[13];
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
    public byte[] OrderSysID = new byte[21];
    public byte OrderSource;
    public byte OrderStatus;
    public byte OrderType;
    public int VolumeTraded;
    public int VolumeTotal;
    public byte[] InsertDate = new byte[9];
    public byte[] InsertTime = new byte[9];
    public byte[] ActiveTime = new byte[9];
    public byte[] SuspendTime = new byte[9];
    public byte[] UpdateTime = new byte[9];
    public byte[] CancelTime = new byte[9];
    public byte[] ActiveTraderID = new byte[21];
    public byte[] ClearingPartID = new byte[11];
    public int SequenceNo;
    public byte[] BranchID = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeOrderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeOrderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("OrderPriceType");
        a.add("Direction");
        a.add("CombOffsetFlag");
        a.add("CombHedgeFlag");
        a.add("LimitPrice");
        a.add("VolumeTotalOriginal");
        a.add("TimeCondition");
        a.add("GTDDate");
        a.add("VolumeCondition");
        a.add("MinVolume");
        a.add("ContingentCondition");
        a.add("StopPrice");
        a.add("ForceCloseReason");
        a.add("IsAutoSuspend");
        a.add("BusinessUnit");
        a.add("RequestID");
        a.add("OrderLocalID");
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
        a.add("OrderSysID");
        a.add("OrderSource");
        a.add("OrderStatus");
        a.add("OrderType");
        a.add("VolumeTraded");
        a.add("VolumeTotal");
        a.add("InsertDate");
        a.add("InsertTime");
        a.add("ActiveTime");
        a.add("SuspendTime");
        a.add("UpdateTime");
        a.add("CancelTime");
        a.add("ActiveTraderID");
        a.add("ClearingPartID");
        a.add("SequenceNo");
        a.add("BranchID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
