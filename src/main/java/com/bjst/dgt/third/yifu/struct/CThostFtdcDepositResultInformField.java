package com.bjst.dgt.third.yifu.struct;

import com.sun.jna.Structure;

import java.util.ArrayList;
import java.util.List;

public class CThostFtdcDepositResultInformField extends Structure {
    public byte[] DepositSeqNo = new byte[15];
    public byte[] BrokerID = new byte[11];
    public byte[] InvestorID = new byte[13];
    public double Deposit;
    public int RequestID;
    public byte[] ReturnCode = new byte[7];
    public byte[] DescrInfoForReturnCode = new byte[129];

    public static class ByReference extends CThostFtdcDepositResultInformField implements Structure.ByReference {}
    public static class ByValue extends CThostFtdcDepositResultInformField implements Structure.ByValue {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override

    protected List getFieldOrder() {
        List a = new ArrayList();
        a.add("DepositSeqNo");
        a.add("BrokerID");
        a.add("InvestorID");
        a.add("Deposit");
        a.add("RequestID");
        a.add("ReturnCode");
        a.add("DescrInfoForReturnCode");
        return a;
    }
};
