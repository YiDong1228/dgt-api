package com.bjst.dgt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.Remind;
import com.bjst.dgt.model.StockDatas;
import com.bjst.dgt.model.UserProductOrder;
import com.bjst.dgt.service.ProductService;
import com.bjst.dgt.service.RemindService;
import com.bjst.dgt.service.StockDatasService;
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

    @PostMapping("/getList")
    public Result getProducts(@RequestBody Product products) {
        List<Product> productList = productService.getProduct(products);
        if (productList != null && productList.size() > 0) {
            return ResultGenerator.genSuccessResult(productList);
        } else {
            return ResultGenerator.genFailResult("产品列表为空！");
        }
    }

    @PostMapping("/setOrder")
    public Result setOrder(@RequestBody Map<String, String> map) {
        List<Product> productList = productService.setOrder(map);
        if (productList != null && productList.size() > 0) {
            return ResultGenerator.genSuccessResult(productList);
        } else {
            return ResultGenerator.genFailResult("产品列表为空！");
        }
    }

    @PostMapping("/getDetail")
    public Result getDetail(@RequestBody StockDatas stockDatas) {
        StockDatas datas = stockDatasService.getStockDatas(stockDatas);
        if (datas != null) {
            return ResultGenerator.genSuccessResult(datas);
        } else {
            return ResultGenerator.genFailResult("所查询的产品不存在！");
        }
    }

    @PostMapping("/GetPrewarning")
    public Result GetPrewarning(@RequestBody Remind remind) {
        Remind remin = remindService.getRemindById(remind);
        if (remin != null) {
            return ResultGenerator.genSuccessResult(remin);
        } else {
            return ResultGenerator.genFailResult("用户未设定该产品的价格预警！");
        }
    }

    @PostMapping("/SetPrewarning")
    public Result SetPrewarning(@RequestBody Remind remind) {
        boolean falg = remindService.insertRemindByUserId(remind);
        if (falg) {
            return ResultGenerator.genSuccessResult("设置价格预警成功！");
        } else {
            return ResultGenerator.genFailResult("设置价格预警失败！");
        }
    }
}
