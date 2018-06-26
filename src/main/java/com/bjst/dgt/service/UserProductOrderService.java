package com.bjst.dgt.service;

import com.bjst.dgt.dao.UserProductOrderMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 用户产品自定义排序
 * @Author: yd
 * @CreateDate: 2018/06/14 01:45 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/14 01:45 PM
 * @UpdateRemark: 用户产品自定义排序
 * @Version: 1.0
 */
@Service
@Transactional
public class UserProductOrderService {

    @Resource
    private UserProductOrderMapper userProductOrderMapper;

    @Resource
    private RedisService redisService;

    public boolean getUserProducByUserId(UserProductOrder userProductOrder) {
        boolean exists = redisService.exists("order");
        int i = 0;
        if (exists) {
            i = (int) redisService.get("order");
            if (i == 15) {
                return true;
            } else {
                return false;
            }
        } else {
            i = userProductOrderMapper.getUserProducByUserId(userProductOrder);
            redisService.set("order", i);
            if (i == 15) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateUserProductOrderByUserId(UserProductOrder userProductOrder) {
        boolean exists = redisService.exists("updateOrderByUserId");
        int j = 0;
        if (exists) {
            j = (int) redisService.get("updateOrderByUserId");
            if (j > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            j = userProductOrderMapper.updateUserProductOrderByUserId(userProductOrder);
            redisService.set("updateOrderByUserId", j);
            if (j > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean insertUserProductOrderByUserId(UserProductOrder userProductOrder) {
        boolean exists = redisService.exists("insertUserProductOrderByUserId");
        int i = 0;
        if (exists) {
            i = (int) redisService.get("insertUserProductOrderByUserId");
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            i = userProductOrderMapper.insertUserProductOrderByUserId(userProductOrder);
            redisService.set("insertUserProductOrderByUserId", i);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public List<Product> getUserProductOrderByUserId(UserProductOrder userProductOrder) {
        List<Product> productList = new ArrayList<Product>();
        /*boolean exists = redisService.exists("getUserProductOrderByUserId");
        if (exists) {
            List<Object> objList = redisService.lRange("getUserProductOrderByUserId", 0, 15);
            for (int i = 0; i < objList.size(); i++) {
                Product product = new Product();
                Object[] objects = (Object[]) objList.get(i);
                productList.add(product);
            }
        } else {*/
        productList = userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
        /*    redisService.lPush("getUserProductOrderByUserId", productList);
        }*/

        if (productList != null && productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }
}
