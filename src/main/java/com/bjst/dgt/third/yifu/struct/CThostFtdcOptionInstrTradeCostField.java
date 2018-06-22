package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcOptionInstrTradeCostField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] InstrumentID = new byte[31];
    public byte HedgeFlag;
    public double FixedMargin;
    public double MiniMargin;
    public double Royalty;
    public double ExchFixedMargin;
    public double ExchMiniMargin;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcOptionInstrTradeCostField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcOptionInstrTradeCostField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("InstrumentID");
        a.add("HedgeFlag");
        a.add("FixedMargin");
        a.add("MiniMargin");
        a.add("Royalty");
        a.add("ExchFixedMargin");
        a.add("ExchMiniMargin");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
