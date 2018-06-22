package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryContractBankField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];

    public static class ByReference extends CThostFtdcQryContractBankField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryContractBankField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("BankID");
        a.add("BankBrchID");
        return a;
    }
};
