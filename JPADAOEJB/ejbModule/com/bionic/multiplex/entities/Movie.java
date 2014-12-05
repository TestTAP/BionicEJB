package com.bionic.multiplex.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the movies database table.
 * 
 */

@Entity
@Table(name = "Movies")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieID;
	private String movieName;
	@Temporal(TemporalType.TIMESTAMP)
	private Date movieShowTime;
	@ManyToMany (mappedBy = "cinemaMovies")
	private List<Cinema> movieCinemas;
	@OneToOne(mappedBy = "movieID", cascade = CascadeType.ALL)
	private MovieInfo movieInfo;

	public Movie() {
		movieInfo = new MovieInfo();
		movieInfo.setMovieID(this);
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

	public Date getMovieShowTime() {
		return movieShowTime;
	}

	public void setMovieShowTime(Date movieShowTime) {
		this.movieShowTime = movieShowTime;
	}

	public List<Cinema> getMovieCinemas() {
		return movieCinemas;
	}

	public void setMovieCinemas(List<Cinema> movieCinemas) {
		this.movieCinemas = movieCinemas;
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
				+ ", movieShowTime=" + movieShowTime + ", movieCinema="
				+ movieCinemas + ", movieInfo=" + movieInfo + "]";
	}

}