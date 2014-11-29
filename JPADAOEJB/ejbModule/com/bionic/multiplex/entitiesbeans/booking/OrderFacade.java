package com.bionic.multiplex.entitiesbeans.booking;

import javax.ejb.Stateless;
import javax.inject.Named;

import com.bionic.multiplex.entities.Order;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Named
@Stateless
public class OrderFacade extends AbstractFacade<Order> implements OrderFacadeLocal {

	public OrderFacade() {
		super(Order.class);
	}

}
