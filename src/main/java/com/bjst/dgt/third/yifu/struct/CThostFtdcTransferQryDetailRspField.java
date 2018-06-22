package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferQryDetailRspField extends Structure {
    public byte[] TradeDate = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte[] TradeCode = new byte[7];
    public int FutureSerial;
    public byte[] FutureID = new byte[11];
    public byte[] FutureAccount = new byte[22];
    public int BankSerial;
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];
    public byte[] BankAccount = new byte[41];
    public byte[] CertCode = new byte[21];
    public byte[] CurrencyCode = new byte[4];
    public double TxAmount;
    public byte Flag;

    public static class ByReference extends CThostFtdcTransferQryDetailRspField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferQryDetailRspField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradeDate");
        a.add("TradeTime");
        a.add("TradeCode");
        a.add("FutureSerial");
        a.add("FutureID");
        a.add("FutureAccount");
        a.add("BankSerial");
        a.add("BankID");
        a.add("BankBrchID");
        a.add("BankAccount");
        a.add("CertCode");
        a.add("CurrencyCode");
        a.add("TxAmount");
        a.add("Flag");
        return a;
    }
};
