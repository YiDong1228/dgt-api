package com.bjst.dgt.service.impl;

import com.bjst.dgt.dao.SPromotionMapper;
import com.bjst.dgt.model.SPromotion;
import com.bjst.dgt.service.SPromotionService;
import com.bjst.dgt.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by bjst on 2018/06/13.
 */
@Service
@Transactional
public class SPromotionServiceImpl extends AbstractService<SPromotion> implements SPromotionService {
    @Resource
    private SPromotionMapper sPromotionMapper;

}
