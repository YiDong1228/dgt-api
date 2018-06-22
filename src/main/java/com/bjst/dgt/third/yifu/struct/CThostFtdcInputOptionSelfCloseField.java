package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputOptionSelfCloseField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] OptionSelfCloseRef = new byte[13];
    public byte[] UserID = new byte[16];
    public int Volume;
    public int RequestID;
    public byte[] BusinessUnit = new byte[21];
    public byte HedgeFlag;
    public byte OptSelfCloseFlag;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];
    public byte[] ClientID = new byte[11];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcInputOptionSelfCloseField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputOptionSelfCloseField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("OptionSelfCloseRef");
        a.add("UserID");
        a.add("Volume");
        a.add("RequestID");
        a.add("BusinessUnit");
        a.add("HedgeFlag");
        a.add("OptSelfCloseFlag");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        a.add("AccountID");
        a.add("CurrencyID");
        a.add("ClientID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
