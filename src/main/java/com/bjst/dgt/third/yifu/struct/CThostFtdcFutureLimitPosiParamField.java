package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcFutureLimitPosiParamField extends Structure {
    public byte InvestorRange;
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] ProductID = new byte[31];
    public int SpecOpenVolume;
    public int ArbiOpenVolume;
    public int OpenVolume;

    public static class ByReference extends CThostFtdcFutureLimitPosiParamField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcFutureLimitPosiParamField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InvestorRange");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("ProductID");
        a.add("SpecOpenVolume");
        a.add("ArbiOpenVolume");
        a.add("OpenVolume");
        return a;
    }
};
