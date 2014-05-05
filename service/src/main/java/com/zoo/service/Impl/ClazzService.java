package com.zoo.service.Impl;

import com.zoo.model.dao.Dao;
import com.zoo.model.dao.JPA2.ClazzJPADaoImpl;
import com.zoo.model.entity.Clazz;
import com.zoo.service.EntityService;

import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class ClazzService implements EntityService<Clazz> {

    private Dao<Clazz> dao = new ClazzJPADaoImpl();

    @Override
    public void saveOrUpdate(Clazz persistence) {

    }

    @Override
    public void delete(Clazz persistence) {

    }

    @Override
    public Clazz get(Integer id) {
        return null;
    }

    @Override
    public List<Clazz> getAll(int pageNumber, int pageSize) {
        return null;
    }
}
