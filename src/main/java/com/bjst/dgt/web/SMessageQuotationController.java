package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.SMessageQuotation;
import com.bjst.dgt.service.SMessageQuotationService;
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
@RequestMapping("/s/message/quotation")
public class SMessageQuotationController {
    @Resource
    private SMessageQuotationService sMessageQuotationService;

    @PostMapping("/add")
    public Result add(@RequestBody SMessageQuotation sMessageQuotation) {
        sMessageQuotationService.save(sMessageQuotation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        sMessageQuotationService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SMessageQuotation sMessageQuotation) {
        sMessageQuotationService.update(sMessageQuotation);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        SMessageQuotation sMessageQuotation = sMessageQuotationService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(sMessageQuotation);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<SMessageQuotation> list = sMessageQuotationService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
