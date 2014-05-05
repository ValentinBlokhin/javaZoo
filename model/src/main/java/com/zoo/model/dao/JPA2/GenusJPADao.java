package com.zoo.model.dao.JPA2;

import com.zoo.model.entity.Genus;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public class GenusJPADao extends AbstractJPADao<Genus> {
    @Override
    public void saveOrUpdate(Genus persistence) {
        beginTransaction();
        entityManager.persist(persistence);
        commit();
    }

    @Override
    public void delete(Genus persistence) {
        beginTransaction();
        entityManager.remove(persistence);
        commit();
    }

    @Override
    public Genus get(Integer id) {
        return entityManager.find(Genus.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genus> getAll(int pageNumber, int pageSize) {
        Query query = entityManager.createQuery("select e from Genus e");
        query.setFirstResult(pageNumber);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
}
