package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQrySyncFundMortgageField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] MortgageSeqNo = new byte[15];

    public static class ByReference extends CThostFtdcQrySyncFundMortgageField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQrySyncFundMortgageField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("MortgageSeqNo");
        return a;
    }
};
