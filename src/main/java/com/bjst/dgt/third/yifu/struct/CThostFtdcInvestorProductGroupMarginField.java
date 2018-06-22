package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcInvestorProductGroupMarginField extends Structure {
    public byte[] ProductGroupID = new byte[31];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public double FrozenMargin;
    public double LongFrozenMargin;
    public double ShortFrozenMargin;
    public double UseMargin;
    public double LongUseMargin;
    public double ShortUseMargin;
    public double ExchMargin;
    public double LongExchMargin;
    public double ShortExchMargin;
    public double CloseProfit;
    public double FrozenCommission;
    public double Commission;
    public double FrozenCash;
    public double CashIn;
    public double PositionProfit;
    public double OffsetAmount;
    public double LongOffsetAmount;
    public double ShortOffsetAmount;
    public double ExchOffsetAmount;
    public double LongExchOffsetAmount;
    public double ShortExchOffsetAmount;
    public byte HedgeFlag;
    public byte[] ExchangeID = new byte[9];
    public byte[] InvestUnitID = new byte[17];

    public static class ByReference extends CThostFtdcInvestorProductGroupMarginField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcInvestorProductGroupMarginField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("ProductGroupID");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("FrozenMargin");
        a.add("LongFrozenMargin");
        a.add("ShortFrozenMargin");
        a.add("UseMargin");
        a.add("LongUseMargin");
        a.add("ShortUseMargin");
        a.add("ExchMargin");
        a.add("LongExchMargin");
        a.add("ShortExchMargin");
        a.add("CloseProfit");
        a.add("FrozenCommission");
        a.add("Commission");
        a.add("FrozenCash");
        a.add("CashIn");
        a.add("PositionProfit");
        a.add("OffsetAmount");
        a.add("LongOffsetAmount");
        a.add("ShortOffsetAmount");
        a.add("ExchOffsetAmount");
        a.add("LongExchOffsetAmount");
        a.add("ShortExchOffsetAmount");
        a.add("HedgeFlag");
        a.add("ExchangeID");
        a.add("InvestUnitID");
        return a;
    }
};
