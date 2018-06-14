package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_product_order")
public class UserProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 产品code
     */
    private String code;

    /**
     * 排序字段
     */
    private Byte order;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取产品code
     *
     * @return code - 产品code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置产品code
     *
     * @param code 产品code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取排序字段
     *
     * @return order - 排序字段
     */
    public Byte getOrder() {
        return order;
    }

    /**
     * 设置排序字段
     *
     * @param order 排序字段
     */
    public void setOrder(Byte order) {
        this.order = order;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


}
