package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcContractBankField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];
    public byte[] BankName = new byte[101];

    public static class ByReference extends CThostFtdcContractBankField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcContractBankField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("BankID");
        a.add("BankBrchID");
        a.add("BankName");
        return a;
    }
};
