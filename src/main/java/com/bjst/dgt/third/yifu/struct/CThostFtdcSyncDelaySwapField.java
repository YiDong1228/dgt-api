package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncDelaySwapField extends Structure {
    public byte[] DelaySwapSeqNo = new byte[15];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] FromCurrencyID = new byte[4];
    public double FromAmount;
    public double FromFrozenSwap;
    public double FromRemainSwap;
    public byte[] ToCurrencyID = new byte[4];
    public double ToAmount;

    public static class ByReference extends CThostFtdcSyncDelaySwapField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncDelaySwapField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("DelaySwapSeqNo");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("FromCurrencyID");
        a.add("FromAmount");
        a.add("FromFrozenSwap");
        a.add("FromRemainSwap");
        a.add("ToCurrencyID");
        a.add("ToAmount");
        return a;
    }
};
