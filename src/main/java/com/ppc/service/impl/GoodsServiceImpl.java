package com.ppc.service.impl;

import com.ppc.common.dao.BaseDao;
import com.ppc.common.service.impl.BaseServiceImpl;
import com.ppc.dao.GoodsDao;
import com.ppc.dao.OrderDao;
import com.ppc.dao.UserDao;
import com.ppc.entity.Goods;
import com.ppc.entity.Order;
import com.ppc.entity.User;
import com.ppc.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods> implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    protected BaseDao<Goods> getEntityDao() {
        return goodsDao;
    }

    public boolean doBuy(Goods goods) {
        //插入order表
        Order order=new Order();
        order.setUsername(goods.getUsername());
        order.setOriginPrice(goods.getSalePrice());
        order.setDiscount(goods.getCount() > 10 ? 7.0 : 10.0);
        order.setPaidMoney(order.getDiscount()/10*goods.getCount()*goods.getSalePrice());
        Integer insertOrder = orderDao.insert(order);
        //更新goods表
        Goods goodsFromDatabase = goodsDao.getById(goods.getGoodsId());
        goodsFromDatabase.setGoodsQuantity(goodsFromDatabase.getGoodsQuantity()-goods.getCount());
        Integer updateGoods = goodsDao.update(goodsFromDatabase);
        //更新
        User userFromDatabase = userDao.getByUserName(goods.getUsername());
        userFromDatabase.setBalance(userFromDatabase.getBalance()-order.getPaidMoney());
        Integer updateUser = userDao.update(userFromDatabase);

        return insertOrder>0&updateGoods>0&updateUser>0;
    }
}
