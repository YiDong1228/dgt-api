package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.AppConfig;
import com.bjst.dgt.service.SystemService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zll on 2018/6/13.
 *
 * app 基础模块
 */
@RestController
@RequestMapping("/sys")
public class SystemController {

    @Resource
    private SystemService systemService;

    /**
     * 获得对应平台的版本信息
     * @param appConfig 通过verion进行查询，测试用
     * @return 返回对应平台（Android、iOS）信息
     */
    @PostMapping("/getAppConfig")
    public Result getAppConfig(@RequestBody AppConfig appConfig) {
        appConfig = systemService.getAppConfig(appConfig);
        return ResultGenerator.genSuccessResult(appConfig);
    }


}
