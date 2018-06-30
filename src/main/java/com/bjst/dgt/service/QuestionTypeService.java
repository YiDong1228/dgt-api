package com.bjst.dgt.service;

import com.bjst.dgt.dao.QuestionTypeMapper;
import com.bjst.dgt.model.QuestionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: QuestionTypeService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:24 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:24 PM
 * @UpdateRemark: 创建QuestionTypeService
 * @Version: 1.0
 */
@Service
@Transactional
public class QuestionTypeService {

    @Resource
    private QuestionTypeMapper questionTypeMapper;

    public List<QuestionType> getCommonProblemsById() {
        List<QuestionType> questionTypeList = questionTypeMapper.getCommonProblemsById();
        if (questionTypeList != null && questionTypeList.size() > 0) {
            return questionTypeList;
        } else {
            return null;
        }
    }

}
