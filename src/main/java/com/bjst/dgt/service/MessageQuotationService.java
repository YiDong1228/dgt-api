package com.bjst.dgt.service;

import com.bjst.dgt.dao.MessageQuotationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: MessageQuotationService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:26 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:26 PM
 * @UpdateRemark: 创建MessageQuotationService
 * @Version: 1.0
 */
@Service
@Transactional
public class MessageQuotationService {

    @Resource
    private MessageQuotationMapper messageQuotationMapper;


}
