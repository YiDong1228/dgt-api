package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.BankCard;

public interface BankCardMapper extends Mapper<BankCard> {
    /**
     * 绑定银行卡
     *
     * @param bankCard BankCard参数
     * @return 受影响行数
     */
    int bindingBank(BankCard bankCard);

    /**
     * 获取绑定银行卡列表
     *
     * @param bankCard BankCard参数
     * @return BankCard对象
     */
    BankCard getBankList(BankCard bankCard);

    /**
     * 解绑银行卡
     *
     * @param bankCard BankCard参数
     * @return 受影响行数
     */
    int removeBank(BankCard bankCard);
}