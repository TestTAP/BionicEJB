package com.bionic.multiplex.entitiesbeans.movieinfo;

import javax.ejb.Stateless;

import com.bionic.multiplex.entities.MovieInfo;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Stateless
public class MovieInfoFacade extends AbstractFacade<MovieInfo> implements MovieInfoFacadeLocal {

	public MovieInfoFacade() {
		super(MovieInfo.class);
	}

}
