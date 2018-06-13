package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.Question;
import com.bjst.dgt.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import com.bjst.dgt.model.BaseM;
import com.bjst.dgt.model.PageM;

/**
* Created by bjst on 2018/06/13.
*/
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @PostMapping("/add")
    public Result add(@RequestBody Question question) {
        questionService.save(question);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        questionService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Question question) {
        questionService.update(question);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        Question question = questionService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(question);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<Question> list = questionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
