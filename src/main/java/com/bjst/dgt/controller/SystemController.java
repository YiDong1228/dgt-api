package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.AppConfig;
import com.bjst.dgt.service.SystemService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by zll on 2018/6/13.
 *
 * app 基础模块
 */
@RestController
@RequestMapping("sys")
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
        //appConfig = systemService.findById(appConfig.getId());
        appConfig = systemService.getAppConfig(appConfig.getVersion());
        return ResultGenerator.genSuccessResult(appConfig);
    }
}
