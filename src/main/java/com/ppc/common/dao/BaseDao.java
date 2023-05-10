package com.ppc.common.dao;

public interface BaseDao<T> {
    Integer insert(T t);

    Integer delete(Integer id);

    Integer update(T t);

    T getById(Integer id);
}
