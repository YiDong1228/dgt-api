package com.bjst.dgt.service;

import com.bjst.dgt.dao.BankCardMapper;
import com.bjst.dgt.model.BankCard;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: BankCardService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:22 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:22 PM
 * @UpdateRemark: 创建BankCardService
 * @Version: 1.0
 */
@Service
@Transactional
public class BankCardService {

    @Resource
    private BankCardMapper bankCardMapper;

    /**
     * 绑定银行卡
     *
     * @param bankCard BankCard参数
     * @return 是否绑定
     */
    public boolean bindingBank(BankCard bankCard) {
        int i = bankCardMapper.bindingBank(bankCard);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取绑定银行卡列表
     *
     * @param bankCard BankCard参数
     * @return BankCard对象
     */
    public BankCard getBankList(BankCard bankCard) {
        bankCard = bankCardMapper.getBankList(bankCard);
        if (bankCard != null) {
            return bankCard;
        } else {
            return bankCard;
        }
    }

    /**
     * 解绑银行卡
     *
     * @param bankCard BankCard参数
     * @return 是否解绑
     */
    public boolean removeBank(BankCard bankCard) {
        int i = bankCardMapper.removeBank(bankCard);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

}
