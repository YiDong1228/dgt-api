package com.bjst.dgt.model.yifu;

/**
 * @Description: 解绑银行卡接口返回
 * @Author: yd
 * @CreateDate: 2018/06/28 03:56 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 03:56 PM
 * @UpdateRemark: 解绑银行卡接口返回
 * @Version: 1.0
 */
public class UntieBankCardBack {
    private String BankName;//	string	银行名称
    private String Name;//	string	姓名
    private String BankAccount;//	string	银行卡号

    /**
     * 状态码
     */
    private Integer status;
    /**
     * 信息
     */
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getBankName() {
        return BankName;
    }

    public void setBankName(String bankName) {
        BankName = bankName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBankAccount() {
        return BankAccount;
    }

    public void setBankAccount(String bankAccount) {
        BankAccount = bankAccount;
    }
}
