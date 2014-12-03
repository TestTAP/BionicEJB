package com.bionic.multiplex.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;

@Named
@SessionScoped
public class MovieBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471807765831822071L;
	
	@EJB
	private MovieFacadeLocal movieFacade;
	private Movie movie = new Movie();
	private List<Movie> movies;
	
	public List<Movie> getMovies() {
		movies = movieFacade.findAll();
		return movies;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Movie getMovie() {
		movie = movieFacade.find(movie.getMovieID());
		if (movie==null) movie = new Movie();
		return movie;
	}
	
	public int getCount() {
		return movieFacade.count();
	}
	
	public void deleteMovie() {
		movieFacade.remove(getMovie());
	}
	
	
}
