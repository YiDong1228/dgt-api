package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTraderField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] TraderID = new byte[21];
    public byte[] ParticipantID = new byte[11];
    public byte[] Password = new byte[41];
    public int InstallCount;
    public byte[] BrokerID = new byte[11];

    public static class ByReference extends CThostFtdcTraderField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTraderField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("TraderID");
        a.add("ParticipantID");
        a.add("Password");
        a.add("InstallCount");
        a.add("BrokerID");
        return a;
    }
};
