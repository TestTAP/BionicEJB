package com.bionic.multiplex.entitiesbeans.movie;

import javax.ejb.Stateless;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Stateless
public class MovieFacade extends AbstractFacade<Movie> implements MovieFacadeLocal {

	public MovieFacade() {
		super(Movie.class);
	}
}
