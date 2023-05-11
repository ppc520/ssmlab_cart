package com.ppc.common.service.impl;

import com.ppc.common.dao.BaseDao;
import com.ppc.common.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T> implements BaseService<T> {
    protected abstract BaseDao<T> getEntityDao();

    public Integer insert(T t) {
        return getEntityDao().insert(t);
    }

    public Integer delete(Integer id) {
        return getEntityDao().delete(id);
    }

    public Integer update(T t) {
        return getEntityDao().update(t);
    }

    public T getById(Integer id) {
        return getEntityDao().getById(id);
    }

    public List<T> getAll() {
        return getEntityDao().getAll();
    }
}
