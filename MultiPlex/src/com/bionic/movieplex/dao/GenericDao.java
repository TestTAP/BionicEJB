package com.bionic.movieplex.dao;

public interface GenericDao <K, E> {
	
	void persist(E entity);
	E update(E entity);
	void remove(E entity);
	E findById(K id);

}
