package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.QuestionTypeMapper;
import com.bjst.dgt.model.QuestionType;
import com.bjst.dgt.service.QuestionTypeService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class QuestionTypeServiceImpl extends AbstractService<QuestionType> implements QuestionTypeService {
    @Resource
    private QuestionTypeMapper questionTypeMapper;

}
