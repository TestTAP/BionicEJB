package com.bionic.movieplex.dao.beans.cinema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bionic.movieplex.beans.Cinema;
import com.bionic.movieplex.beans.Movie;
import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.beans.movie.MovieDAO;
import com.bionic.movieplex.dao.beans.movie.MySQLMovieDAO;
import com.bionic.movieplex.dao.factories.MySQLDAOFactory;
import com.mysql.jdbc.Statement;

import static com.bionic.movieplex.dao.constants.MySQLConstants.*;

public class MySQLCinemaDAO implements CinemaDAO {

	private Connection connection = null;

	private static final String CINEMAS_TABLE = " Cinemas ";
	private static final String CINEMAS_COLUMN_CINEMA_ID = "cinemaID";
	private static final String CINEMAS_COLUMN_CINEMA_NAME = "cinemaName";
	private static final String CINEMAS_COLUMN_CINEMA_MOVIES = "cinemaMovies";
	private static final String CINEMAS_COLUMN_CINEMA_ROWS = "cinemaRows";
	private static final String CINEMAS_COLUMN_CINEMA_PLACES = "cinemaPlaces";

	private static final String MOVIES_CINEMAS_TABLE = " MoviesCinemas ";
	private static final String MOVIES_CINEMAS_TABLE_MOVIE_ID = "movieID";
	private static final String MOVIES_CINEMAS_TABLE_CINEMA_ID = "cinemaID";

	private static final String ADD_CINEMA = "INSERT INTO" + CINEMAS_TABLE
			+ "(" + CINEMAS_COLUMN_CINEMA_NAME + COMMA
			+ CINEMAS_COLUMN_CINEMA_ROWS + COMMA + CINEMAS_COLUMN_CINEMA_PLACES
			+ ") " + VALUES + "(?,?,?)";

	private static final String GET_ALL_MOVIES_BY_ID = "SELECT "
			+ MOVIES_CINEMAS_TABLE_MOVIE_ID + " FROM" + MOVIES_CINEMAS_TABLE
			+ WHERE + MOVIES_CINEMAS_TABLE_CINEMA_ID + "=?";

	private static final String SELECT_ALL_CINEMAS = "SELECT * FROM "
			+ CINEMAS_TABLE;

	@Override
	public Cinema getCinemaByID(int cinemaID) {
		return null;
	}

	@Override
	public List<Cinema> getAllCinemas() {
		List<Cinema> cinemasToFind = new ArrayList<>();
		connection = MySQLDAOFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(SELECT_ALL_CINEMAS);
			rs = statement.executeQuery();
			while (rs.next()) {
				List<Movie> cinemaMovies = new ArrayList<>();
				ResultSet intermediateSet;
				PreparedStatement intermediateStatement = connection
						.prepareStatement(GET_ALL_MOVIES_BY_ID);
				intermediateStatement.setInt(1, rs.getInt(CINEMAS_COLUMN_CINEMA_MOVIES));
				intermediateSet = intermediateStatement.executeQuery();
				while (intermediateSet.next()) {
					MovieDAO movieDAO = new MySQLMovieDAO();
					cinemaMovies.add(movieDAO.getMovieByID(rs
							.getInt(MOVIES_CINEMAS_TABLE_MOVIE_ID)));
				}
				Cinema cinema = new Cinema();
				cinema.setCinemaID(rs.getInt(CINEMAS_COLUMN_CINEMA_ID));
				cinema.setCinemaName(rs.getString(CINEMAS_COLUMN_CINEMA_NAME));
				cinema.setCinemaMovies(cinemaMovies);
				cinema.setCinemaRows(rs.getInt(CINEMAS_COLUMN_CINEMA_ROWS));
				cinema.setCinemaPlaces(rs.getInt(CINEMAS_COLUMN_CINEMA_PLACES));
				cinemasToFind.add(cinema);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return cinemasToFind;
	}

	@Override
	public int addCinema(String name, int rows, int places) {
		int addedCinemaID = -1;
		connection = MySQLDAOFactory.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(ADD_CINEMA,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, name);
			statement.setInt(2, rows);
			statement.setInt(3, places);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) addedCinemaID = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return addedCinemaID;
	}

	@Override
	public int deleteCinema(Cinema cinema) {
		return 0;
	}

	@Override
	public List<Movie> getAllMovies() {
		return null;
	}

}
