package com.bjst.dgt.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "s_news")
public class SNews {
    /**
     * 新闻编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 新闻名称
     */
    private String name;

    /**
     * 发布时间
     */
    private Date newstime;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 获取新闻编号
     *
     * @return id - 新闻编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置新闻编号
     *
     * @param id 新闻编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取新闻名称
     *
     * @return name - 新闻名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置新闻名称
     *
     * @param name 新闻名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取发布时间
     *
     * @return newstime - 发布时间
     */
    public Date getNewstime() {
        return newstime;
    }

    /**
     * 设置发布时间
     *
     * @param newstime 发布时间
     */
    public void setNewstime(Date newstime) {
        this.newstime = newstime;
    }

    /**
     * 获取新闻内容
     *
     * @return content - 新闻内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置新闻内容
     *
     * @param content 新闻内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}