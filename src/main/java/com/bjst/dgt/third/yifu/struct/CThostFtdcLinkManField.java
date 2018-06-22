package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcLinkManField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte PersonType;
    public byte IdentifiedCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public byte[] PersonName = new byte[81];
    public byte[] Telephone = new byte[41];
    public byte[] Address = new byte[101];
    public byte[] ZipCode = new byte[7];
    public int Priority;
    public byte[] UOAZipCode = new byte[11];
    public byte[] PersonFullName = new byte[101];

    public static class ByReference extends CThostFtdcLinkManField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcLinkManField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("PersonType");
        a.add("IdentifiedCardType");
        a.add("IdentifiedCardNo");
        a.add("PersonName");
        a.add("Telephone");
        a.add("Address");
        a.add("ZipCode");
        a.add("Priority");
        a.add("UOAZipCode");
        a.add("PersonFullName");
        return a;
    }
};
