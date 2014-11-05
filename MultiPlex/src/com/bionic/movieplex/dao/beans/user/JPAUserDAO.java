package com.bionic.movieplex.dao.beans.user;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.daos.JPADAO;

public class JPAUserDAO extends JPADAO<Integer, User> implements UserDAO {

	@Override
	public List<User> getAllUsers() {
		return null;
	}

	@Override
	public void addUser(User user) {
		persist(user);
	}

	@Override
	public User updateUser(User user) {
		return update(user);
	}

	@Override
	public User findUserByLoginPassword(String userLogin, String userPassword) {
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
		Predicate predicate2 = criteriaBuilder.like(path2, userPassword); 
		criteriaQuery = criteriaQuery.where(predicate1, predicate2);
        TypedQuery<User> typedQuery = entityManager.createQuery(
                criteriaQuery);
		User user = typedQuery.getSingleResult();
		return user;
	}

}
