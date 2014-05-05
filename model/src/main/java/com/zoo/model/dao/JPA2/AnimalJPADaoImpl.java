package com.zoo.model.dao.JPA2;

import com.zoo.model.entity.Animal;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class AnimalJPADaoImpl extends AbstractJPADao {
    @Override
    public void saveOrUpdate(Object persistence) {
        beginTransaction();
        entityManager.persist(persistence);
        commit();
    }

    @Override
    public void delete(Object persistence) {
        beginTransaction();
        entityManager.remove(persistence);
        commit();
    }

    @Override
    public Animal get(Integer id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    public List getAll(int pageNumber, int pageSize) {
        Query query = entityManager.createQuery("select e from Animal e");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
