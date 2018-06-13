package com.bjst.dgt.service;

import com.bjst.dgt.dao.ProductMapper;
import com.bjst.dgt.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 行情模块service层
 * @Author: yd
 * @CreateDate: 2018/06/13 04:59 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/13 04:59 PM
 * @UpdateRemark: 行情模块service层
 * @Version: 1.0
 */
@Service
@Transactional
public class ProductService {

    @Resource
   private ProductMapper productMapper;

    /**
     * 获取行情列表
     * @return
     */
    public List<Product> getProduct(){
        return productMapper.getProduct();
    }
}
