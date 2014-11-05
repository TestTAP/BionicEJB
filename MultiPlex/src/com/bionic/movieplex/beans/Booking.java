package com.bionic.movieplex.beans;

import java.io.Serializable;

/**
 * The persistent class for the bookings database table.
 * 
 */
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	private int bookingID;
	private User bookingUser;
	private String bookingType;
	private Movie bookingMovie;
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
	public String getBookingType() {
		return bookingType;
	}
	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
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
				+ bookingUser + ", bookingType=" + bookingType
				+ ", bookingMovie=" + bookingMovie + ", bookingCinema="
				+ bookingCinema + ", bookingRow=" + bookingRow
				+ ", bookingPlace=" + bookingPlace + "]";
	}

}