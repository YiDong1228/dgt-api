package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcSyncingTradingAccountField extends Structure {
    public byte[] BrokerID = new byte[11];
    public byte[] AccountID = new byte[13];
    public double PreMortgage;
    public double PreCredit;
    public double PreDeposit;
    public double PreBalance;
    public double PreMargin;
    public double InterestBase;
    public double Interest;
    public double Deposit;
    public double Withdraw;
    public double FrozenMargin;
    public double FrozenCash;
    public double FrozenCommission;
    public double CurrMargin;
    public double CashIn;
    public double Commission;
    public double CloseProfit;
    public double PositionProfit;
    public double Balance;
    public double Available;
    public double WithdrawQuota;
    public double Reserve;
    public byte[] TradingDay = new byte[9];
    public int SettlementID;
    public double Credit;
    public double Mortgage;
    public double ExchangeMargin;
    public double DeliveryMargin;
    public double ExchangeDeliveryMargin;
    public double ReserveBalance;
    public byte[] CurrencyID = new byte[4];
    public double PreFundMortgageIn;
    public double PreFundMortgageOut;
    public double FundMortgageIn;
    public double FundMortgageOut;
    public double FundMortgageAvailable;
    public double MortgageableFund;
    public double SpecProductMargin;
    public double SpecProductFrozenMargin;
    public double SpecProductCommission;
    public double SpecProductFrozenCommission;
    public double SpecProductPositionProfit;
    public double SpecProductCloseProfit;
    public double SpecProductPositionProfitByAlg;
    public double SpecProductExchangeMargin;
    public double FrozenSwap;
    public double RemainSwap;

    public static class ByReference extends CThostFtdcSyncingTradingAccountField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcSyncingTradingAccountField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("BrokerID");
        a.add("AccountID");
        a.add("PreMortgage");
        a.add("PreCredit");
        a.add("PreDeposit");
        a.add("PreBalance");
        a.add("PreMargin");
        a.add("InterestBase");
        a.add("Interest");
        a.add("Deposit");
        a.add("Withdraw");
        a.add("FrozenMargin");
        a.add("FrozenCash");
        a.add("FrozenCommission");
        a.add("CurrMargin");
        a.add("CashIn");
        a.add("Commission");
        a.add("CloseProfit");
        a.add("PositionProfit");
        a.add("Balance");
        a.add("Available");
        a.add("WithdrawQuota");
        a.add("Reserve");
        a.add("TradingDay");
        a.add("SettlementID");
        a.add("Credit");
        a.add("Mortgage");
        a.add("ExchangeMargin");
        a.add("DeliveryMargin");
        a.add("ExchangeDeliveryMargin");
        a.add("ReserveBalance");
        a.add("CurrencyID");
        a.add("PreFundMortgageIn");
        a.add("PreFundMortgageOut");
        a.add("FundMortgageIn");
        a.add("FundMortgageOut");
        a.add("FundMortgageAvailable");
        a.add("MortgageableFund");
        a.add("SpecProductMargin");
        a.add("SpecProductFrozenMargin");
        a.add("SpecProductCommission");
        a.add("SpecProductFrozenCommission");
        a.add("SpecProductPositionProfit");
        a.add("SpecProductCloseProfit");
        a.add("SpecProductPositionProfitByAlg");
        a.add("SpecProductExchangeMargin");
        a.add("FrozenSwap");
        a.add("RemainSwap");
        return a;
    }
};
