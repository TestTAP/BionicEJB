/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.multiplex.entitiesbeans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public abstract class AbstractFacade<T> {
    @PersistenceContext(unitName = "JPADAOEJB")
	protected EntityManager entityManager;
    
	private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity) {
    	entityManager.persist(entity);
    }

    public void edit(T entity) {
    	entityManager.merge(entity);
    }

    public void remove(T entity) {
    	entityManager.remove(entityManager.merge(entity));
    }

    public T find(Object id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery<T> cq = entityManager.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));
        return entityManager.createQuery(cq).getResultList();
    }

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
}
