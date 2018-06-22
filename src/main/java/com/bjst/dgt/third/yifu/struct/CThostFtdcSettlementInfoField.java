package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSettlementInfoField extends Structure {
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int SequenceNo;
    public byte[] Content = new byte[501];
    public byte[] AccountID = new byte[13];
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcSettlementInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSettlementInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("SequenceNo");
        a.add("Content");
        a.add("AccountID");
        a.add("CurrencyID");
        return a;
    }
};
