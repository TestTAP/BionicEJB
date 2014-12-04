package com.bionic.multiplex.entitiesbeans.order;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.Order;

@Local
public interface OrderFacadeLocal {
    void create(Order order);

    void edit(Order order);

    void remove(Order order);

    Order find(Object id);

    List<Order> findAll();
    
    int count();
    
}
