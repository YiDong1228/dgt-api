package com.bjst.dgt.service;

import com.bjst.dgt.dao.BankCardTypeMapper;
import com.bjst.dgt.model.BankCardType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: BankCardTypeService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:23 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:23 PM
 * @UpdateRemark: 创建BankCardTypeService
 * @Version: 1.0
 */
@Service
@Transactional
public class BankCardTypeService {

    @Resource
    private BankCardTypeMapper bankCardTypeMapper;

    /**
     * 获取系统银行类型
     *
     * @return 系统银行类型集合
     */
    public List<BankCardType> getBankTypeList() {
        List<BankCardType> bankCardTypeList = bankCardTypeMapper.getBankTypeList();
        if (bankCardTypeList != null && bankCardTypeList.size() > 0) {
            return bankCardTypeList;
        } else {
            return null;
        }
    }

}
