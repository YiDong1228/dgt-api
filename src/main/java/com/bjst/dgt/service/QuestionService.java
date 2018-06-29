package com.bjst.dgt.service;

import com.bjst.dgt.dao.QuestionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: QuestionService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:24 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:24 PM
 * @UpdateRemark: 创建QuestionService
 * @Version: 1.0
 */
@Service
@Transactional
public class QuestionService {

    @Resource
    private QuestionMapper questionMapper;



}
