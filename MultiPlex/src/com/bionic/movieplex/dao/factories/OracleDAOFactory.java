package com.bionic.movieplex.dao.factories;

import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.beans.booking.BookingDAO;
import com.bionic.movieplex.dao.beans.cinema.CinemaDAO;
import com.bionic.movieplex.dao.beans.movie.MovieDAO;
import com.bionic.movieplex.dao.beans.movieinfo.MySQLMovieInfoDAO;
import com.bionic.movieplex.dao.beans.user.UserDAO;

public class OracleDAOFactory extends DAOFactory{

	@Override
	public BookingDAO getBookingDAO() {
		return null;
	}

	@Override
	public CinemaDAO getCinemaDAO() {
		return null;
	}

	@Override
	public MovieDAO getMovieDAO() {
		return null;
	}

	@Override
	public MySQLMovieInfoDAO getMovieInfo() {
		return null;
	}
	
	@Override
	public UserDAO getUserDAO() {
		return null;
	}

}
