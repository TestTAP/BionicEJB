package com.bionic.movieplex.dao.beans.cinema;

import java.util.List;

import com.bionic.movieplex.beans.Cinema;
import com.bionic.movieplex.beans.Movie;

public interface CinemaDAO {
	public Cinema getCinemaByID(int cinemaID);
	public List<Cinema> getAllCinemas();
	public List<Movie> getAllMovies();
	public int addCinema(String name, int rows, int places);
	public int deleteCinema(Cinema cinema);
}
