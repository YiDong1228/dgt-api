package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcAccountPropertyField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] AccountID = new byte[13];
    public byte[] BankID = new byte[4];
    public byte[] BankAccount = new byte[41];
    public byte[] OpenName = new byte[101];
    public byte[] OpenBank = new byte[101];
    public int IsActive;
    public byte AccountSourceType;
    public byte[] OpenDate = new byte[9];
    public byte[] CancelDate = new byte[9];
    public byte[] OperatorID = new byte[65];
    public byte[] OperateDate = new byte[9];
    public byte[] OperateTime = new byte[9];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcAccountPropertyField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcAccountPropertyField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("AccountID");
        a.add("BankID");
        a.add("BankAccount");
        a.add("OpenName");
        a.add("OpenBank");
        a.add("IsActive");
        a.add("AccountSourceType");
        a.add("OpenDate");
        a.add("CancelDate");
        a.add("OperatorID");
        a.add("OperateDate");
        a.add("OperateTime");
        a.add("CurrencyID");
        return a;
    }
};
