package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.MessageQuotation;

import java.util.List;

public interface MessageQuotationMapper extends Mapper<MessageQuotation> {

    /**
     * 价格预警列表
     *
     * @param messageQuotation MessageQuotation参数
     * @return 价格预警列表
     */
    List<MessageQuotation> getPriceWarning(MessageQuotation messageQuotation);
}