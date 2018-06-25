package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.AppConfig;
import com.bjst.dgt.service.RedisService;
import com.bjst.dgt.service.SystemService;
import com.bjst.dgt.service.TradeService;
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
    @Resource
    private TradeService tradeService;
    @Resource
    private RedisService redisService;

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

    @GetMapping("test")
    public String test(@RequestParam String name, @RequestParam String pwd) {
       tradeService.tradeInnerLogin(name,pwd);
       //tradeService.tradeOuterLogin(name,pwd);

        return "dd";
    }

    @GetMapping("redis")
    public String testRedis() {
        boolean exist = redisService.exists("z101");
        System.out.println(exist);
        redisService.add("z101", "q111");
        exist = redisService.exists("z101");
        System.out.println(exist);
        return "success";
    }
}
