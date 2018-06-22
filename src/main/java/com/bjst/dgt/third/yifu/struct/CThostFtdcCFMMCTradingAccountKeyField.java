package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCFMMCTradingAccountKeyField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ParticipantID = new byte[11];
    public byte[] AccountID = new byte[13];
    public int KeyID;
    public byte[] CurrentKey = new byte[21];

    public static class ByReference extends CThostFtdcCFMMCTradingAccountKeyField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCFMMCTradingAccountKeyField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ParticipantID");
        a.add("AccountID");
        a.add("KeyID");
        a.add("CurrentKey");
        return a;
    }
};
