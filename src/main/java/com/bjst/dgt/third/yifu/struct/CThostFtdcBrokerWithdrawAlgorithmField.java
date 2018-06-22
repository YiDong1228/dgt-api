package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerWithdrawAlgorithmField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte WithdrawAlgorithm;
    public double UsingRatio;
    public byte IncludeCloseProfit;
    public byte AllWithoutTrade;
    public byte AvailIncludeCloseProfit;
    public int IsBrokerUserEvent;
    public byte[] CurrencyID = new byte[4];
    public double FundMortgageRatio;
    public byte BalanceAlgorithm;

    public static class ByReference extends CThostFtdcBrokerWithdrawAlgorithmField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerWithdrawAlgorithmField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("WithdrawAlgorithm");
        a.add("UsingRatio");
        a.add("IncludeCloseProfit");
        a.add("AllWithoutTrade");
        a.add("AvailIncludeCloseProfit");
        a.add("IsBrokerUserEvent");
        a.add("CurrencyID");
        a.add("FundMortgageRatio");
        a.add("BalanceAlgorithm");
        return a;
    }
};
