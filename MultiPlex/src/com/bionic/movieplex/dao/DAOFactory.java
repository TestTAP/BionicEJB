package com.bionic.movieplex.dao;

import com.bionic.movieplex.dao.beans.booking.BookingDAO;
import com.bionic.movieplex.dao.beans.cinema.CinemaDAO;
import com.bionic.movieplex.dao.beans.movie.MovieDAO;
import com.bionic.movieplex.dao.beans.movieinfo.MovieInfoDAO;
import com.bionic.movieplex.dao.beans.user.UserDAO;
import com.bionic.movieplex.dao.factories.JPADAOFactory;
import com.bionic.movieplex.dao.factories.MySQLDAOFactory;
import com.bionic.movieplex.dao.factories.OracleDAOFactory;

public abstract class DAOFactory {

	public abstract BookingDAO getBookingDAO();

	public abstract CinemaDAO getCinemaDAO();

	public abstract MovieDAO getMovieDAO();
	
	public abstract MovieInfoDAO getMovieInfo();

	public abstract UserDAO getUserDAO();

	public static DAOFactory getDAOFactory(DAOFactoryType factoryType) {
		switch (factoryType) {
		case MYSQL:
			return new MySQLDAOFactory();
		case JPA:
			return new JPADAOFactory();
		case ORACLE:
			return new OracleDAOFactory();
		default:
			return null;
		}
	}
	
	
}
