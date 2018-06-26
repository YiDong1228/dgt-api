package com.bjst.dgt.service;

import com.bjst.dgt.core.wsGetHTML;
import com.bjst.dgt.dao.ProductMapper;
import com.bjst.dgt.dao.StockDatasMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.StockDatas;
import com.bjst.dgt.model.UserProductOrder;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: 第三方实时行情接口
 * @Author: yd
 * @CreateDate: 2018/06/14 02:30 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月26日13:35:40
 * @UpdateRemark: 添加Redis缓存
 * @Version: 1.0
 */
@Service
@Transactional
public class StockDatasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockDatasService.class);

    @Resource
    private RedisService redisService;

    @Resource
    private StockDatasMapper stockDatasMapper;

    @Resource
    private ProductMapper productMapper;

    public void getProdects() {
        StockDatas stockDatas = new StockDatas();
        wsGetHTML ws = new wsGetHTML();
        String str = ws.getHTMLproduct();
        JSONArray jsonArray = new JSONArray(str);
        for (int i = 0; i < jsonArray.length(); i++) {
            stockDatas.setLastPrice(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("NewPrice").toString())));
            stockDatas.setChangeCount(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("PriceChangeRatio").toString())));
            stockDatas.setCode((String) jsonArray.getJSONObject(i).get("Symbol"));
            productMapper.updatePriceByCode(stockDatas);

            stockDatas.setAmount(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("Amount").toString())));
            stockDatas.setVolume(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("Volume").toString())));
            stockDatas.setChangeCount(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("PriceChangeRatio").toString())));
            stockDatas.setHigh(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("High").toString())));
            stockDatas.setLow(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("Low").toString())));
            stockDatas.setOpen(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("Open").toString())));
            stockDatas.setClose(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("LastClose").toString())));
            stockDatas.setLastPrice(BigDecimal.valueOf(Double.valueOf(jsonArray.getJSONObject(i).get("NewPrice").toString())));
            stockDatas.setCode(jsonArray.getJSONObject(i).get("Symbol").toString());
            stockDatas.setBv(jsonArray.getJSONObject(i).get("BV1").toString());
            stockDatas.setSv(jsonArray.getJSONObject(i).get("SV1").toString());
            stockDatas.setBp(jsonArray.getJSONObject(i).get("BP1").toString());
            stockDatas.setSp(jsonArray.getJSONObject(i).get("SP1").toString());
            stockDatasMapper.updateDataByCode(stockDatas);
        }
    }

    public StockDatas getStockDatas(StockDatas stockDatas) {
        StockDatas datas = new StockDatas();
        /*boolean exists = redisService.exists("getStockDatas");
        if (exists) {
            List list = (List) redisService.get("getStockDatas");
            Object[] objects = (Object[]) list.get(0);
            datas.setId((Integer) objects[0]);
            datas.setCode((String) objects[1]);
            datas.setLastPrice((BigDecimal) objects[2]);
            datas.setHigh((BigDecimal) objects[3]);
            datas.setLow((BigDecimal) objects[4]);
            datas.setOpen((BigDecimal) objects[5]);
            datas.setClose((BigDecimal) objects[6]);
            datas.setVolume((BigDecimal) objects[7]);
            datas.setAmount((BigDecimal) objects[8]);
            datas.setBv((String) objects[9]);
            datas.setBp((String) objects[10]);
            datas.setSp((String) objects[11]);
            datas.setSv((String) objects[12]);
            datas.setDataStatus((Byte) objects[13]);
            datas.setChangeCount((BigDecimal) objects[14]);
            datas.setAddTime((Date) objects[15]);
            datas.setToken((String) objects[16]);
            datas.setUserId((Integer) objects[17]);
            datas.setUndulate((BigDecimal) objects[18]);
            datas.setUpsDowns((BigDecimal) objects[19]);
            datas.setVelocity((Integer) objects[20]);
            return datas;
        } else {*/
        datas = stockDatasMapper.getStockDatas(stockDatas);
        if (stockDatas != null) {
            datas.setUndulate(datas.getHigh().subtract(datas.getLow()));
            datas.setUpsDowns(datas.getLastPrice().subtract(datas.getClose()));
            datas.setVelocity(datas.getChangeCount().setScale(2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).intValue());
            //redisService.lPush("getStockDatas", stockDatas);
            return datas;
        } else {
            return null;
        }
        //}
    }
}
