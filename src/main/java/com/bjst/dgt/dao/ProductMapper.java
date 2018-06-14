package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Product;

import java.util.List;

public interface ProductMapper extends Mapper<Product> {
    List<Product> getProduct();
}