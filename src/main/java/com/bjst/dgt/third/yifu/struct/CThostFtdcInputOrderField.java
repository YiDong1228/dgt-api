package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputOrderField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] OrderRef = new byte[13];
    public byte[] UserID = new byte[16];
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
    public int UserForceClose;
    public int IsSwapOrder;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] ClientID = new byte[11];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcInputOrderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputOrderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("OrderRef");
        a.add("UserID");
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
        a.add("UserForceClose");
        a.add("IsSwapOrder");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("ClientID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
