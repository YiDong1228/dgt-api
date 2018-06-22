package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcMDTraderOfferField extends Structure {
    public byte[] ExchangeID = new byte[9];
    public byte[] TraderID = new byte[21];
    public byte[] ParticipantID = new byte[11];
    public byte[] Password = new byte[41];
    public int InstallID;
    public byte[] OrderLocalID = new byte[13];
    public byte TraderConnectStatus;
    public byte[] ConnectRequestDate = new byte[9];
    public byte[] ConnectRequestTime = new byte[9];
    public byte[] LastReportDate = new byte[9];
    public byte[] LastReportTime = new byte[9];
    public byte[] ConnectDate = new byte[9];
    public byte[] ConnectTime = new byte[9];
    public byte[] StartDate = new byte[9];
    public byte[] StartTime = new byte[9];
    public byte[] TradingDay = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] MaxTradeID = new byte[21];
    public byte[] MaxOrderMessageReference = new byte[7];

    public static class ByReference extends CThostFtdcMDTraderOfferField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcMDTraderOfferField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ExchangeID");
        a.add("TraderID");
        a.add("ParticipantID");
        a.add("Password");
        a.add("InstallID");
        a.add("OrderLocalID");
        a.add("TraderConnectStatus");
        a.add("ConnectRequestDate");
        a.add("ConnectRequestTime");
        a.add("LastReportDate");
        a.add("LastReportTime");
        a.add("ConnectDate");
        a.add("ConnectTime");
        a.add("StartDate");
        a.add("StartTime");
        a.add("TradingDay");
        a.add("BrokerID");
        a.add("MaxTradeID");
        a.add("MaxOrderMessageReference");
        return a;
    }
};
