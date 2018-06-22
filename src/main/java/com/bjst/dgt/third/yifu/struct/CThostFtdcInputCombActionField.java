package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputCombActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte[] CombActionRef = new byte[13];
    public byte[] UserID = new byte[16];
    public byte Direction;
    public int Volume;
    public byte CombDirection;
    public byte HedgeFlag;
    public byte[] ExchangeID = new byte[9];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInputCombActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputCombActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("CombActionRef");
        a.add("UserID");
        a.add("Direction");
        a.add("Volume");
        a.add("CombDirection");
        a.add("HedgeFlag");
        a.add("ExchangeID");
        a.add("IPAddress");
        a.add("MacAddress");
        a.add("InvestUnitID");
        return a;
    }
};
