package com.bjst.dgt.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {

    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成32位md5码
     *
     * @param password
     * @return
     */
    public static String md5Sign(String password) {
        // 得到一个信息摘要器
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static final String MD5(String mobile, String password) {
        String passWardMd5 = "";
        if (StringUtils.isNotEmpty(mobile) && StringUtils.isNotEmpty(password)) {
            String str = password + mobile;
            passWardMd5 = MD5Util.MD5(str);
        }
        return passWardMd5;
    }

    public static final String MD5_Register(int in,String OrgID, String AgentID, String Phone, String SubAccountName, String Password, String ParentAccountID, String SystemID, String AccountType, String MarginTemplateID, String CommissionTemplateID, String RiskTemplateID, String MonitorID, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(OrgID)) {
            builder.append(OrgID + "|");
        }
        if (StringUtils.isNotEmpty(AgentID)) {
            builder.append(AgentID + "|");
        }
        if (StringUtils.isNotEmpty(Phone)) {
            builder.append(Phone + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountName)) {
            builder.append(SubAccountName + "|");
        }
        if (StringUtils.isNotEmpty(Password)) {
            builder.append(Password + "|");
        }
        if (StringUtils.isNotEmpty(ParentAccountID)) {
            builder.append(ParentAccountID + "|");
        }
        if (StringUtils.isNotEmpty(SystemID)) {
            builder.append(SystemID + "|");
        }
        if (StringUtils.isNotEmpty(AccountType)) {
            builder.append(AccountType + "|");
        }
        if (StringUtils.isNotEmpty(MarginTemplateID)) {
            builder.append(MarginTemplateID + "|");
        }
        if (StringUtils.isNotEmpty(CommissionTemplateID)) {
            builder.append(CommissionTemplateID + "|");
        }
        if (StringUtils.isNotEmpty(RiskTemplateID)) {
            builder.append(RiskTemplateID + "|");
        }
        if (StringUtils.isNotEmpty(MonitorID)) {
            builder.append(MonitorID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str ="";
        if(in == 0){
           str = Origin + MD5_Key.MD5_FORMAL_KEY;
        }else{
           str = Origin + MD5_Key.MD5_OUTER_KEY;
        }
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }


    public static final String MD5(String Params, String Type, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(Params)) {
            builder.append(Params + "|");
        }
        if (StringUtils.isNotEmpty(Type)) {
            builder.append(Type + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_money(String SubAccountID, String Currency, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(Currency)) {
            builder.append(Currency + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_login(String Password, String SubAccountID, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(Password)) {
            builder.append(Password + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_rujin(String SubAccountID, String Currency, String Direction, String Amount, String Position, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(Currency)) {
            builder.append(Currency + "|");
        }
        if (StringUtils.isNotEmpty(Direction)) {
            builder.append(Direction + "|");
        }
        if (StringUtils.isNotEmpty(Amount)) {
            builder.append(Amount + "|");
        }
        if (StringUtils.isNotEmpty(Position)) {
            builder.append(Position + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_bank(String SubAccountID, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_subtransferaudits(String BankName, String Name, String BankAccount, String SubAccountID, String Amount, String Position, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(BankName)) {
            builder.append(BankName + "|");
        }
        if (StringUtils.isNotEmpty(Name)) {
            builder.append(Name + "|");
        }
        if (StringUtils.isNotEmpty(BankAccount)) {
            builder.append(BankAccount + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(Amount)) {
            builder.append(Amount + "|");
        }
        if (StringUtils.isNotEmpty(Position)) {
            builder.append(Position + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_bangding(String BankName, String Name, String BankAccount, String SubAccountID, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(BankName)) {
            builder.append(BankName + "|");
        }
        if (StringUtils.isNotEmpty(Name)) {
            builder.append(Name + "|");
        }
        if (StringUtils.isNotEmpty(BankAccount)) {
            builder.append(BankAccount + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_jiebang(String BankAccount, String SubAccountID, String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(BankAccount)) {
            builder.append(BankAccount + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_aa(String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

    public static final String MD5_password(String Password,String SubAccountID,String TimeStamp, String Version) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotEmpty(Password)) {
            builder.append(Password + "|");
        }
        if (StringUtils.isNotEmpty(SubAccountID)) {
            builder.append(SubAccountID + "|");
        }
        if (StringUtils.isNotEmpty(TimeStamp)) {
            builder.append(TimeStamp + "|");
        }
        if (StringUtils.isNotEmpty(Version)) {
            builder.append(Version + "|");
        }
        String Origin = builder.toString();
        String str = Origin + MD5_Key.MD5_FORMAL_KEY;
        String Md5 = MD5Util.MD5(str);
        return Md5.toLowerCase();
    }

}
