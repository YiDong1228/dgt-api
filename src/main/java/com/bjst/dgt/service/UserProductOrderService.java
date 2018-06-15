package com.bjst.dgt.service;

import com.bjst.dgt.dao.UserProductOrderMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    public boolean getUserProducByUserId(UserProductOrder userProductOrder) {
        int i = userProductOrderMapper.getUserProducByUserId(userProductOrder);
        if (i == 15) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updateUserProductOrderByUserId(UserProductOrder userProductOrder) {
        int i = userProductOrderMapper.updateUserProductOrderByUserId(userProductOrder);
        if (i > 0) {
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
        List<Product> productList = userProductOrderMapper.getUserProductOrderByUserId(userProductOrder);
        if (productList != null && productList.size() > 0) {
            return productList;
        } else {
            return null;
        }
    }
}
