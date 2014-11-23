package com.bionic.multiplex.entitiesbeans.booking;

import com.bionic.multiplex.entities.Booking;
import com.bionic.multiplex.entitiesbeans.AbstractFacade;

public class BookingFacade extends AbstractFacade<Booking> implements BookingFacadeLocal {

	public BookingFacade() {
		super(Booking.class);
	}

}
