package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReqTransferField extends Structure {
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
    public byte CustType;
    public byte[] BankAccount = new byte[41];
    public byte[] BankPassWord = new byte[41];
    public byte[] AccountID = new byte[13];
    public byte[] Password = new byte[41];
    public int InstallID;
    public int FutureSerial;
    public byte[] UserID = new byte[16];
    public byte VerifyCertNoFlag;
    public byte[] CurrencyID = new byte[4];
    public double TradeAmount;
    public double FutureFetchAmount;
    public byte FeePayFlag;
    public double CustFee;
    public double BrokerFee;
    public byte[] Message = new byte[129];
    public byte[] Digest = new byte[36];
    public byte BankAccType;
    public byte[] DeviceID = new byte[3];
    public byte BankSecuAccType;
    public byte[] BrokerIDByBank = new byte[33];
    public byte[] BankSecuAcc = new byte[41];
    public byte BankPwdFlag;
    public byte SecuPwdFlag;
    public byte[] OperNo = new byte[17];
    public int RequestID;
    public int TID;
    public byte TransferStatus;
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcReqTransferField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReqTransferField implements Structure.ByValue {}

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
        a.add("CustType");
        a.add("BankAccount");
        a.add("BankPassWord");
        a.add("AccountID");
        a.add("Password");
        a.add("InstallID");
        a.add("FutureSerial");
        a.add("UserID");
        a.add("VerifyCertNoFlag");
        a.add("CurrencyID");
        a.add("TradeAmount");
        a.add("FutureFetchAmount");
        a.add("FeePayFlag");
        a.add("CustFee");
        a.add("BrokerFee");
        a.add("Message");
        a.add("Digest");
        a.add("BankAccType");
        a.add("DeviceID");
        a.add("BankSecuAccType");
        a.add("BrokerIDByBank");
        a.add("BankSecuAcc");
        a.add("BankPwdFlag");
        a.add("SecuPwdFlag");
        a.add("OperNo");
        a.add("RequestID");
        a.add("TID");
        a.add("TransferStatus");
        a.add("LongCustomerName");
        return a;
    }
};
