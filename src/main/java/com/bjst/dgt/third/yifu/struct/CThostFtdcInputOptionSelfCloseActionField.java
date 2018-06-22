package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInputOptionSelfCloseActionField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public int OptionSelfCloseActionRef;
    public byte[] OptionSelfCloseRef = new byte[13];
    public int RequestID;
    public int FrontID;
    public int SessionID;
    public byte[] ExchangeID = new byte[9];
    public byte[] OptionSelfCloseSysID = new byte[21];
    public byte ActionFlag;
    public byte[] UserID = new byte[16];
    public byte[] InstrumentID = new byte[31];
    public byte[] InvestUnitID = new byte[17];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcInputOptionSelfCloseActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInputOptionSelfCloseActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("OptionSelfCloseActionRef");
        a.add("OptionSelfCloseRef");
        a.add("RequestID");
        a.add("FrontID");
        a.add("SessionID");
        a.add("ExchangeID");
        a.add("OptionSelfCloseSysID");
        a.add("ActionFlag");
        a.add("UserID");
        a.add("InstrumentID");
        a.add("InvestUnitID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
