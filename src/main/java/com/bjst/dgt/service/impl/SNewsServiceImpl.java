package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SNewsMapper;
import com.bjst.dgt.model.SNews;
import com.bjst.dgt.service.SNewsService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SNewsServiceImpl extends AbstractService<SNews> implements SNewsService {
    @Resource
    private SNewsMapper sNewsMapper;

}
