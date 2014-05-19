package com.zoo.model.dao.JPA2;

import com.zoo.model.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by ValentinBlokhin on 5/5/2014.
 */
public abstract class AbstractJPADao<T> implements Dao<T> {

    private static String PERSISTENCE_UNIT_NAME = "NewPersistenceUnit";

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
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
