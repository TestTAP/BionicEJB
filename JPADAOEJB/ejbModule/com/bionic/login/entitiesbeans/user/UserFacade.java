/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bionic.login.entitiesbeans.user;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import com.bionic.login.entities.User;
import com.bionic.login.entitiesbeans.AbstractFacade;

/**
 *
 * @author Artem
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {
    @PersistenceContext(unitName = "JPADAOEJB")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    

    @Override
	public User findByLogin(String userLogin){
    	EntityManager entityManager = em;
    	CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
		User user = null;
		CriteriaQuery<User> criteriaQuery = criteriaBuilder
				.createQuery(User.class);
		Root<User> root = criteriaQuery.from(User.class);

		Metamodel metamodel = entityManager.getMetamodel();
		EntityType<User> userEntityType = metamodel.entity(User.class);
		SingularAttribute<User, String> userAttribute1 = userEntityType
				.getDeclaredSingularAttribute("userLogin", String.class);
		Path<String> path = root.get(userAttribute1);
		Predicate predicate1 = criteriaBuilder.like(path, userLogin);
		SingularAttribute<User, String> userAttribute2 = userEntityType
				.getDeclaredSingularAttribute("userPassword", String.class);
		Path<String> path2 = root.get(userAttribute2);
		Predicate predicate2 = criteriaBuilder.like(path2, "asd"); 
		criteriaQuery = criteriaQuery.where(predicate1, predicate2);
        TypedQuery<User> typedQuery = entityManager.createQuery(
                criteriaQuery);
		try {
			user = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			
		}
		return user;
    }
    
}
