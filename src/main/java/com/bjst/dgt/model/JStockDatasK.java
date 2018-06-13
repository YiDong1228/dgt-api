package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_stock_datas_k")
public class JStockDatasK {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 产品Code
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 1：1分钟K线，5：5分钟K线，依次类推
     */
    @Column(name = "data_type")
    private Integer dataType;

    /**
     * 数据奕化时间
     */
    private Date times;

    /**
     * K线内容
     */
    @Column(name = "data_content")
    private String dataContent;

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
     * 获取产品Code
     *
     * @return product_code - 产品Code
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置产品Code
     *
     * @param productCode 产品Code
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 获取1：1分钟K线，5：5分钟K线，依次类推
     *
     * @return data_type - 1：1分钟K线，5：5分钟K线，依次类推
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 设置1：1分钟K线，5：5分钟K线，依次类推
     *
     * @param dataType 1：1分钟K线，5：5分钟K线，依次类推
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取数据奕化时间
     *
     * @return times - 数据奕化时间
     */
    public Date getTimes() {
        return times;
    }

    /**
     * 设置数据奕化时间
     *
     * @param times 数据奕化时间
     */
    public void setTimes(Date times) {
        this.times = times;
    }

    /**
     * 获取K线内容
     *
     * @return data_content - K线内容
     */
    public String getDataContent() {
        return dataContent;
    }

    /**
     * 设置K线内容
     *
     * @param dataContent K线内容
     */
    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }
}