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
import java.util.concurrent.TimeUnit;

/**
 * @Description: 用户产品自定义排序
 * @Author: yd
 * @CreateDate: 2018/06/14 01:45 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月26日17:37:10
 * @UpdateRemark: 添加Redis缓存
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
        /*boolean exists = redisService.exists("getUserProducByUserId");
        int i;
        if (exists) {
            i = (int) redisService.get("getUserProducByUserId");
            if (i == 15) {
                return true;
            } else {
                return false;
            }
        } else {*/
        int i = userProductOrderMapper.getUserProducByUserId(userProductOrder);
        //redisService.set("getUserProducByUserId", i);
        if (i == 15) {
            return true;
        } else {
            return false;
        }
        //}
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
        boolean exists = redisService.exists("getUserProductOrderByUserId");
        if (exists) {
            productList = (List<Product>) redisService.get("getUserProductOrderByUserId");
        } else {
            productList = userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
            redisService.set("getUserProductOrderByUserId", productList, new Long(900), TimeUnit.MILLISECONDS);
        }
        if (productList != null && productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }
}
