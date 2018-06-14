package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.UserProductOrder;

import java.util.List;

public interface UserProductOrderMapper extends Mapper<UserProductOrder> {
    int insertUserProductOrderByUserId(UserProductOrder userProductOrder);
    List<UserProductOrder> getUserProductOrderByUserId(String userId);
}