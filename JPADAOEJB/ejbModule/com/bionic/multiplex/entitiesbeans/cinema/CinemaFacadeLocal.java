package com.bionic.multiplex.entitiesbeans.cinema;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Cinema;

@Local
public interface CinemaFacadeLocal {
	void create(Cinema cinema);

	void edit(Cinema cinema);

	void remove(Cinema cinema);

	Cinema find(Object id);

	List<Cinema> findAll();

	int count();
	
}
