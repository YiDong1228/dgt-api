package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferQryBankReqField extends Structure {
    public byte[] FutureAccount = new byte[13];
    public byte FuturePwdFlag;
    public byte[] FutureAccPwd = new byte[17];
    public byte[] CurrencyCode = new byte[4];

    public static class ByReference extends CThostFtdcTransferQryBankReqField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferQryBankReqField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FutureAccount");
        a.add("FuturePwdFlag");
        a.add("FutureAccPwd");
        a.add("CurrencyCode");
        return a;
    }
};
