package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBulletinField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] TradingDay = new byte[9];
    public int BulletinID;
    public int SequenceNo;
    public byte[] NewsType = new byte[3];
    public byte NewsUrgency;
    public byte[] SendTime = new byte[9];
    public byte[] Abstract = new byte[81];
    public byte[] ComeFrom = new byte[21];
    public byte[] Content = new byte[501];
    public byte[] URLLink = new byte[201];
    public byte[] MarketID = new byte[31];

    public static class ByReference extends CThostFtdcBulletinField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBulletinField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("TradingDay");
        a.add("BulletinID");
        a.add("SequenceNo");
        a.add("NewsType");
        a.add("NewsUrgency");
        a.add("SendTime");
        a.add("Abstract");
        a.add("ComeFrom");
        a.add("Content");
        a.add("URLLink");
        a.add("MarketID");
        return a;
    }
};
