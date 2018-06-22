package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcVerifyCustInfoField extends Structure {
    public byte[] CustomerName = new byte[51];
    public byte IdCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte CustType;
    public byte[] LongCustomerName = new byte[161];

    public static class ByReference extends CThostFtdcVerifyCustInfoField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcVerifyCustInfoField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("CustomerName");
        a.add("IdCardType");
        a.add("IdentifiedCardNo");
        a.add("CustType");
        a.add("LongCustomerName");
        return a;
    }
};
