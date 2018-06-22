package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySyncDelaySwapField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] DelaySwapSeqNo = new byte[15];

    public static class ByReference extends CThostFtdcQrySyncDelaySwapField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySyncDelaySwapField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("DelaySwapSeqNo");
        return a;
    }
};
