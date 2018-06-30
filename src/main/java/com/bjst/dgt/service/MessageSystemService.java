package com.bjst.dgt.service;

import com.bjst.dgt.dao.MessageSystemMapper;
import com.bjst.dgt.model.MessageSystem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: MessageSystemService层
 * @Author: yd
 * @CreateDate: 2018/06/27 05:25 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/27 05:25 PM
 * @UpdateRemark: 创建MessageSystemService
 * @Version: 1.0
 */
@Service
@Transactional
public class MessageSystemService {

    @Resource
    private MessageSystemMapper messageSystemMapper;

    /**
     * 系统通知列表
     *
     * @return 系统通知列表集合
     */
    public List<MessageSystem> getSystemNotic() {
        List<MessageSystem> messageSystemList = messageSystemMapper.getSystemNotic();
        if (messageSystemList != null && messageSystemList.size() > 0) {
            return messageSystemList;
        } else {
            return null;
        }
    }

}
