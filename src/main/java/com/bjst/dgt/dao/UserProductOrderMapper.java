package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.UserProductOrder;

import java.util.List;

public interface UserProductOrderMapper extends Mapper<UserProductOrder> {
    /**
     * 新增用户自定义排序
     * @param userProductOrder UserProductOrder对象
     * @return 受影响行数
     */
    int insertUserProductOrderByUserId(UserProductOrder userProductOrder);

    /**
     * 获取用户自定义排序
     * @param userProductOrder UserProductOrder对象
     * @return 自定义排序的产品列表
     */
    List<Product> getUserProductOrderByUserId(UserProductOrder userProductOrder);

    /**
     * 获取用户是否已经自定义排序
     * @param userProductOrder UserProductOrder对象
     * @return 用户自定义排序行数
     */
    int getUserProducByUserId(UserProductOrder userProductOrder);

    /**
     * 当用户已经自定义排序时再进行自定义排序时的更新操作
     * @param userProductOrder UserProductOrder对象
     * @return 受影响行数
     */
    int updateUserProductOrderByUserId(UserProductOrder userProductOrder);
}