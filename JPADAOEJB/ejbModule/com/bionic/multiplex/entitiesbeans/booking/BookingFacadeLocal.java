package com.bionic.multiplex.entitiesbeans.booking;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Booking;

@Local
public interface BookingFacadeLocal {
    void create(Booking users);

    void edit(Booking users);

    void remove(Booking users);

    Booking find(Object id);

    List<Booking> findAll();
    
}
