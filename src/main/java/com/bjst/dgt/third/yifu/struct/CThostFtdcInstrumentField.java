package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInstrumentField extends Structure {
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];
    public byte[] InstrumentName = new byte[21];
    public byte[] ExchangeInstID = new byte[31];
    public byte[] ProductID = new byte[31];
    public byte ProductClass;
    public int DeliveryYear;
    public int DeliveryMonth;
    public int MaxMarketOrderVolume;
    public int MinMarketOrderVolume;
    public int MaxLimitOrderVolume;
    public int MinLimitOrderVolume;
    public int VolumeMultiple;
    public double PriceTick;
    public byte[] CreateDate = new byte[9];
    public byte[] OpenDate = new byte[9];
    public byte[] ExpireDate = new byte[9];
    public byte[] StartDelivDate = new byte[9];
    public byte[] EndDelivDate = new byte[9];
    public byte InstLifePhase;
    public int IsTrading;
    public byte PositionType;
    public byte PositionDateType;
    public double LongMarginRatio;
    public double ShortMarginRatio;
    public byte MaxMarginSideAlgorithm;
    public byte[] UnderlyingInstrID = new byte[31];
    public double StrikePrice;
    public byte OptionsType;
    public double UnderlyingMultiple;
    public byte CombinationType;

    public static class ByReference extends CThostFtdcInstrumentField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInstrumentField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InstrumentID");
        a.add("ExchangeID");
        a.add("InstrumentName");
        a.add("ExchangeInstID");
        a.add("ProductID");
        a.add("ProductClass");
        a.add("DeliveryYear");
        a.add("DeliveryMonth");
        a.add("MaxMarketOrderVolume");
        a.add("MinMarketOrderVolume");
        a.add("MaxLimitOrderVolume");
        a.add("MinLimitOrderVolume");
        a.add("VolumeMultiple");
        a.add("PriceTick");
        a.add("CreateDate");
        a.add("OpenDate");
        a.add("ExpireDate");
        a.add("StartDelivDate");
        a.add("EndDelivDate");
        a.add("InstLifePhase");
        a.add("IsTrading");
        a.add("PositionType");
        a.add("PositionDateType");
        a.add("LongMarginRatio");
        a.add("ShortMarginRatio");
        a.add("MaxMarginSideAlgorithm");
        a.add("UnderlyingInstrID");
        a.add("StrikePrice");
        a.add("OptionsType");
        a.add("UnderlyingMultiple");
        a.add("CombinationType");
        return a;
    }
};
