package com.bjst.dgt.service;

import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.dao.ProductMapper;
import com.bjst.dgt.dao.UserProductOrderMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import org.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private UserProductOrderMapper userProductOrderMapper;

    /**
     * 获取行情列表
     *
     * @return
     */
    public List<Product> getProduct(Product products) {
        List<Product> productList = productMapper.getProduct();
        if (products.getOrder() == ProjectConstant.SORT_DEFAULT) {
            //默认排序
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    if (p1.getOrder() > p2.getOrder()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (products.getOrder() == ProjectConstant.SORT_ZHENGXU) {
            //正序
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    if (p1.getOrder() > p2.getOrder()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        } else if (products.getOrder() == ProjectConstant.SORT_DAOXU) {
            //倒序
            Collections.sort(productList, new Comparator<Product>() {
                @Override
                public int compare(Product p1, Product p2) {
                    if (p1.getOrder() < p2.getOrder()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });
        }
        return productList;
    }

    public List<Product> setOrder(Map<String,String> map) {
        UserProductOrder userProductOrder=new UserProductOrder();
        String order=map.get("order");
        order=order.substring(1,order.length()-1);
        String orders[] = order.split(",");
        for (int i=0;i<15;i++) {
            userProductOrder.setUserId(1);
            userProductOrder.setOrder(Byte.valueOf(orders[i]));
            userProductOrder.setCode("SCag0001");
            int add=userProductOrderMapper.insertUserProductOrderByUserId(userProductOrder);
        }
        List<Product> userProductOrderList=userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
        /*List<Product> productList = productMapper.getProduct();

        if (productList != null) {

        } else {
            return null;
        }*/
        return userProductOrderList;
    }

}
