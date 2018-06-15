package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.Remind;

public interface RemindMapper extends Mapper<Remind> {

    /**
     * 获取价格预警
     * @param remind Remind对象
     * @return Remind对象
     */
    Remind getRemindById(Remind remind);

    /**
     * 设置价格预警
     * @param remind Remind对象
     * @return 受影响行数
     */
    int insertRemindByUserId(Remind remind);

    /**
     * 更新价格预警
     * @param remind Remind对象
     * @return 受影响行数
     */
    int updateRemindByUserId(Remind remind);

}