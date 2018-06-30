package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.BankCardType;

import java.util.List;

public interface BankCardTypeMapper extends Mapper<BankCardType> {
    /**
     * 获取系统银行类型
     *
     * @return 系统银行类型集合
     */
    List<BankCardType> getBankTypeList();
}