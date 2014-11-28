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
@Table(name = "Bookings")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int bookingID;
	@ManyToOne
	@JoinColumn	(name = "bookingUser")
	private User bookingUser;
	@ManyToOne
	@JoinColumn (name = "bookingMovie")
	private Movie bookingMovie;
	@ManyToOne
	@JoinColumn (name = "bookingCinema")
	private Cinema bookingCinema;
	private int bookingRow;
	private int bookingPlace;
	public int getBookingID() {
		return bookingID;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public User getBookingUser() {
		return bookingUser;
	}
	public void setBookingUser(User bookingUser) {
		this.bookingUser = bookingUser;
	}
	public Movie getBookingMovie() {
		return bookingMovie;
	}
	public void setBookingMovie(Movie bookingMovie) {
		this.bookingMovie = bookingMovie;
	}
	public Cinema getBookingCinema() {
		return bookingCinema;
	}
	public void setBookingCinema(Cinema bookingCinema) {
		this.bookingCinema = bookingCinema;
	}
	public int getBookingRow() {
		return bookingRow;
	}
	public void setBookingRow(int bookingRow) {
		this.bookingRow = bookingRow;
	}
	public int getBookingPlace() {
		return bookingPlace;
	}
	public void setBookingPlace(int bookingPlace) {
		this.bookingPlace = bookingPlace;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bookingID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (bookingID != other.bookingID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Booking [bookingID=" + bookingID + ", bookingUser="
				+ bookingUser  
				+ ", bookingMovie=" + bookingMovie + ", bookingCinema="
				+ bookingCinema + ", bookingRow=" + bookingRow
				+ ", bookingPlace=" + bookingPlace + "]";
	}

}