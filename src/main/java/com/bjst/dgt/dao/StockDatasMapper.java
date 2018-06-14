package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.StockDatas;

public interface StockDatasMapper extends Mapper<StockDatas> {
    int updateDataByCode(StockDatas stockDatas);
}