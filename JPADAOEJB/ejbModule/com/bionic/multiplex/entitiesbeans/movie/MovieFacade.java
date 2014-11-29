package com.bionic.multiplex.entitiesbeans.movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Stateless
public class MovieFacade extends AbstractFacade<Movie> implements MovieFacadeLocal {

    @PersistenceContext
    protected EntityManager em;
	
	public MovieFacade() {
		super(Movie.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}
