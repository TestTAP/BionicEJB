package com.bionic.multiplex.entitiesbeans.booking;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Order;

@Local
public interface OrderFacadeLocal {
    void create(Order users);

    void edit(Order users);

    void remove(Order users);

    Order find(Object id);

    List<Order> findAll();
    
}
