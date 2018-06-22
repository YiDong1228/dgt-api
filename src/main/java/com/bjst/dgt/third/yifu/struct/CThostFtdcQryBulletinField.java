package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcQryBulletinField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public int BulletinID;
    public int SequenceNo;
    public byte[] NewsType = new byte[3];
    public byte NewsUrgency;

    public static class ByReference extends CThostFtdcQryBulletinField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcQryBulletinField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("BulletinID");
        a.add("SequenceNo");
        a.add("NewsType");
        a.add("NewsUrgency");
        return a;
    }
};
