package com.bjst.dgt.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import com.bjst.dgt.service.ProductService;
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

    @PostMapping("/getList")
    public Result getProducts(@RequestBody Product products) {
        List<Product> productList = productService.getProduct(products);
        return ResultGenerator.genSuccessResult(productList);
    }

    @PostMapping("/setOrder")
    public Result setOrder(HttpServletRequest request, @RequestBody Map<String,String> map){
        List<Product> productList = productService.setOrder(map);
        return ResultGenerator.genSuccessResult(productList);
    }
}
