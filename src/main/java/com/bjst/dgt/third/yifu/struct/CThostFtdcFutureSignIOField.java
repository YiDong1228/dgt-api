package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcFutureSignIOField extends Structure {
    public byte[] TradeCode = new byte[7];
    public byte[] BankID = new byte[4];
    public byte[] BankBranchID = new byte[5];
    public byte[] BrokerID = new byte[11];
    public byte[] BrokerBranchID = new byte[31];
    public byte[] TradeDate = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte[] BankSerial = new byte[13];
    public byte[] TradingDay = new byte[9];
    public int PlateSerial;
    public byte LastFragment;
    public int SessionID;
    public int InstallID;
    public byte[] UserID = new byte[16];
    public byte[] Digest = new byte[36];
    public byte[] CurrencyID = new byte[4];
    public byte[] DeviceID = new byte[3];
    public byte[] BrokerIDByBank = new byte[33];
    public byte[] OperNo = new byte[17];
    public int RequestID;
    public int TID;

    public static class ByReference extends CThostFtdcFutureSignIOField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcFutureSignIOField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradeCode");
        a.add("BankID");
        a.add("BankBranchID");
        a.add("BrokerID");
        a.add("BrokerBranchID");
        a.add("TradeDate");
        a.add("TradeTime");
        a.add("BankSerial");
        a.add("TradingDay");
        a.add("PlateSerial");
        a.add("LastFragment");
        a.add("SessionID");
        a.add("InstallID");
        a.add("UserID");
        a.add("Digest");
        a.add("CurrencyID");
        a.add("DeviceID");
        a.add("BrokerIDByBank");
        a.add("OperNo");
        a.add("RequestID");
        a.add("TID");
        return a;
    }
};
