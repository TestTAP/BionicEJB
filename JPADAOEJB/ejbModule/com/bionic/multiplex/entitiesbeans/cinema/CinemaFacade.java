package com.bionic.multiplex.entitiesbeans.cinema;

import com.bionic.multiplex.entities.Cinema;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

public class CinemaFacade extends AbstractFacade<Cinema> implements CinemaFacadeLocal {

	public CinemaFacade() {
		super(Cinema.class);
	}

}
