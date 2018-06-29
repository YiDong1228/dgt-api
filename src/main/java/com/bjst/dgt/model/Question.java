package com.bjst.dgt.model;

import javax.persistence.*;

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_type_id")
    private String questionTypeId;

    /**
     * 二级标题
     */
    private String subtitle;

    /**
     * 内容
     */
    private String content;

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
     * @return question_type_id
     */
    public String getQuestionTypeId() {
        return questionTypeId;
    }

    /**
     * @param questionTypeId
     */
    public void setQuestionTypeId(String questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    /**
     * 获取二级标题
     *
     * @return subtitle - 二级标题
     */
    public String getSubtitle() {
        return subtitle;
    }

    /**
     * 设置二级标题
     *
     * @param subtitle 二级标题
     */
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    /**
     * 获取内容
     *
     * @return content - 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     *
     * @param content 内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}