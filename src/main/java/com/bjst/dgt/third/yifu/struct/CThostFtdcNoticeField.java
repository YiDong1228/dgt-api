package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcNoticeField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] Content = new byte[501];
    public byte[] SequenceLabel = new byte[2];

    public static class ByReference extends CThostFtdcNoticeField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcNoticeField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("Content");
        a.add("SequenceLabel");
        return a;
    }
};
