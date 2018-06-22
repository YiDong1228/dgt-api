package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReserveOpenAccountConfirmField extends Structure {
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
    public byte[] CustomerName = new byte[161];
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte Gender;
    public byte[] CountryCode = new byte[21];
    public byte CustType;
    public byte[] Address = new byte[101];
    public byte[] ZipCode = new byte[7];
    public byte[] Telephone = new byte[41];
    public byte[] MobilePhone = new byte[21];
    public byte[] Fax = new byte[41];
    public byte[] EMail = new byte[41];
    public byte MoneyAccountStatus;
    public byte[] BankAccount = new byte[41];
    public byte[] BankPassWord = new byte[41];
    public int InstallID;
    public byte VerifyCertNoFlag;
    public byte[] CurrencyID = new byte[4];
    public byte[] Digest = new byte[36];
    public byte BankAccType;
    public byte[] BrokerIDByBank = new byte[33];
    public int TID;
    public byte[] AccountID = new byte[13];
    public byte[] Password = new byte[41];
    public byte[] BankReserveOpenSeq = new byte[13];
    public byte[] BookDate = new byte[9];
    public byte[] BookPsw = new byte[41];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcReserveOpenAccountConfirmField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReserveOpenAccountConfirmField implements Structure.ByValue {}

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
        a.add("CustomerName");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("Gender");
        a.add("CountryCode");
        a.add("CustType");
        a.add("Address");
        a.add("ZipCode");
        a.add("Telephone");
        a.add("MobilePhone");
        a.add("Fax");
        a.add("EMail");
        a.add("MoneyAccountStatus");
        a.add("BankAccount");
        a.add("BankPassWord");
        a.add("InstallID");
        a.add("VerifyCertNoFlag");
        a.add("CurrencyID");
        a.add("Digest");
        a.add("BankAccType");
        a.add("BrokerIDByBank");
        a.add("TID");
        a.add("AccountID");
        a.add("Password");
        a.add("BankReserveOpenSeq");
        a.add("BookDate");
        a.add("BookPsw");
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
