package com.bionic.multiplex.backingbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;
import com.bionic.multiplex.entitiesbeans.movieinfo.MovieInfoFacadeLocal;

@Named
@SessionScoped
public class MovieBackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5471807765831822071L;

	@EJB
	private MovieFacadeLocal movieFacade;
	@EJB
	private MovieInfoFacadeLocal movieInfoFacade;
	private Movie movie;
	private List<Movie> movies;

	public List<Movie> getMovies() {
		movies = movieFacade.findAll();
		return movies;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void findMovie() {
		System.out.println("finding movie");
		if (movie != null) {
			movie = movieFacade.find(movie.getMovieID());
		} else {
			movie = new Movie();
		}
	}

	public Movie getMovie() {
		if (movie == null) {
			movie = new Movie();
		}
		return movie;
	}

	public int getCount() {
		return movieFacade.count();
	}

	public void deleteMovie() {
		movieFacade.remove(getMovie());
	}

	public void addMovie() {
		System.out.println("movie showtime: " + movie.getMovieShowTime());
		movieFacade.create(movie);
	}

	public void resetMovie() {
		movie = new Movie();
	}

}
