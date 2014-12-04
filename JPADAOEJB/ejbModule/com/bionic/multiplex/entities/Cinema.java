package com.bionic.multiplex.entities;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * The persistent class for the cinemas database table.
 * 
 */

@Entity
@Table(name = "Cinemas")
public class Cinema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cinemaID;
	private String cinemaName;
	@ManyToMany//(fetch=FetchType.EAGER)
	@JoinTable(name = "moviescinemas", joinColumns = @JoinColumn
	(name = "cinemaID", referencedColumnName = "cinemaID"), 
	inverseJoinColumns = @JoinColumn(name = "movieID", 
	referencedColumnName = "movieID"))
	private List<Movie> cinemaMovies;
	private int cinemaCapacity;
	
	public int getCinemaID() {
		return cinemaID;
	}
	public void setCinemaID(int cinemaID) {
		this.cinemaID = cinemaID;
	}
	public String getCinemaName() {
		return cinemaName;
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
	public int getCinemaCapacity() {
		return cinemaCapacity;
	}
	public void setCinemaCapacity(int cinemaCapacity) {
		this.cinemaCapacity = cinemaCapacity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinemaCapacity;
		result = prime * result + cinemaID;
		result = prime * result
				+ ((cinemaMovies == null) ? 0 : cinemaMovies.hashCode());
		result = prime * result
				+ ((cinemaName == null) ? 0 : cinemaName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cinema))
			return false;
		Cinema other = (Cinema) obj;
		if (cinemaCapacity != other.cinemaCapacity)
			return false;
		if (cinemaID != other.cinemaID)
			return false;
		if (cinemaMovies == null) {
			if (other.cinemaMovies != null)
				return false;
		} else if (!cinemaMovies.equals(other.cinemaMovies))
			return false;
		if (cinemaName == null) {
			if (other.cinemaName != null)
				return false;
		} else if (!cinemaName.equals(other.cinemaName))
			return false;
		return true;
	}



}