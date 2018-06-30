package com.bjst.dgt.model.yifu;

/**
 * @Description: 注册返回
 * @Author: yd
 * @CreateDate: 2018/06/28 10:07 AM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 10:07 AM
 * @UpdateRemark: 注册返回
 * @Version: 1.0
 */
public class RegisterBack {
   private String subAccountID;//	string	子账户代码
   private String subLink;//	string	子账户手机号
   private String password;//	string	子账户密码

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


    public String getSubAccountID() {
        return subAccountID;
    }

    public void setSubAccountID(String subAccountID) {
        this.subAccountID = subAccountID;
    }

    public String getSubLink() {
        return subLink;
    }

    public void setSubLink(String subLink) {
        this.subLink = subLink;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
