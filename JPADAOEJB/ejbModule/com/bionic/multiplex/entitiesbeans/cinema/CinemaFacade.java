package com.bionic.multiplex.entitiesbeans.cinema;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bionic.multiplex.entities.Cinema;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Named
@Stateless
public class CinemaFacade extends AbstractFacade<Cinema> implements CinemaFacadeLocal {

    @PersistenceContext
    protected EntityManager em;
	
	public CinemaFacade() {
		super(Cinema.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
