package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcDRTransferField extends Structure {
    public int OrigDRIdentityID;
    public int DestDRIdentityID;
    public byte[] OrigBrokerID = new byte[11];
    public byte[] DestBrokerID = new byte[11];

    public static class ByReference extends CThostFtdcDRTransferField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcDRTransferField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("OrigDRIdentityID");
        a.add("DestDRIdentityID");
        a.add("OrigBrokerID");
        a.add("DestBrokerID");
        return a;
    }
};
