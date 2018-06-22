package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcTradingAccountPasswordUpdateV1Field extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] OldPassword = new byte[41];
    public byte[] NewPassword = new byte[41];

    public static class ByReference extends CThostFtdcTradingAccountPasswordUpdateV1Field implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcTradingAccountPasswordUpdateV1Field implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OldPassword");
        a.add("NewPassword");
        return a;
    }
};
