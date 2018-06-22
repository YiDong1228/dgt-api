package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferBankToFutureReqField extends Structure {
    public byte[] FutureAccount = new byte[13];
    public byte FuturePwdFlag;
    public byte[] FutureAccPwd = new byte[17];
    public double TradeAmt;
    public double CustFee;
    public byte[] CurrencyCode = new byte[4];

    public static class ByReference extends CThostFtdcTransferBankToFutureReqField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferBankToFutureReqField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("FutureAccount");
        a.add("FuturePwdFlag");
        a.add("FutureAccPwd");
        a.add("TradeAmt");
        a.add("CustFee");
        a.add("CurrencyCode");
        return a;
    }
};
