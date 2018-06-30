package com.bjst.dgt.model.yifu;

/**
 * @Description: 绑定银行卡接口返回
 * @Author: yd
 * @CreateDate: 2018/06/28 03:42 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 03:42 PM
 * @UpdateRemark: 绑定银行卡接口返回
 * @Version: 1.0
 */
public class BindingBankCardBack {
    private String bankName;//	string	银行名称
    private String name;//	string	姓名
    private String bankAccount;//	string	银行卡号
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
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }
}
