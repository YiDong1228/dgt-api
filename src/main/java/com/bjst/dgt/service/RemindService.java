package com.bjst.dgt.service;

import com.bjst.dgt.dao.RemindMapper;
import com.bjst.dgt.model.Remind;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description: 获取价格预警
 * @Author: yd
 * @CreateDate: 2018/06/15 05:04 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018/06/15 05:04 PM
 * @UpdateRemark: 获取价格预警
 * @Version: 1.0
 */
@Service
@Transactional
public class RemindService {

    @Resource
    private RemindMapper remindMapper;

    public Remind getRemindById(Remind remind) {
        Remind re = remindMapper.getRemindById(remind);
        if (re != null) {
            return re;
        } else {
            return null;
        }
    }

    public boolean insertRemindByUserId(Remind remind) {
        Remind remin = getRemindById(remind);
        if (remin != null) {
            int i = remindMapper.updateRemindByUserId(remind);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            int i = remindMapper.insertRemindByUserId(remind);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean updateRemindByUserId(Remind remind) {
        int i = remindMapper.updateRemindByUserId(remind);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
}
