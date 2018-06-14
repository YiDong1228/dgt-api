package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.StockDatas;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {
    List<Product> getProduct();
    int updatePriceByCode(StockDatas stockDatas);
}