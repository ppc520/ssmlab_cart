package com.ppc.service.impl;

import com.ppc.common.dao.BaseDao;
import com.ppc.common.service.impl.BaseServiceImpl;
import com.ppc.dao.GoodsDao;
import com.ppc.entity.Goods;
import com.ppc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    protected BaseDao<Goods> getEntityDao() {
        return goodsDao;
    }
}
