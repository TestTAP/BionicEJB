package com.bionic.movieplex.dao.beans.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.factories.MySQLDAOFactory;
import com.mysql.jdbc.Statement;
import static com.bionic.movieplex.dao.constants.MySQLConstants.*;

public class MySQLUserDAO implements UserDAO {

	private Connection connection = null;

	private static final String USERS_TABLE = " Users ";
	private static final String USERS_COLUMN_USER_ID = "userID";
	private static final String USERS_COLUMN_USER_LOGIN = "userLogin";
	private static final String USERS_COLUMN_USER_PASSWORD = "userPassword";
	private static final String USERS_COLUMN_USER_NAME = "userName";
	private static final String USERS_COLUMN_USER_TYPE = "userType";

	private static final String SELECT_ALL_USERS = "SELECT * FROM"
			+ USERS_TABLE;
	private static final String ADD_USER = "INSERT INTO " + USERS_TABLE + "("
			+ USERS_COLUMN_USER_LOGIN + COMMA + USERS_COLUMN_USER_PASSWORD
			+ COMMA + USERS_COLUMN_USER_TYPE + ", " + USERS_COLUMN_USER_NAME
			+ ")" + VALUES + "(?,?,?,?)";
	private static final String UPDATE_USER = "UPDATE " + USERS_TABLE + SET
			+ USERS_COLUMN_USER_NAME + "=?," + USERS_COLUMN_USER_TYPE + "=?"
			+ WHERE + USERS_COLUMN_USER_ID + "=?";
	private static final String FIND_USER_BY_LOGIN_PASSWORD = SELECT_ALL_USERS
			+ USERS_TABLE + WHERE + USERS_COLUMN_USER_LOGIN + LIKE + "?" + AND
			+ USERS_COLUMN_USER_PASSWORD + LIKE + "?";

	@Override
	public List<User> getAllUsers() {
		List<User> usersToFind = new ArrayList<>();
		connection = MySQLDAOFactory.getConnection();
		ResultSet rs = null;
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(SELECT_ALL_USERS);
			rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserID(rs.getInt(USERS_COLUMN_USER_ID));
				user.setUserLogin(rs.getString(USERS_COLUMN_USER_LOGIN));
				user.setUserPassword(rs.getString(USERS_COLUMN_USER_PASSWORD));
				user.setUserName(rs.getString(USERS_COLUMN_USER_NAME));
				user.setUserType(rs.getString(USERS_COLUMN_USER_TYPE));
				usersToFind.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return usersToFind;
	}

	@Override
	public void addUser(User user) {
		connection = MySQLDAOFactory.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement(ADD_USER,
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, user.getUserLogin());
			statement.setString(2, user.getUserPassword());
			statement.setString(3, user.getUserType());
			statement.setString(4, user.getUserName());
			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
	}

	@Override
	public User updateUser(User user) {
//		int changedRows = -1;
//		connection = MySQLDAOFactory.getConnection();
//		PreparedStatement statement;
//		try {
//			statement = connection.prepareStatement(UPDATE_USER);
//			statement.setString(1, user.getUserName());
//			statement.setString(2, user.getUserType());
//			statement.setInt(3, user.getUserID());
//			changedRows = statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			MySQLDAOFactory.closeConnection();
//		}
		return null;
	}

	@Override
	public User findUserByLoginPassword(String userLogin, String userPassword) {
		User user = null;
		connection = MySQLDAOFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = connection
					.prepareStatement(FIND_USER_BY_LOGIN_PASSWORD);
			statement.setString(1, userLogin);
			statement.setString(2, userPassword);
			rs = statement.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserID(rs.getInt(USERS_COLUMN_USER_ID));
				user.setUserLogin(rs.getString(USERS_COLUMN_USER_LOGIN));
				user.setUserPassword(rs.getString(USERS_COLUMN_USER_PASSWORD));
				user.setUserName(rs.getString(USERS_COLUMN_USER_NAME));
				user.setUserType(rs.getString(USERS_COLUMN_USER_TYPE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MySQLDAOFactory.closeConnection();
		}
		return user;
	}

}
