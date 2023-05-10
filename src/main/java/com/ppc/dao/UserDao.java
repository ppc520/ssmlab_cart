package com.ppc.dao;

import com.ppc.common.dao.BaseDao;
import com.ppc.entity.User;

public interface UserDao extends BaseDao<User> {
    User getByUserName(String username);
}
