package com.ppc.service.impl;

import com.ppc.common.dao.BaseDao;
import com.ppc.common.service.impl.BaseServiceImpl;
import com.ppc.dao.UserDao;
import com.ppc.entity.User;
import com.ppc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
@Autowired
private UserDao userDao;
    protected BaseDao<User> getEntityDao() {
        return userDao;
    }

    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }
}
