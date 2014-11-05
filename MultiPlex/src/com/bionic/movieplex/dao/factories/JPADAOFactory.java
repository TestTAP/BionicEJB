package com.bionic.movieplex.dao.factories;

import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.beans.booking.BookingDAO;
import com.bionic.movieplex.dao.beans.cinema.CinemaDAO;
import com.bionic.movieplex.dao.beans.movie.MovieDAO;
import com.bionic.movieplex.dao.beans.movieinfo.MovieInfoDAO;
import com.bionic.movieplex.dao.beans.movieinfo.MySQLMovieInfoDAO;
import com.bionic.movieplex.dao.beans.user.JPAUserDAO;
import com.bionic.movieplex.dao.beans.user.UserDAO;

public class JPADAOFactory extends DAOFactory{

	@Override
	public BookingDAO getBookingDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CinemaDAO getCinemaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDAO getMovieDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieInfoDAO getMovieInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDAO getUserDAO() {
		// TODO Auto-generated method stub
		return new JPAUserDAO();
	}


}
