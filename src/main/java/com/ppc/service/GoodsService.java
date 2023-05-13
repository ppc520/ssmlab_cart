package com.ppc.service;

import com.ppc.common.service.BaseService;
import com.ppc.entity.Goods;

public interface GoodsService extends BaseService<Goods> {
    boolean doBuy(Goods goods);
}
