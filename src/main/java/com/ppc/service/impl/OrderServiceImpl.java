package com.ppc.service.impl;

import com.ppc.common.dao.BaseDao;
import com.ppc.common.service.impl.BaseServiceImpl;
import com.ppc.dao.OrderDao;
import com.ppc.entity.Order;
import com.ppc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;
    protected BaseDao<Order> getEntityDao() {
        return orderDao;
    }
}
