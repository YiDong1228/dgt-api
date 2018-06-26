package com.bjst.dgt.service;

import com.bjst.dgt.dao.UserProductOrderMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
        boolean exists = redisService.exists("getUserProducByUserId");
        int i;
        if (exists) {
            i = (int) redisService.get("getUserProducByUserId");
            if (i == 15) {
                return true;
            } else {
                return false;
            }
        } else {
            i = userProductOrderMapper.getUserProducByUserId(userProductOrder);
            redisService.set("getUserProducByUserId", i);
            if (i == 15) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateUserProductOrderByUserId(UserProductOrder userProductOrder) {
        int j = userProductOrderMapper.updateUserProductOrderByUserId(userProductOrder);
        if (j > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertUserProductOrderByUserId(UserProductOrder userProductOrder) {
        int i = userProductOrderMapper.insertUserProductOrderByUserId(userProductOrder);
        if (i > 0) {
            return true;
        } else {
            return false;
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
                product.setCode((String) objects[0]);
                product.setCodeShow((String) objects[1]);
                product.setName((String) objects[2]);
                product.setExchange((String) objects[3]);
                product.setSystemType((Byte) objects[4]);
                product.setLastPrice((BigDecimal) objects[5]);
                product.setMarket((String) objects[6]);
                product.setIsDomestic((Byte) objects[7]);
                product.setDataStatus((Byte) objects[8]);
                product.setChangeCount((BigDecimal) objects[9]);
                product.setCategroyCode((String) objects[10]);
                product.setOrder((Byte) objects[11]);
                product.setCreateTime((Date) objects[12]);
                product.setUpdateTime((Date) objects[13]);
                product.setToken((String) objects[14]);
                product.setUserId((Integer) objects[15]);
                productList.add(product);
            }
        } else {*/
        productList = userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
        //redisService.lPush("getUserProductOrderByUserId", productList);
        //}

        if (productList != null && productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }
}
