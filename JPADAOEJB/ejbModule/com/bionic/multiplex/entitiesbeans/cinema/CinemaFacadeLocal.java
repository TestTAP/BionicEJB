package com.bionic.multiplex.entitiesbeans.cinema;

import java.util.List;

import com.bionic.multiplex.entities.Cinema;

public interface CinemaFacadeLocal {
	void create(Cinema users);

	void edit(Cinema users);

	void remove(Cinema users);

	Cinema find(Object id);

	List<Cinema> findAll();
}
