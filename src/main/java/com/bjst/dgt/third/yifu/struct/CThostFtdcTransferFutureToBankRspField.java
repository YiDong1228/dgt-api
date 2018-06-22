package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTransferFutureToBankRspField extends Structure {
    public byte[] RetCode = new byte[5];
    public byte[] RetInfo = new byte[129];
    public byte[] FutureAccount = new byte[13];
    public double TradeAmt;
    public double CustFee;
    public byte[] CurrencyCode = new byte[4];

    public static class ByReference extends CThostFtdcTransferFutureToBankRspField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTransferFutureToBankRspField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("RetCode");
        a.add("RetInfo");
        a.add("FutureAccount");
        a.add("TradeAmt");
        a.add("CustFee");
        a.add("CurrencyCode");
        return a;
    }
};
