package com.bionic.multiplex.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the bookings database table.
 * 
 */

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int orderID;
	@ManyToOne
	@JoinColumn(name = "orderUser")
	private User orderUser;
	@ManyToOne
	@JoinColumn(name = "orderMovie")
	private Movie orderMovie;
	@ManyToOne
	@JoinColumn(name = "orderCinema")
	private Cinema orderCinema;

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public User getOrderUser() {
		return orderUser;
	}

	public void setOrderUser(User orderUser) {
		this.orderUser = orderUser;
	}

	public Movie getOrderMovie() {
		return orderMovie;
	}

	public void setOrderMovie(Movie orderMovie) {
		this.orderMovie = orderMovie;
	}

	public Cinema getOrderCinema() {
		return orderCinema;
	}

	public void setOrderCinema(Cinema orderCinema) {
		this.orderCinema = orderCinema;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orderCinema == null) ? 0 : orderCinema.hashCode());
		result = prime * result + orderID;
		result = prime * result
				+ ((orderMovie == null) ? 0 : orderMovie.hashCode());
		result = prime * result
				+ ((orderUser == null) ? 0 : orderUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Order))
			return false;
		Order other = (Order) obj;
		if (orderCinema == null) {
			if (other.orderCinema != null)
				return false;
		} else if (!orderCinema.equals(other.orderCinema))
			return false;
		if (orderID != other.orderID)
			return false;
		if (orderMovie == null) {
			if (other.orderMovie != null)
				return false;
		} else if (!orderMovie.equals(other.orderMovie))
			return false;
		if (orderUser == null) {
			if (other.orderUser != null)
				return false;
		} else if (!orderUser.equals(other.orderUser))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderUser=" + orderUser
				+ ", orderMovie=" + orderMovie + ", orderCinema=" + orderCinema
				+ "]";
	}

}