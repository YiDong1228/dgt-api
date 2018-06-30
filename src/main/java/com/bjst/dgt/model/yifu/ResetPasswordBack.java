package com.bjst.dgt.model.yifu;

/**
 * @Description: 重置密码接口返回
 * @Author: yd
 * @CreateDate: 2018/06/28 03:32 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/28 03:32 PM
 * @UpdateRemark: 重置密码接口返回
 * @Version: 1.0
 */
public class ResetPasswordBack {
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

}
