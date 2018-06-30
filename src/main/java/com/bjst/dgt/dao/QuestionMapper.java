package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Question;

import java.util.List;

public interface QuestionMapper extends Mapper<Question> {
    List<Question> getCommonProblems(Question question);
}