package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncFundMortgageField extends Structure {
    public byte[] MortgageSeqNo = new byte[15];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] FromCurrencyID = new byte[4];
    public double MortgageAmount;
    public byte[] ToCurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcSyncFundMortgageField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncFundMortgageField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("MortgageSeqNo");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("FromCurrencyID");
        a.add("MortgageAmount");
        a.add("ToCurrencyID");
        return a;
    }
};
