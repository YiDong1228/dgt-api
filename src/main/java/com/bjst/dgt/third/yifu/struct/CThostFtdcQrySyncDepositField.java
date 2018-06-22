package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySyncDepositField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] DepositSeqNo = new byte[15];

    public static class ByReference extends CThostFtdcQrySyncDepositField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySyncDepositField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("DepositSeqNo");
        return a;
    }
};
