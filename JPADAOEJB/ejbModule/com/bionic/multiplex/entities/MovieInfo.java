package com.bionic.multiplex.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the movies database table.
 * 
 */

@Entity
public class MovieInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int movieInfoID;
	@OneToOne
	@JoinColumn(name = "movieID")
	private Movie movieID;
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

	public Movie getMovieID() {
		return movieID;
	}

	public void setMovieID(Movie movieID) {
		this.movieID = movieID;
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
		result = prime * result
				+ ((movieCast == null) ? 0 : movieCast.hashCode());
		result = prime * result
				+ ((movieCountry == null) ? 0 : movieCountry.hashCode());
		result = prime * result
				+ ((movieDirector == null) ? 0 : movieDirector.hashCode());
		result = prime * result + movieDuration;
		result = prime * result
				+ ((movieGenre == null) ? 0 : movieGenre.hashCode());
		result = prime * result + movieID.hashCode();
		result = prime * result + movieInfoID;
		result = prime * result
				+ ((movieStoryline == null) ? 0 : movieStoryline.hashCode());
		result = prime * result
				+ ((movieYear == null) ? 0 : movieYear.hashCode());
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
		if (movieCast == null) {
			if (other.movieCast != null)
				return false;
		} else if (!movieCast.equals(other.movieCast))
			return false;
		if (movieCountry == null) {
			if (other.movieCountry != null)
				return false;
		} else if (!movieCountry.equals(other.movieCountry))
			return false;
		if (movieDirector == null) {
			if (other.movieDirector != null)
				return false;
		} else if (!movieDirector.equals(other.movieDirector))
			return false;
		if (movieDuration != other.movieDuration)
			return false;
		if (movieGenre == null) {
			if (other.movieGenre != null)
				return false;
		} else if (!movieGenre.equals(other.movieGenre))
			return false;
		if (movieID != other.movieID)
			return false;
		if (movieInfoID != other.movieInfoID)
			return false;
		if (movieStoryline == null) {
			if (other.movieStoryline != null)
				return false;
		} else if (!movieStoryline.equals(other.movieStoryline))
			return false;
		if (movieYear == null) {
			if (other.movieYear != null)
				return false;
		} else if (!movieYear.equals(other.movieYear))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MovieInfo [movieInfoID=" + movieInfoID + ", movieYear="
				+ movieYear + ", movieCountry=" + movieCountry
				+ ", movieGenre=" + movieGenre + ", movieDirector="
				+ movieDirector + ", movieCast=" + movieCast
				+ ", movieStoryline=" + movieStoryline + ", movieDuration="
				+ movieDuration + "]";
	}

}