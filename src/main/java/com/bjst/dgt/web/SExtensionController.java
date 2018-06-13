package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.SExtension;
import com.bjst.dgt.service.SExtensionService;
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
@RequestMapping("/s/extension")
public class SExtensionController {
    @Resource
    private SExtensionService sExtensionService;

    @PostMapping("/add")
    public Result add(@RequestBody SExtension sExtension) {
        sExtensionService.save(sExtension);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        sExtensionService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SExtension sExtension) {
        sExtensionService.update(sExtension);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        SExtension sExtension = sExtensionService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(sExtension);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<SExtension> list = sExtensionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
