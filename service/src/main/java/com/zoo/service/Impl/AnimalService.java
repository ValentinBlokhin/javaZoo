package com.zoo.service.Impl;

import com.zoo.model.dao.Dao;
import com.zoo.model.dao.JPA2.AnimalJPADaoImpl;
import com.zoo.model.entity.Animal;
import com.zoo.service.EntityService;

import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class AnimalService implements EntityService<Animal> {

    Dao<Animal> dao = new AnimalJPADaoImpl();

    @Override
    public void saveOrUpdate(Animal persistence) {
        dao.saveOrUpdate(persistence);
    }

    @Override
    public void delete(Animal persistence) {
        dao.delete(persistence);
    }

    @Override
    public Animal get(Integer id) {
        return dao.get(id);
    }

    @Override
    public List<Animal> getAll(int pageNumber, int pageSize) {
        return dao.getAll(pageNumber, pageSize);
    }
}
