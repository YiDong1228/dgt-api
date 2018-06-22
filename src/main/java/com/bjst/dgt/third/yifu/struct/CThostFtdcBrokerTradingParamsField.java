package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerTradingParamsField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte MarginPriceType;
    public byte Algorithm;
    public byte AvailIncludeCloseProfit;
    public byte[] CurrencyID = new byte[4];
    public byte OptionRoyaltyPriceType;
    public byte[] AccountID = new byte[13];

    public static class ByReference extends CThostFtdcBrokerTradingParamsField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerTradingParamsField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("MarginPriceType");
        a.add("Algorithm");
        a.add("AvailIncludeCloseProfit");
        a.add("CurrencyID");
        a.add("OptionRoyaltyPriceType");
        a.add("AccountID");
        return a;
    }
};
