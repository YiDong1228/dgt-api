package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCancelAccountField extends Structure {
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
    public byte[] CustomerName = new byte[51];
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
    public byte[] AccountID = new byte[13];
    public byte[] Password = new byte[41];
    public int InstallID;
    public byte VerifyCertNoFlag;
    public byte[] CurrencyID = new byte[4];
    public byte CashExchangeCode;
    public byte[] Digest = new byte[36];
    public byte BankAccType;
    public byte[] DeviceID = new byte[3];
    public byte BankSecuAccType;
    public byte[] BrokerIDByBank = new byte[33];
    public byte[] BankSecuAcc = new byte[41];
    public byte BankPwdFlag;
    public byte SecuPwdFlag;
    public byte[] OperNo = new byte[17];
    public int TID;
    public byte[] UserID = new byte[16];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcCancelAccountField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCancelAccountField implements Structure.ByValue {}

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
        a.add("AccountID");
        a.add("Password");
        a.add("InstallID");
        a.add("VerifyCertNoFlag");
        a.add("CurrencyID");
        a.add("CashExchangeCode");
        a.add("Digest");
        a.add("BankAccType");
        a.add("DeviceID");
        a.add("BankSecuAccType");
        a.add("BrokerIDByBank");
        a.add("BankSecuAcc");
        a.add("BankPwdFlag");
        a.add("SecuPwdFlag");
        a.add("OperNo");
        a.add("TID");
        a.add("UserID");
        a.add("ErrorID");
        a.add("ErrorMsg");
        a.add("LongCustomerName");
        return a;
    }
};
