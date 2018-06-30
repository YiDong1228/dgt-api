package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.QuestionType;

import java.util.List;

public interface QuestionTypeMapper extends Mapper<QuestionType> {
    List<QuestionType> getCommonProblemsById();
}