package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SExtensionMapper;
import com.bjst.dgt.model.SExtension;
import com.bjst.dgt.service.SExtensionService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SExtensionServiceImpl extends AbstractService<SExtension> implements SExtensionService {
    @Resource
    private SExtensionMapper sExtensionMapper;

}
