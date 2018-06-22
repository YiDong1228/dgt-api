package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcBrokerDepositField extends Structure {
    public byte[] TradingDay = new byte[9];
    public byte[] BrokerID = new byte[11];
    public byte[] ParticipantID = new byte[11];
    public byte[] ExchangeID = new byte[9];
    public double PreBalance;
    public double CurrMargin;
    public double CloseProfit;
    public double Balance;
    public double Deposit;
    public double Withdraw;
    public double Available;
    public double Reserve;
    public double FrozenMargin;

    public static class ByReference extends CThostFtdcBrokerDepositField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcBrokerDepositField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("TradingDay");
        a.add("BrokerID");
        a.add("ParticipantID");
        a.add("ExchangeID");
        a.add("PreBalance");
        a.add("CurrMargin");
        a.add("CloseProfit");
        a.add("Balance");
        a.add("Deposit");
        a.add("Withdraw");
        a.add("Available");
        a.add("Reserve");
        a.add("FrozenMargin");
        return a;
    }
};
