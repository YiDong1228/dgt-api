package com.bjst.dgt.service;

import com.bjst.dgt.dao.MessageQuotationMapper;
import com.bjst.dgt.model.MessageQuotation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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

    public List<MessageQuotation> getPriceWarning(MessageQuotation messageQuotation) {
        List<MessageQuotation> messageQuotationList = messageQuotationMapper.getPriceWarning(messageQuotation);
        if (messageQuotationList != null && messageQuotationList.size() > 0) {
            return messageQuotationList;
        } else {
            return null;
        }
    }

}
