package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorField extends Structure {
    public byte[] InvestorID = new byte[13];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorGroupID = new byte[13];
    public byte[] InvestorName = new byte[81];
    public byte IdentifiedCardType;
    public byte[] IdentifiedCardNo = new byte[51];
    public int IsActive;
    public byte[] Telephone = new byte[41];
    public byte[] Address = new byte[101];
    public byte[] OpenDate = new byte[9];
    public byte[] Mobile = new byte[41];
    public byte[] CommModelID = new byte[13];
    public byte[] MarginModelID = new byte[13];

    public static class ByReference extends CThostFtdcInvestorField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("InvestorID");
        a.add("BrokerID");
        a.add("InvestorGroupID");
        a.add("InvestorName");
        a.add("IdentifiedCardType");
        a.add("IdentifiedCardNo");
        a.add("IsActive");
        a.add("Telephone");
        a.add("Address");
        a.add("OpenDate");
        a.add("Mobile");
        a.add("CommModelID");
        a.add("MarginModelID");
        return a;
    }
};
