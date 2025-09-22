package com.tecsup.semana05crud.model.daos;

import java.util.List;

public interface EntidadDao<T, V> {
    void create(T t);
    T find(V id);
    List<T> findAll();
    void update(T t);
    void delete(V id);
}