package com.bionic.movieplex.dao.factories;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.beans.booking.BookingDAO;
import com.bionic.movieplex.dao.beans.booking.MySQLBookingDAO;
import com.bionic.movieplex.dao.beans.cinema.CinemaDAO;
import com.bionic.movieplex.dao.beans.cinema.MySQLCinemaDAO;
import com.bionic.movieplex.dao.beans.movie.MovieDAO;
import com.bionic.movieplex.dao.beans.movie.MySQLMovieDAO;
import com.bionic.movieplex.dao.beans.movieinfo.MySQLMovieInfoDAO;
import com.bionic.movieplex.dao.beans.user.MySQLUserDAO;
import com.bionic.movieplex.dao.beans.user.UserDAO;
import com.bionic.movieplex.logic.managers.ConfigurationManager;
import com.mysql.jdbc.Connection;

public class MySQLDAOFactory extends DAOFactory {

//	/** The driver-class. */
//	private static final String DRIVER = "com.mysql.jdbc.Driver";
//	/** The url to database. */
//	private static final String DBURL = "jdbc:mysql://localhost:3306/movieplex";
//	/** The username for database-operations. */
//	private static final String USER = "root";
//	/** The password for database-operations. */
//	private static final String PASS = "password";
	private static Connection connection;

	public static synchronized Connection getConnection() {
		if (connection == null) {
			try {
				ConfigurationManager manager = ConfigurationManager.getInstance();
				Class.forName(manager.getProperty(ConfigurationManager.DATABASE_DRIVER_NAME));
				connection = (Connection) DriverManager.getConnection(manager.getProperty(ConfigurationManager.DATABASE_URL));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	public static synchronized void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public BookingDAO getBookingDAO() {
		return new MySQLBookingDAO();
	}

	@Override
	public CinemaDAO getCinemaDAO() {
		return new MySQLCinemaDAO();
	}

	@Override
	public MovieDAO getMovieDAO() {
		return new MySQLMovieDAO();
	}

	public MySQLMovieInfoDAO getMovieInfo() {
		return new MySQLMovieInfoDAO();
	}
	
	@Override
	public UserDAO getUserDAO() {
		return new MySQLUserDAO();
	}

}
