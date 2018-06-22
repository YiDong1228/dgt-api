package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCFMMCTradingAccountTokenField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ParticipantID = new byte[11];
    public byte[] AccountID = new byte[13];
    public int KeyID;
    public byte[] Token = new byte[21];

    public static class ByReference extends CThostFtdcCFMMCTradingAccountTokenField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCFMMCTradingAccountTokenField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ParticipantID");
        a.add("AccountID");
        a.add("KeyID");
        a.add("Token");
        return a;
    }
};
