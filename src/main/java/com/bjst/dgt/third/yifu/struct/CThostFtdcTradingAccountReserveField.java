package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradingAccountReserveField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] AccountID = new byte[13];
    public double Reserve;
    public byte[] CurrencyID = new byte[4];

    public static class ByReference extends CThostFtdcTradingAccountReserveField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradingAccountReserveField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("AccountID");
        a.add("Reserve");
        a.add("CurrencyID");
        return a;
    }
};
