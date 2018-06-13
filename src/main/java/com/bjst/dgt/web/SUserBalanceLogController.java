package com.bjst.dgt.web;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.SUserBalanceLog;
import com.bjst.dgt.service.SUserBalanceLogService;
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
@RequestMapping("/s/user/balance/log")
public class SUserBalanceLogController {
    @Resource
    private SUserBalanceLogService sUserBalanceLogService;

    @PostMapping("/add")
    public Result add(@RequestBody SUserBalanceLog sUserBalanceLog) {
        sUserBalanceLogService.save(sUserBalanceLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody BaseM baseM) {
        sUserBalanceLogService.deleteById(baseM.getId());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SUserBalanceLog sUserBalanceLog) {
        sUserBalanceLogService.update(sUserBalanceLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestBody BaseM baseM) {
        SUserBalanceLog sUserBalanceLog = sUserBalanceLogService.findById(baseM.getId());
        return ResultGenerator.genSuccessResult(sUserBalanceLog);
    }

    @PostMapping("/list")
    public Result list(@RequestBody PageM pageM) {
        PageHelper.startPage(pageM.getPage(), pageM.getSize());
        List<SUserBalanceLog> list = sUserBalanceLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}