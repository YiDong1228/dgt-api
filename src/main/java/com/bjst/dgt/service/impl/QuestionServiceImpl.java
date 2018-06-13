package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.QuestionMapper;
import com.bjst.dgt.model.Question;
import com.bjst.dgt.service.QuestionService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class QuestionServiceImpl extends AbstractService<Question> implements QuestionService {
    @Resource
    private QuestionMapper questionMapper;

}
