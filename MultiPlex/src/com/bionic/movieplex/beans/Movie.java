package com.bionic.movieplex.beans;

import java.io.Serializable;
import java.sql.Time;

/**
 * The persistent class for the movies database table.
 * 
 */
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	private int movieID;
	private String movieName;
	private Time movieShowtime;
	private Cinema movieCinema;
	private MovieInfo movieInfo;

	public Movie() {
	}

	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Time getMovieShowtime() {
		return movieShowtime;
	}

	public void setMovieShowtime(Time movieShowtime) {
		this.movieShowtime = movieShowtime;
	}

	public Cinema getMovieCinema() {
		return movieCinema;
	}

	public void setMovieCinema(Cinema movieCinema) {
		this.movieCinema = movieCinema;
	}

	public MovieInfo getMovieInfo() {
		return movieInfo;
	}

	public void setMovieInfo(MovieInfo movieInfo) {
		this.movieInfo = movieInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieID;
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
		Movie other = (Movie) obj;
		if (movieID != other.movieID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [movieID=" + movieID + ", movieName=" + movieName
				+ ", movieShowTime=" + movieShowtime + ", movieCinema="
				+ movieCinema + ", movieInfo=" + movieInfo + "]";
	}

}