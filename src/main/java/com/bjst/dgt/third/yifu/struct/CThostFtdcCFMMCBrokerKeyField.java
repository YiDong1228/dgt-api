package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcCFMMCBrokerKeyField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] ParticipantID = new byte[11];
    public byte[] CreateDate = new byte[9];
    public byte[] CreateTime = new byte[9];
    public int KeyID;
    public byte[] CurrentKey = new byte[21];
    public byte KeyKind;

    public static class ByReference extends CThostFtdcCFMMCBrokerKeyField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcCFMMCBrokerKeyField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("ParticipantID");
        a.add("CreateDate");
        a.add("CreateTime");
        a.add("KeyID");
        a.add("CurrentKey");
        a.add("KeyKind");
        return a;
    }
};
