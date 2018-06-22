package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcDiscountField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte InvestorRange;
    public byte[] InvestorID = new byte[13];
    public double Discount;

    public static class ByReference extends CThostFtdcDiscountField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcDiscountField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorRange");
        a.add("InvestorID");
        a.add("Discount");
        return a;
    }
};
