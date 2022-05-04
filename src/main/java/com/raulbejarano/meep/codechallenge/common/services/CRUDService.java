package com.raulbejarano.meep.codechallenge.common.services;

import java.util.List;

public interface CRUDService<T> {
    T create(T t);
    List<T> list();
    T get(String id);
    T update(T old, T t);
    void delete(T t);
}
