package com.ppc.service;

import com.ppc.common.service.BaseService;
import com.ppc.entity.User;

public interface UserService extends BaseService<User> {
    User getByUserName(String username);
}
