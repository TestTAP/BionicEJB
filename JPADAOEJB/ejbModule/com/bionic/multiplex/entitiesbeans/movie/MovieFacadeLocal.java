package com.bionic.multiplex.entitiesbeans.movie;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Movie;

@Local
public interface MovieFacadeLocal {
	void create(Movie movie);

	void edit(Movie movie);

	void remove(Movie movie);

	Movie find(Object id);

	List<Movie> findAll();
	
	int count();
	
}
