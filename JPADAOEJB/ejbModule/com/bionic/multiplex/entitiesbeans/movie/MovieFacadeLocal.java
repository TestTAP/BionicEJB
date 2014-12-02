package com.bionic.multiplex.entitiesbeans.movie;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Movie;

@Local
public interface MovieFacadeLocal {
	void create(Movie users);

	void edit(Movie users);

	void remove(Movie users);

	Movie find(Object id);

	List<Movie> findAll();
	
	int count();
	
}
