package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryMDTraderOfferField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ParticipantID = new byte[11];
    public byte[] TraderID = new byte[21];

    public static class ByReference extends CThostFtdcQryMDTraderOfferField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryMDTraderOfferField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ParticipantID");
        a.add("TraderID");
        return a;
    }
};
