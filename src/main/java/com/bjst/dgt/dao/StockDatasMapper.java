package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.StockDatas;

public interface StockDatasMapper extends Mapper<StockDatas> {
    /**
     * 实时更新第三方行情数据接口
     * @param stockDatas StockDatas对象
     * @return 受影响的行数
     */
    int updateDataByCode(StockDatas stockDatas);

    /**
     * 获取产品详情
     * @param stockDatas StockDatas对象
     * @return StockDatas对象
     */
    StockDatas getStockDatas(StockDatas stockDatas);
}