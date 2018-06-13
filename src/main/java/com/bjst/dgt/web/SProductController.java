package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.SProduct;
import com.bjst.dgt.service.SProductService;
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
@RequestMapping("/s/product")
public class SProductController {
    @Resource
    private SProductService sProductService;

    @PostMapping("/add")
    public Result add(@RequestBody SProduct sProduct) {
        sProductService.save(sProduct);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        sProductService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SProduct sProduct) {
        sProductService.update(sProduct);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        SProduct sProduct = sProductService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(sProduct);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<SProduct> list = sProductService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
