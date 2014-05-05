package com.zoo.model.dao.JPA2;

import com.zoo.model.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public abstract class AbstractJPADao<T> implements Dao<T> {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ZooModel");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void beginTransaction() {
        this.entityManager.getTransaction().begin();
    }

    public void commit() {
        this.entityManager.getTransaction().commit();
    }
}
