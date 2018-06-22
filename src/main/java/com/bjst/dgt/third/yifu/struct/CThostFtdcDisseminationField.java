package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcDisseminationField extends Structure {
    public short SequenceSeries;
    public int SequenceNo;

    public static class ByReference extends CThostFtdcDisseminationField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcDisseminationField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("SequenceSeries");
        a.add("SequenceNo");
        return a;
    }
};
