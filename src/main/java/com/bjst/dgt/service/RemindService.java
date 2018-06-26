package com.bjst.dgt.service;

import com.bjst.dgt.dao.RemindMapper;
import com.bjst.dgt.model.Remind;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 获取价格预警
 * @Author: yd
 * @CreateDate: 2018/06/15 05:04 PM
 * @UpdateUser: yd
 * @UpdateDate: 2018年6月26日13:36:07
 * @UpdateRemark: 添加Redis缓存
 * @Version: 1.0
 */
@Service
@Transactional
public class RemindService {

    @Resource
    private RemindMapper remindMapper;

    @Resource
    private RedisService redisService;

    public Remind getRemindById(Remind remind) {
        Remind re = new Remind();
        /*boolean exists = redisService.exists("getRemindById");
        if (exists) {
            List list = (List) redisService.get("getRemindById");
            Object[] objects = (Object[]) list.get(0);
            re.setId((Integer) objects[0]);
            re.setUserId((Integer) objects[1]);
            re.setCode((String) objects[2]);
            re.setMaxPrice((BigDecimal) objects[3]);
            re.setMinPrice((BigDecimal) objects[4]);
            re.setMaxCount((BigDecimal) objects[5]);
            re.setMinCount((BigDecimal) objects[6]);
            re.setRemind((Byte) objects[7]);
            return re;
        } else {*/
        re = remindMapper.getRemindById(remind);
        //redisService.lPush("getRemindById", re);
        if (re != null) {
            return re;
        } else {
            return null;
        }
        //}
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
}
