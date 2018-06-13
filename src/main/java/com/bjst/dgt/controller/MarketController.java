package com.bjst.dgt.controller;

import com.bjst.dgt.core.Result;
import com.bjst.dgt.core.ResultGenerator;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/getList")
    public Result getProducts(@RequestBody List<Product> productList) {
        productList = productService.getProduct();
        if (productList != null) {
            return ResultGenerator.genSuccessResult(productList);
        } else {
            return  ResultGenerator.genFailResult("查询信息为空！");
        }
    }
}
