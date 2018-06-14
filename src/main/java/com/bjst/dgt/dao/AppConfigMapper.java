package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.AppConfig;

import java.util.List;

/**
 * Created by zll on 2018/6/13.
 *
 * app 基础模块 mapper
 */
public interface AppConfigMapper extends Mapper<AppConfig> {

    List<AppConfig> getAppConfig(AppConfig appConfig);
}