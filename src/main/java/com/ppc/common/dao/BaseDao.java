package com.ppc.common.dao;

import java.util.List;

public interface BaseDao<T> {
    Integer insert(T t);

    Integer delete(Integer id);

    Integer update(T t);

    T getById(Integer id);

    List<T> getAll();
}
