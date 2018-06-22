package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcAccountregisterField extends Structure {
    public byte[] TradeDay = new byte[9];
    public byte[] BankID = new byte[4];
    public byte[] BankBranchID = new byte[5];
    public byte[] BankAccount = new byte[41];
    public byte[] BrokerID = new byte[11];
    public byte[] BrokerBranchID = new byte[31];
    public byte[] AccountID = new byte[13];
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte[] CustomerName = new byte[51];
    public byte[] CurrencyID = new byte[4];
    public byte OpenOrDestroy;
    public byte[] RegDate = new byte[9];
    public byte[] OutDate = new byte[9];
    public int TID;
    public byte CustType;
    public byte BankAccType;
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcAccountregisterField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcAccountregisterField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradeDay");
        a.add("BankID");
        a.add("BankBranchID");
        a.add("BankAccount");
        a.add("BrokerID");
        a.add("BrokerBranchID");
        a.add("AccountID");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("CustomerName");
        a.add("CurrencyID");
        a.add("OpenOrDestroy");
        a.add("RegDate");
        a.add("OutDate");
        a.add("TID");
        a.add("CustType");
        a.add("BankAccType");
        a.add("LongCustomerName");
        return a;
    }
};
