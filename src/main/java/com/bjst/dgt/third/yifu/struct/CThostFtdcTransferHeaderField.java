package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferHeaderField extends Structure {
    public byte[] Version = new byte[4];
    public byte[] TradeCode = new byte[7];
    public byte[] TradeDate = new byte[9];
    public byte[] TradeTime = new byte[9];
    public byte[] TradeSerial = new byte[9];
    public byte[] FutureID = new byte[11];
    public byte[] BankID = new byte[4];
    public byte[] BankBrchID = new byte[5];
    public byte[] OperNo = new byte[17];
    public byte[] DeviceID = new byte[3];
    public byte[] RecordNum = new byte[7];
    public int SessionID;
    public int RequestID;

    public static class ByReference extends CThostFtdcTransferHeaderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferHeaderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("Version");
        a.add("TradeCode");
        a.add("TradeDate");
        a.add("TradeTime");
        a.add("TradeSerial");
        a.add("FutureID");
        a.add("BankID");
        a.add("BankBrchID");
        a.add("OperNo");
        a.add("DeviceID");
        a.add("RecordNum");
        a.add("SessionID");
        a.add("RequestID");
        return a;
    }
};
