package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "app_config")
public class AppConfig {
    /**
     * 版本标识id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 1：安卓，2：iOS
     */
    @Column(name = "platform_type")
    private Byte platformType;

    /**
     * 版本号,iOS、Android平台
     */
    private String version;
    /**
     * apk下载地址
     */
    @Column(name = "apk_url")
    private String apkUrl;

    /**
     * explanation
     */
    private String explanation;

    /**
     * 广告图地址
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 0：普通更新，1：强制更新
     */
    @Column(name = "is_rape")
    private Byte isRape;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取版本标识id
     *
     * @return id - 版本标识id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置版本标识id
     *
     * @param id 版本标识id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取1：安卓，2：iOS
     *
     * @return platform_type - 1：安卓，2：iOS
     */
    public Byte getPlatformType() {
        return platformType;
    }

    /**
     * 设置1：安卓，2：iOS
     *
     * @param platformType 1：安卓，2：iOS
     */
    public void setPlatformType(Byte platformType) {
        this.platformType = platformType;
    }

    /**
     * 获取版本号,版本号,iOS、Android平台
     *
     * @return version - 版本号,版本号,iOS、Android平台
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号,版本号,iOS、Android平台
     *
     * @param version 版本号,iOS、Android平台
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取apk下载地址
     *
     * @return apk_url - apk下载地址
     */
    public String getApkUrl() {
        return apkUrl;
    }

    /**
     * 设置apk下载地址
     *
     * @param apkUrl apk下载地址
     */
    public void setApkUrl(String apkUrl) {
        this.apkUrl = apkUrl;
    }

    /**
     * 获取explanation
     *
     * @return explanation - explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * 设置explanation
     *
     * @param explanation explanation
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * 获取广告图地址
     *
     * @return img_url - 广告图地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置广告图地址
     *
     * @param imgUrl 广告图地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * 获取0：普通更新，1：强制更新
     *
     * @return is_rape - 0：普通更新，1：强制更新
     */
    public Byte getIsRape() {
        return isRape;
    }

    /**
     * 设置0：普通更新，1：强制更新
     *
     * @param isRape 0：普通更新，1：强制更新
     */
    public void setIsRape(Byte isRape) {
        this.isRape = isRape;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}