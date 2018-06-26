package com.bjst.dgt.schedules;

import com.bjst.dgt.service.StockDatasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by zll on 2018/6/14.
 * 行情定时器
 */
@Component
@EnableScheduling
public class QuotationSchedule {

    @Autowired
    private StockDatasService stockDatasService;

    /**
     * 每秒一次，周一到周六, 此处与根据当前时区及“一周的第*天”相关
     */
    @Scheduled(cron = "1/1 * * * * 1-6")
    public void quotationTimer() {
        System.out.println("here" + new Random().nextInt(1000));
        stockDatasService.getProdects();
    }
}
