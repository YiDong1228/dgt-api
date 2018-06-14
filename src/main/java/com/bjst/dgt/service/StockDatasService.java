package com.bjst.dgt.service;

import com.bjst.dgt.core.wsGetHTML;
import com.bjst.dgt.dao.ProductMapper;
import com.bjst.dgt.dao.StockDatasMapper;
import com.bjst.dgt.model.Product;
import com.bjst.dgt.model.StockDatas;
import com.bjst.dgt.model.UserProductOrder;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @Description: StockDatas
 * @Author: yd
 * @CreateDate: 2018/06/14 02:30 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/14 02:30 PM
 * @UpdateRemark: StockDatas
 * @Version: 1.0
 */
@Service
@Transactional
public class StockDatasService {

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
}
