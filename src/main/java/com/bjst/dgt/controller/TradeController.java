package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.TradingRules;
import com.bjst.dgt.service.TradingRulesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zll on 2018/6/22.
 */
@RestController
@RequestMapping("/trader")
public class TradeController {

    @Resource
    private TradingRulesService tradingRulesService;

    @PostMapping("/getTradingRule")
    public Result getTradingRule(@RequestBody TradingRules rules){
        TradingRules tradingRules= tradingRulesService.getTradingRulesByCode(rules);
        if(tradingRules != null){
            return ResultGenerator.genSuccessResult(tradingRules);
        }else{
            return ResultGenerator.genFailResult("该产品没有计算规则！");
        }
    }
}
