package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcProductField extends Structure {
    public byte[] ProductID = new byte[31];
    public byte[] ProductName = new byte[21];
    public byte[] ExchangeID = new byte[9];
    public byte ProductClass;
    public int VolumeMultiple;
    public double PriceTick;
    public int MaxMarketOrderVolume;
    public int MinMarketOrderVolume;
    public int MaxLimitOrderVolume;
    public int MinLimitOrderVolume;
    public byte PositionType;
    public byte PositionDateType;
    public byte CloseDealType;
    public byte[] TradeCurrencyID = new byte[4];
    public byte MortgageFundUseRange;
    public byte[] ExchangeProductID = new byte[31];
    public double UnderlyingMultiple;

    public static class ByReference extends CThostFtdcProductField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcProductField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ProductID");
        a.add("ProductName");
        a.add("ExchangeID");
        a.add("ProductClass");
        a.add("VolumeMultiple");
        a.add("PriceTick");
        a.add("MaxMarketOrderVolume");
        a.add("MinMarketOrderVolume");
        a.add("MaxLimitOrderVolume");
        a.add("MinLimitOrderVolume");
        a.add("PositionType");
        a.add("PositionDateType");
        a.add("CloseDealType");
        a.add("TradeCurrencyID");
        a.add("MortgageFundUseRange");
        a.add("ExchangeProductID");
        a.add("UnderlyingMultiple");
        return a;
    }
};
