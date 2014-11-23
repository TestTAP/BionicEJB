package com.bionic.multiplex.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the movies database table.
 * 
 */

@Entity
@Table(name = "MovieInfo")
public class MovieInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int movieInfoID;
	private Date movieYear;
	private String movieCountry; 
	private String movieGenre;
	private String movieDirector;
	private String movieCast;
	private String movieStoryline;
	private int movieDuration;

	public int getMovieInfoID() {
		return movieInfoID;
	}

	public void setMovieInfoID(int movieInfoID) {
		this.movieInfoID = movieInfoID;
	}

	public Date getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(Date movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieCountry() {
		return movieCountry;
	}

	public void setMovieCountry(String movieCountry) {
		this.movieCountry = movieCountry;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieStoryline() {
		return movieStoryline;
	}

	public void setMovieStoryline(String movieStoryline) {
		this.movieStoryline = movieStoryline;
	}

	public int getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}

	public MovieInfo() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + movieInfoID;
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
		MovieInfo other = (MovieInfo) obj;
		if (movieInfoID != other.movieInfoID)
			return false;
		return true;
	}

}