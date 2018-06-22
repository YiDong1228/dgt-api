package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReqDayEndFileReadyField extends Structure {
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
    public byte FileBusinessCode;
    public byte[] Digest = new byte[36];

    public static class ByReference extends CThostFtdcReqDayEndFileReadyField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReqDayEndFileReadyField implements Structure.ByValue {}

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
        a.add("FileBusinessCode");
        a.add("Digest");
        return a;
    }
};
