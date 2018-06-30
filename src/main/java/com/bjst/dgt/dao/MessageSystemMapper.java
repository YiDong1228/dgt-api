package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.MessageSystem;

import java.util.List;

public interface MessageSystemMapper extends Mapper<MessageSystem> {
    /**
     * 系统通知列表
     *
     * @return 系统通知列表集合
     */
    List<MessageSystem> getSystemNotic();
}