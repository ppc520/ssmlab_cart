package com.ppc.common.service;

import java.util.List;

public interface BaseService <T>{
    Integer insert(T t);

    Integer delete(Integer id);

    Integer update(T t);

    T getById(Integer id);

    List<T> getAll();
}
