package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorWithdrawAlgorithmField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte InvestorRange;
    public byte[] InvestorID = new byte[13];
    public double UsingRatio;
    public byte[] CurrencyID = new byte[4];
    public double FundMortgageRatio;

    public static class ByReference extends CThostFtdcInvestorWithdrawAlgorithmField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorWithdrawAlgorithmField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorRange");
        a.add("InvestorID");
        a.add("UsingRatio");
        a.add("CurrencyID");
        a.add("FundMortgageRatio");
        return a;
    }
};
