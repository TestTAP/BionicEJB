package com.bionic.multiplex.backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;

@Named
@RequestScoped
public class MovieBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471807765831822071L;

	@EJB
	private MovieFacadeLocal movieFacade;
	private Movie movie = new Movie();
	private List<Movie> movies = new ArrayList<Movie>();

	public List<Movie> getMovies() {
		movies = movieFacade.findAll();
		return movies;
	}

	public void setMovie(Movie movie) {
		System.out.println("setMovie()");
		this.movie = movie;
	}

	public Movie getMovie() {
		System.out.println("getMovie(): " + movie.getMovieID());
		return movie;
	}

	public int getCount() {
		return movieFacade.count();
	}

	public void deleteMovie() {
		if (movie.getMovieID() != 0) {
			movieFacade.remove(movie);
			movie = new Movie();
		}
	}

	public void addMovie() {
		System.out.println("movie showtime: " + movie.getMovieShowTime());
		movieFacade.create(movie);
	}

	public void findMovie() {
		System.out.println("finding movie: " + movie.getMovieID());
		if (movie.getMovieID() != 0) {
			movie = movieFacade.find(movie.getMovieID());
		} else if (movie == null) {
			movie = new Movie();
		}
	}

}
