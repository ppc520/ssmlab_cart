package com.ppc.common.service;

public interface BaseService <T>{
    Integer insert(T t);

    Integer delete(Integer id);

    Integer update(T t);

    T getById(Integer id);
}
