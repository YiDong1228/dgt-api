package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.SNews;
import com.bjst.dgt.service.SNewsService;
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
@RequestMapping("/s/news")
public class SNewsController {
    @Resource
    private SNewsService sNewsService;

    @PostMapping("/add")
    public Result add(@RequestBody SNews sNews) {
        sNewsService.save(sNews);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        sNewsService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SNews sNews) {
        sNewsService.update(sNews);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        SNews sNews = sNewsService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(sNews);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<SNews> list = sNewsService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
