package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferSerialField extends Structure {
    public int PlateSerial;
    public byte[] TradeDate = new byte[9];
    public byte[] TradingDay = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte[] TradeCode = new byte[7];
    public int SessionID;
    public byte[] BankID = new byte[4];
    public byte[] BankBranchID = new byte[5];
    public byte BankAccType;
    public byte[] BankAccount = new byte[41];
    public byte[] BankSerial = new byte[13];
    public byte[] BrokerID = new byte[11];
    public byte[] BrokerBranchID = new byte[31];
    public byte FutureAccType;
    public byte[] AccountID = new byte[13];
    public byte[] InvestorID = new byte[13];
    public int FutureSerial;
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte[] CurrencyID = new byte[4];
    public double TradeAmount;
    public double CustFee;
    public double BrokerFee;
    public byte AvailabilityFlag;
    public byte[] OperatorCode = new byte[17];
    public byte[] BankNewAccount = new byte[41];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcTransferSerialField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferSerialField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("PlateSerial");
        a.add("TradeDate");
        a.add("TradingDay");
        a.add("TradeTime");
        a.add("TradeCode");
        a.add("SessionID");
        a.add("BankID");
        a.add("BankBranchID");
        a.add("BankAccType");
        a.add("BankAccount");
        a.add("BankSerial");
        a.add("BrokerID");
        a.add("BrokerBranchID");
        a.add("FutureAccType");
        a.add("AccountID");
        a.add("InvestorID");
        a.add("FutureSerial");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("CurrencyID");
        a.add("TradeAmount");
        a.add("CustFee");
        a.add("BrokerFee");
        a.add("AvailabilityFlag");
        a.add("OperatorCode");
        a.add("BankNewAccount");
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
