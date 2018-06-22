package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferQryDetailReqField extends Structure {
    public byte[] FutureAccount = new byte[13];

    public static class ByReference extends CThostFtdcTransferQryDetailReqField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferQryDetailReqField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FutureAccount");
        return a;
    }
};
