package com.bionic.movieplex.dao.daos;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import com.bionic.movieplex.dao.GenericDao;

public class JPADAO<K, E> implements GenericDao<K, E>{
	
	private static final String PERSISTENCE_UNIT_NAME = "MultiPlex";
	protected Class<E> entityClass;
	protected EntityManager entityManager;
	protected EntityTransaction entityTransaction;
	protected CriteriaBuilder criteriaBuilder;

	protected JPADAO() {
		entityManager = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
		entityTransaction = entityManager.getTransaction();
		criteriaBuilder = entityManager.getCriteriaBuilder();
		this.entityClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void persist(E entity) {
		entityTransaction.begin();
		entityManager.persist(entity);
		entityTransaction.commit();
	}

	@Override
	public E update(E entity) {
//		entityTransaction.begin();
		return entityManager.merge(entity);
//		entityTransaction.commit();
	}
	
	@Override
	public void remove(E entity) {
		entityTransaction.begin();
		entityManager.remove(entity);
		entityTransaction.commit();
	}

	@Override
	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}
	
}
