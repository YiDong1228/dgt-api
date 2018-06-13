package com.bjst.dgt.dao;

import com.bjst.dgt.core.Mapper;
import com.bjst.dgt.model.AppConfig;

public interface AppConfigMapper extends Mapper<AppConfig> {

    AppConfig getAppConfig(String version);
}