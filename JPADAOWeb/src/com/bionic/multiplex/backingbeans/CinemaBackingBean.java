package com.bionic.multiplex.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bionic.multiplex.entities.Cinema;
import com.bionic.multiplex.entitiesbeans.cinema.CinemaFacadeLocal;

@Named
@SessionScoped
public class CinemaBackingBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1683234731126499320L;
	
	@EJB
	private CinemaFacadeLocal cinemaFacade;
	private Cinema cinema;
	private List<Cinema> cinemas;
	
	@PostConstruct
	public void init() {
		cinema = new Cinema();
	}
	
	public List<Cinema> getCinemas() {
		cinemas = cinemaFacade.findAll();
		return cinemas;
	}
	
	public Cinema getCinema() {
		cinema = cinemaFacade.find(cinema.getCinemaID());
		return cinema;
	}
	
	public int getCount() {
		return cinemaFacade.count();
	}
	
}
