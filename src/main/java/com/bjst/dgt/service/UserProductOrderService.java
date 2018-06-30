package com.bjst.dgt.service;

import com.bjst.dgt.core.ProjectConstant;
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

    /**
     * 获取用户是否已经自定义排序
     *
     * @param userProductOrder UserProductOrder对象
     * @return 用户自定义排序行数
     */
    public boolean getUserProducByUserId(UserProductOrder userProductOrder) {
        int i = userProductOrderMapper.getUserProducByUserId(userProductOrder);
        if (i == 15) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 当用户已经自定义排序时再进行自定义排序时的更新操作
     *
     * @param userProductOrder UserProductOrder对象
     * @return 是否更新
     */
    public boolean updateUserProductOrderByUserId(UserProductOrder userProductOrder) {
        int j = userProductOrderMapper.updateUserProductOrderByUserId(userProductOrder);
        if (j > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 新增用户自定义排序
     *
     * @param userProductOrder UserProductOrder对象
     * @return 是否新增成功
     */
    public boolean insertUserProductOrderByUserId(UserProductOrder userProductOrder) {
        int i = userProductOrderMapper.insertUserProductOrderByUserId(userProductOrder);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取用户自定义排序
     *
     * @param userProductOrder UserProductOrder对象
     * @return 自定义排序的产品列表
     */
    public List<Product> getUserProductOrderByUserId(UserProductOrder userProductOrder) {
        List<Product> productList = new ArrayList<Product>();
        boolean exists = redisService.exists(ProjectConstant.MARKET_GETUSERPRODUCTORDER + userProductOrder.getUserId());
        if (exists) {
            productList = (List<Product>) redisService.get(ProjectConstant.MARKET_GETUSERPRODUCTORDER + userProductOrder.getUserId());
        } else {
            productList = userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
            redisService.set(ProjectConstant.MARKET_GETUSERPRODUCTORDER + userProductOrder.getUserId(), productList, new Long(800), TimeUnit.MILLISECONDS);
        }
        if (productList != null && productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }
}
