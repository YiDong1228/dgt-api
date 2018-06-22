package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeTradeField extends Structure {
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
    public byte TradeSource;

    public static class ByReference extends CThostFtdcExchangeTradeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeTradeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
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
        a.add("TradeSource");
        return a;
    }
};
