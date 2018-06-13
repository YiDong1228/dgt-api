package com.bjst.dgt.service;

import com.bjst.dgt.core.AbstractService;
import com.bjst.dgt.dao.AppConfigMapper;
import com.bjst.dgt.model.AppConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/6/13.
 */
@Service
@Transactional
public class SystemService {
    @Resource
    private AppConfigMapper appConfigMapper;

    public AppConfig getAppConfig(String version) {
        return appConfigMapper.getAppConfig(version);
    }
}
