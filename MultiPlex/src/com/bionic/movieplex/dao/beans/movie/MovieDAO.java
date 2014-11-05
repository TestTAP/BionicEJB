package com.bionic.movieplex.dao.beans.movie;

import java.util.List;

import com.bionic.movieplex.beans.Movie;

public interface MovieDAO {

	public int addMovie(String name);
	
	public Movie getMovieByID(int movieID);
	
	public List<Movie> getAllMoviev();
	
	public int deletMovie(int movieID);
}
