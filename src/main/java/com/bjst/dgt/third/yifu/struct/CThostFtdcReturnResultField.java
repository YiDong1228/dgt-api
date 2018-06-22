package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcReturnResultField extends Structure {
    public byte[] ReturnCode = new byte[7];
    public byte[] DescrInfoForReturnCode = new byte[129];

    public static class ByReference extends CThostFtdcReturnResultField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcReturnResultField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ReturnCode");
        a.add("DescrInfoForReturnCode");
        return a;
    }
};
