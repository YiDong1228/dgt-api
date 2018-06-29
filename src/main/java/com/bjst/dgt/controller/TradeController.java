package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.Trade;
import com.bjst.dgt.model.TradingRules;
import com.bjst.dgt.service.RedisService;
import com.bjst.dgt.service.TradeService;
import com.bjst.dgt.service.TradingRulesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zll on 2018/6/22.
 */
@RestController
@RequestMapping("/trader")
public class TradeController {

    @Resource
    private TradingRulesService tradingRulesService;
    @Resource
    private TradeService tradeService;
    @Resource
    private RedisService redisService;

    @PostMapping("/getTradingRule")
    public Result getTradingRule(@RequestBody TradingRules rules){
        TradingRules tradingRules= tradingRulesService.getTradingRulesByCode(rules);
        if(tradingRules != null){
            return ResultGenerator.genSuccessResult(tradingRules);
        }else{
            return ResultGenerator.genFailResult("该产品没有计算规则！");
        }
    }

    @PostMapping("postOrder")
    public Result placeOrder(@RequestBody Trade trade, HttpServletRequest request) {

        // 获取token
//        String userKey = request.getHeader(ProjectConstant.DGT_LOGIN_USER_ID_KEY);
//        if (StringUtils.isEmpty(userKey)) {
//            return ResultGenerator.genFailResult("userID 异常", ResultCode.UNAUTHORIZED);
//        }
//        trade.setUserId(Integer.valueOf(userKey));
//
//        // 根据token 和对应的内外盘标识， 获得对应内外盘用户标识
//        Object userId = redisService.hmGet(userKey,ProjectConstant.DGT_LOGIN_OUTER_USER_KEY);
//        if (trade.getInnerOuterDisc() == ProjectConstant.TRADE_INNER_DISC_FLAG) {
//            userId = redisService.hmGet(userKey,ProjectConstant.DGT_LOGIN_INNER_USER_KEY);
//
//        }
//
//        if (userId == null) {
//            return ResultGenerator.genFailResult("userID 异常",ResultCode.UNAUTHORIZED);
//        }
//        tradeService.placeOrder(userId.toString(), trade);
        //trade.setUserId(userKey);
        trade.setUserId(1);
        return tradeService.placeOrder("testwai001", trade);
    }

    /**
     *  查询持仓
     * @param request
     * @return
     */
    @PostMapping("getPositionList")
    public Result getPositionList(HttpServletRequest request) {
        return tradeService.getPositionList("testwai001");
    }

    @PostMapping("testlogin")
    public Result testLogin(@RequestParam String userId, @RequestParam String pwd) {
        tradeService.tradeOuterLogin("1", userId, pwd);
        return ResultGenerator.genSuccessResult();
    }
}
