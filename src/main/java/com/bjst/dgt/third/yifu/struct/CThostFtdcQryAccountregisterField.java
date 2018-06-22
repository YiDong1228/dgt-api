package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryAccountregisterField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] AccountID = new byte[13];
    public byte[] BankID = new byte[4];
    public byte[] BankBranchID = new byte[5];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcQryAccountregisterField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryAccountregisterField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("AccountID");
        a.add("BankID");
        a.add("BankBranchID");
        a.add("CurrencyID");
        return a;
    }
};
