package com.zoo.service.Impl;

import com.zoo.model.dao.Dao;
import com.zoo.model.dao.JPA2.CageJPADaoImpl;
import com.zoo.model.entity.Cage;
import com.zoo.service.EntityService;

import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class CageService implements EntityService<Cage> {

    private Dao<Cage> dao = new CageJPADaoImpl();

    @Override
    public void saveOrUpdate(Cage persistence) {
        dao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Cage persistence) {
        dao.delete(persistence);
    }

    @Override
    public Cage get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Cage> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }
}
