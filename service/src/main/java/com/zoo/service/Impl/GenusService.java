package com.zoo.service.Impl;

import com.zoo.model.dao.Dao;
import com.zoo.model.dao.JPA2.GenusJPADao;
import com.zoo.model.entity.Genus;
import com.zoo.service.EntityService;

import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class GenusService implements EntityService<Genus> {

    Dao<Genus> dao = new GenusJPADao();

    @Override
    public void saveOrUpdate(Genus persistence) {
        dao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Genus persistence) {
        dao.delete(persistence);
    }

    @Override
    public Genus get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Genus> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }
}
