package com.bjst.dgt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.*;
import com.bjst.dgt.service.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 行情模块
 * @Author: yd
 * @CreateDate: 2018/06/13 04:57 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/13 04:57 PM
 * @UpdateRemark: 行情模块
 * @Version: 1.0
 */
@RestController
@RequestMapping("/market")
public class MarketController {

    @Resource
    private ProductService productService;

    @Resource
    private StockDatasService stockDatasService;

    @Resource
    private RemindService remindService;

    @Resource
    private RuleService ruleService;

    @Resource
    private RedisService redisService;

    @PostMapping("/getList")
    public Result getProducts(@RequestBody Product products, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            products.setUserId(Integer.parseInt(userId));
            List<Product> productList = productService.getProduct(products);
            if (productList != null && productList.size() > 0) {
                return ResultGenerator.genSuccessResult(productList);
            } else {
                return ResultGenerator.genFailResult("产品列表为空！");
            }
        }
    }

    @PostMapping("/setOrder")
    public Result setOrder(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            map.put("userId", userId);
            List<Product> productList = productService.setOrder(map);
            if (productList != null && productList.size() > 0) {
                return ResultGenerator.genSuccessResult(productList);
            } else {
                return ResultGenerator.genFailResult("产品列表为空！");
            }
        }
    }

    @PostMapping("/getDetail")
    public Result getDetail(@RequestBody StockDatas stockDatas, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            stockDatas.setUserId(Integer.parseInt(userId));
            StockDatas datas = stockDatasService.getStockDatas(stockDatas);
            if (datas != null) {
                return ResultGenerator.genSuccessResult(datas);
            } else {
                return ResultGenerator.genFailResult("所查询的产品不存在！");
            }
        }
    }

    @PostMapping("/GetPrewarning")
    public Result GetPrewarning(@RequestBody Remind remind, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            remind.setUserId(Integer.parseInt(userId));
            Remind remin = remindService.getRemindById(remind);
            if (remin != null) {
                return ResultGenerator.genSuccessResult(remin);
            } else {
                return ResultGenerator.genFailResult("用户未设定该产品的价格预警！");
            }
        }
    }

    @PostMapping("/SetPrewarning")
    public Result SetPrewarning(@RequestBody Remind remind, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            remind.setUserId(Integer.parseInt(userId));
            boolean falg = remindService.insertRemindByUserId(remind);
            if (falg) {
                return ResultGenerator.genSuccessResult("设置价格预警成功！");
            } else {
                return ResultGenerator.genFailResult("设置价格预警失败！");
            }
        }
    }

    @PostMapping("/getStatusAndRule")
    public Result getStatusAndRule(@RequestBody Rule rule, HttpServletRequest request) {
        String token = request.getHeader("token");
        String userId = request.getHeader("userId");
        String checkToken = (String) redisService.get(ProjectConstant.DGT_LOGIN_TOKEN_KEY + userId);
        if (!token.equalsIgnoreCase(checkToken)) {
            return ResultGenerator.genFailResult("token验证错误！");
        } else {
            rule.getUserId(Integer.parseInt(userId));
            Rule ru = ruleService.getRuleById(rule);
            if (ru != null) {
                return ResultGenerator.genSuccessResult(ru);
            } else {
                return ResultGenerator.genFailResult("所查询的产品状态规则不存在！");
            }
        }
    }
}
