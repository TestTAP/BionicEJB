package com.bionic.movieplex.beans;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the cinemas database table.
 * 
 */

public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	private int cinemaID;
	private String cinemaName;
	private List<Movie> cinemaMovies;
	private int cinemaRows;
	private int cinemaPlaces;

	public Cinema() {
	}

	public int getCinemaID() {
		return this.cinemaID;
	}

	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}

	public String getCinemaName() {
		return this.cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}

	public List<Movie> getCinemaMovies() {
		return cinemaMovies;
	}

	public void setCinemaMovies(List<Movie> cinemaMovies) {
		this.cinemaMovies = cinemaMovies;
	}

	public int getCinemaRows() {
		return cinemaRows;
	}

	public void setCinemaRows(int cinemaRows) {
		this.cinemaRows = cinemaRows;
	}

	public int getCinemaPlaces() {
		return cinemaPlaces;
	}

	public void setCinemaPlaces(int cinemaPlaces) {
		this.cinemaPlaces = cinemaPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinemaID;
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
		Cinema other = (Cinema) obj;
		if (cinemaID != other.cinemaID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cinema [cinemaID=" + cinemaID + ", cinemaName=" + cinemaName
				+ ", cinemaMovies=" + cinemaMovies + ", cinemaRows="
				+ cinemaRows + ", cinemaPlaces=" + cinemaPlaces + "]";
	}

}