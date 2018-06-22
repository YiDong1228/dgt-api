package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryExchangeExecOrderActionField extends Structure {
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public byte[] TraderID = new byte[21];

    public static class ByReference extends CThostFtdcQryExchangeExecOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryExchangeExecOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("ExchangeID");
        a.add("TraderID");
        return a;
    }
};
