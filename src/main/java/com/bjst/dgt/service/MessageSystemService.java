package com.bjst.dgt.service;

import com.bjst.dgt.dao.MessageSystemMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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



}
