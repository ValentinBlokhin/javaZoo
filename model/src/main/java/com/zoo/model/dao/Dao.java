package com.zoo.model.dao;

import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public interface Dao<T> {

    void saveOrUpdate(T persistence);

    void delete(T persistence);

    T get(Integer id);

    List<T> getAll(int pageNumber, int pageSize);

}
