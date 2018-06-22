package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferBankField extends Structure {
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];
    public byte[] BankName = new byte[101];
    public int IsActive;

    public static class ByReference extends CThostFtdcTransferBankField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferBankField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BankID");
        a.add("BankBrchID");
        a.add("BankName");
        a.add("IsActive");
        return a;
    }
};
