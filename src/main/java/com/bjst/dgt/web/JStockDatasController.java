package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.JStockDatas;
import com.bjst.dgt.service.JStockDatasService;
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
@RequestMapping("/j/stock/datas")
public class JStockDatasController {
    @Resource
    private JStockDatasService jStockDatasService;

    @PostMapping("/add")
    public Result add(@RequestBody JStockDatas jStockDatas) {
        jStockDatasService.save(jStockDatas);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        jStockDatasService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody JStockDatas jStockDatas) {
        jStockDatasService.update(jStockDatas);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        JStockDatas jStockDatas = jStockDatasService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(jStockDatas);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<JStockDatas> list = jStockDatasService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
