package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcExchangeBatchOrderActionField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] ActionDate = new byte[9];
    public byte[] ActionTime = new byte[9];
    public byte[] TraderID = new byte[21];
    public int InstallID;
    public byte[] ActionLocalID = new byte[13];
    public byte[] ParticipantID = new byte[11];
    public byte[] ClientID = new byte[11];
    public byte[] BusinessUnit = new byte[21];
    public byte OrderActionStatus;
    public byte[] UserID = new byte[16];
    public byte[] IPAddress = new byte[16];
    public byte[] MacAddress = new byte[21];

    public static class ByReference extends CThostFtdcExchangeBatchOrderActionField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcExchangeBatchOrderActionField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("ActionDate");
        a.add("ActionTime");
        a.add("TraderID");
        a.add("InstallID");
        a.add("ActionLocalID");
        a.add("ParticipantID");
        a.add("ClientID");
        a.add("BusinessUnit");
        a.add("OrderActionStatus");
        a.add("UserID");
        a.add("IPAddress");
        a.add("MacAddress");
        return a;
    }
};
