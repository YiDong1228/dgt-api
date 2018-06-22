package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeOrderInsertErrorField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte[] OrderLocalID = new byte[13];
    public int ErrorID;
    public byte[] ErrorMsg = new byte[81];

    public static class ByReference extends CThostFtdcExchangeOrderInsertErrorField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeOrderInsertErrorField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("TraderID");
        a.add("InstallID");
        a.add("OrderLocalID");
        a.add("ErrorID");
        a.add("ErrorMsg");
        return a;
    }
};
