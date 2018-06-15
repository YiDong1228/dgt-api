package com.bjst.dgt.service;

import com.bjst.dgt.core.AbstractService;
import com.bjst.dgt.core.ProjectConstant;
import com.bjst.dgt.dao.AppConfigMapper;
import com.bjst.dgt.model.AppConfig;
import com.google.common.collect.MoreCollectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by zll on 2018/6/13.
 */
@Service
@Transactional
public class SystemService {
    @Resource
    private AppConfigMapper appConfigMapper;

    /**
     * 获得app配置信息
     * @param appConfig
     * @return
     */
    public AppConfig getAppConfig(AppConfig appConfig) {
        AppConfig result = null;
        if (null == appConfig || StringUtils.isEmpty(appConfig.getPlatformType()) || StringUtils.isEmpty(appConfig.getVersion())) {
            return  result;
        }
        List<AppConfig> configs =  appConfigMapper.getAppConfig(appConfig);
        if (null != configs && configs.size() > 0 ){
            result = configs.get(0);

            // 是否是强制更新
            if (appConfig.getPlatformType() == ProjectConstant.PLATFORM_ANDROID) {
                // 获得强制更新的版本列表
                List<AppConfig> filterConfigs = configs.stream()
                        .filter(config -> config.getIsRape() == ProjectConstant.PLATFORM_RAPE)
                        .collect(Collectors.toList());
                if (null != filterConfigs && filterConfigs.size() > 0) {
                    result = filterConfigs.get(0);
                }
            }
        }

        return result;
    }
}
