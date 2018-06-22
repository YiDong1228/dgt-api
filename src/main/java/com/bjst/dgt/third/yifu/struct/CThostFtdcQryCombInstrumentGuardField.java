package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryCombInstrumentGuardField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InstrumentID = new byte[31];
    public byte[] ExchangeID = new byte[9];

    public static class ByReference extends CThostFtdcQryCombInstrumentGuardField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryCombInstrumentGuardField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InstrumentID");
        a.add("ExchangeID");
        return a;
    }
};
