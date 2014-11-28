package com.bionic.multiplex.entitiesbeans.cinema;

import javax.ejb.Stateless;

import com.bionic.multiplex.entities.Cinema;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Stateless
public class CinemaFacade extends AbstractFacade<Cinema> implements CinemaFacadeLocal {

	public CinemaFacade() {
		super(Cinema.class);
	}

}
