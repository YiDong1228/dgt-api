package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Trade;

public interface TradeMapper extends Mapper<Trade> {

    Trade getTradeByExchangeIdAndOrderSysId(String exchangeId, String orderSysId);
}