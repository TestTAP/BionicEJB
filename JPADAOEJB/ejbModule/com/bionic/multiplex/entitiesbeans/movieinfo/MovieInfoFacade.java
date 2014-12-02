package com.bionic.multiplex.entitiesbeans.movieinfo;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bionic.multiplex.entities.MovieInfo;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Named
@Stateless
public class MovieInfoFacade extends AbstractFacade<MovieInfo> implements MovieInfoFacadeLocal {

    @PersistenceContext
    protected EntityManager em;
	
	public MovieInfoFacade() {
		super(MovieInfo.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
