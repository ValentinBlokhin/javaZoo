package com.zoo.model.dao.JPA2;

import com.zoo.model.entity.Clazz;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class ClazzJPADaoImpl extends AbstractJPADao<Clazz> {
    @Override
    public void saveOrUpdate(Clazz persistence) {
        beginTransaction();
        entityManager.persist(persistence);
        commit();
    }

    @Override
    public void delete(Clazz persistence) {
        beginTransaction();
        entityManager.remove(persistence);
        commit();
    }

    @Override
    public Clazz get(Integer id) {
        return entityManager.find(Clazz.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Clazz> getAll(int pageNumber, int pageSize) {
        Query query = entityManager.createQuery("select e from Clazz e");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
