package com.bionic.multiplex.entitiesbeans.cinema;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Cinema;

@Local
public interface CinemaFacadeLocal {
	void create(Cinema users);

	void edit(Cinema users);

	void remove(Cinema users);

	Cinema find(Object id);

	List<Cinema> findAll();
}
