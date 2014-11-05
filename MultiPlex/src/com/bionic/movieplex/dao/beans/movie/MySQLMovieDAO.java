package com.bionic.movieplex.dao.beans.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bionic.movieplex.beans.Movie;
import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.factories.MySQLDAOFactory;
import com.mysql.jdbc.Statement;

import static com.bionic.movieplex.dao.constants.MySQLConstants.*;

public class MySQLMovieDAO implements MovieDAO {

	private Connection connection = null;

	private static final String MOVIES_TABLE = " Movies ";
	private static final String MOVIES_COLUMN_MOVIE_ID = "movieID";
	private static final String MOVIES_COLUMN_MOVIE_NAME = "movieName";
	private static final String MOVIES_COLUMN_MOVIE_SHOWTIME = "movieShowtime";
	private static final String MOVIES_COLUMN_MOVIE_CINEMAS = "movieCinemas";
	private static final String MOVIES_COLUMN_MOVIE_INFO = "movieInfo";

	private static final String ADD_MOVIE = "INSERT INTO" + MOVIES_TABLE + "(" + MOVIES_COLUMN_MOVIE_NAME + ")" + VALUES + "(?)";
	
	private static final String FIND_USER_BY_ID = "SELECT * FROM"
			+ MOVIES_TABLE + WHERE + MOVIES_COLUMN_MOVIE_ID + "=?";

	@Override
	public int addMovie(String name) {
		int addedMovieID = -1;
		connection = MySQLDAOFactory.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(ADD_MOVIE,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, name);
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) addedMovieID = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return addedMovieID;
	}

	@Override
	public Movie getMovieByID(int movieID) {
		Movie movieToFind = new Movie();
		connection = MySQLDAOFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(FIND_USER_BY_ID);
			rs = statement.executeQuery();
			if (rs.next()) {
				movieToFind.setMovieID(rs.getInt(MOVIES_COLUMN_MOVIE_ID));
				movieToFind.setMovieName(rs.getString(MOVIES_COLUMN_MOVIE_NAME));
				movieToFind.setMovieShowtime(rs.getTime(MOVIES_COLUMN_MOVIE_SHOWTIME));
				movieToFind.setMovieCinema(null);
				movieToFind.setMovieInfo(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return movieToFind;
	}

	@Override
	public int deletMovie(int movieID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Movie> getAllMoviev() {
		// TODO Auto-generated method stub
		return null;
	}

}
