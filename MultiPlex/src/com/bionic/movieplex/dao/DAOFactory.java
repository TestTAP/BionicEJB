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

	private static DAOFactory daoFactory;
	
	public abstract BookingDAO getBookingDAO();

	public abstract CinemaDAO getCinemaDAO();

	public abstract MovieDAO getMovieDAO();
	
	public abstract MovieInfoDAO getMovieInfo();

	public abstract UserDAO getUserDAO();

	public static void setDAOFactory(DAOFactoryType factoryType) {
		switch (factoryType) {
		case MYSQL:
			daoFactory = new MySQLDAOFactory();
			break;
		case JPA:
			daoFactory = new JPADAOFactory();
			break;
		case ORACLE:
			daoFactory = new OracleDAOFactory();
			break;
		default:
			daoFactory = new JPADAOFactory();
			break;
		}
	}
	
	public static DAOFactory getDAOFactory() {
		return daoFactory;
	}
	
}
