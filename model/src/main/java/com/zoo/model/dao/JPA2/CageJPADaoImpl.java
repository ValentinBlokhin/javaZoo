package com.zoo.model.dao.JPA2;

import com.zoo.model.entity.Cage;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class CageJPADaoImpl extends AbstractJPADao<Cage> {

    @Override
    public void saveOrUpdate(Cage persistence) {
        beginTransaction();
        entityManager.persist(persistence);
        commit();
    }

    @Override
    public void delete(Cage persistence) {
        beginTransaction();
        entityManager.remove(persistence);
        commit();
    }

    @Override
    public Cage get(Integer id) {
        return entityManager.find(Cage.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List getAll(int pageNumber, int pageSize) {
        Query query = entityManager.createQuery("select e from Cage e");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
