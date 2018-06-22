package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcVerifyFuturePasswordAndCustInfoField extends Structure {
    public byte[] CustomerName = new byte[51];
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte CustType;
    public byte[] AccountID = new byte[13];
    public byte[] Password = new byte[41];
    public byte[] CurrencyID = new byte[4];
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcVerifyFuturePasswordAndCustInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcVerifyFuturePasswordAndCustInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("CustomerName");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("CustType");
        a.add("AccountID");
        a.add("Password");
        a.add("CurrencyID");
        a.add("LongCustomerName");
        return a;
    }
};
