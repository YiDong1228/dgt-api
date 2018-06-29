package com.bjst.dgt.model;

import javax.persistence.*;

@Table(name = "question_type")
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * xx问题？
     */
    @Column(name = "type_name")
    private String typeName;

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
     * 获取xx问题？
     *
     * @return type_name - xx问题？
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置xx问题？
     *
     * @param typeName xx问题？
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}