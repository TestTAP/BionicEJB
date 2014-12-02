package com.bionic.multiplex.entitiesbeans.order;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bionic.multiplex.entities.Order;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

@Named
@Stateless
public class OrderFacade extends AbstractFacade<Order> implements OrderFacadeLocal {
    @PersistenceContext
    protected EntityManager em;
	
	public OrderFacade() {
		super(Order.class);
	}

	public OrderFacade(EntityManager em) {
		this();
		this.em = em;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

}
