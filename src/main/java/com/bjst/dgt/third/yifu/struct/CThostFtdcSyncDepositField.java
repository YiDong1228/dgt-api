package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncDepositField extends Structure {
    public byte[] DepositSeqNo = new byte[15];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public double Deposit;
    public int IsForce;
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcSyncDepositField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncDepositField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("DepositSeqNo");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("Deposit");
        a.add("IsForce");
        a.add("CurrencyID");
        return a;
    }
};
