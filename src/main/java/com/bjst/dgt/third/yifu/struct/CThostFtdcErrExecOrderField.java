package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcErrExecOrderField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExecOrderRef = new byte[13];
    public byte[] UserID = new byte[16];
    public int Volume;
    public int RequestID;
    public byte[] BusinessUnit = new byte[21];
    public byte OffsetFlag;
    public byte HedgeFlag;
    public byte ActionType;
    public byte PosiDirection;
    public byte ReservePositionFlag;
    public byte CloseFlag;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] ClientID = new byte[11];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcErrExecOrderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcErrExecOrderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("ExecOrderRef");
        a.add("UserID");
        a.add("Volume");
        a.add("RequestID");
        a.add("BusinessUnit");
        a.add("OffsetFlag");
        a.add("HedgeFlag");
        a.add("ActionType");
        a.add("PosiDirection");
        a.add("ReservePositionFlag");
        a.add("CloseFlag");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("ClientID");
        a.add("IPAddress");
        a.add("MacAddress");
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
