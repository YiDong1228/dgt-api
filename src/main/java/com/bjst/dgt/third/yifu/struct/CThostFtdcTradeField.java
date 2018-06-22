package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] OrderRef = new byte[13];
    public byte[] UserID = new byte[16];
    public byte[] ExchangeID = new byte[9];
    public byte[] TradeID = new byte[21];
    public byte Direction;
    public byte[] OrderSysID = new byte[21];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte TradingRole;
    public byte[] ExchangeInstID = new byte[31];
    public byte OffsetFlag;
    public byte HedgeFlag;
    public double Price;
    public int Volume;
    public byte[] TradeDate = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte TradeType;
    public byte PriceSource;
    public byte[] TraderID = new byte[21];
    public byte[] OrderLocalID = new byte[13];
    public byte[] ClearingPartID = new byte[11];
    public byte[] BusinessUnit = new byte[21];
    public int SequenceNo;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public int BrokerOrderSeq;
    public byte TradeSource;
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcTradeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("OrderRef");
        a.add("UserID");
        a.add("ExchangeID");
        a.add("TradeID");
        a.add("Direction");
        a.add("OrderSysID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("TradingRole");
        a.add("ExchangeInstID");
        a.add("OffsetFlag");
        a.add("HedgeFlag");
        a.add("Price");
        a.add("Volume");
        a.add("TradeDate");
        a.add("TradeTime");
        a.add("TradeType");
        a.add("PriceSource");
        a.add("TraderID");
        a.add("OrderLocalID");
        a.add("ClearingPartID");
        a.add("BusinessUnit");
        a.add("SequenceNo");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("BrokerOrderSeq");
        a.add("TradeSource");
        a.add("InvestUnitID");
        return a;
    }
};
