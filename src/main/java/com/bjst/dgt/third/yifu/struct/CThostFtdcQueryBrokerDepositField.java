package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQueryBrokerDepositField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQueryBrokerDepositField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQueryBrokerDepositField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ExchangeID");
        return a;
    }
};
