package com.bionic.movieplex;

import java.util.List;

import com.bionic.movieplex.beans.Cinema;
import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.DAOFactoryType;
import com.bionic.movieplex.dao.beans.cinema.CinemaDAO;
import com.bionic.movieplex.dao.beans.cinema.MySQLCinemaDAO;
import com.bionic.movieplex.dao.beans.user.UserDAO;

public class Main {
	public static void main(String[] args) {
		DAOFactory JPADAOFactory = DAOFactory.getDAOFactory(DAOFactoryType.JPA);
		UserDAO userDAO = JPADAOFactory.getUserDAO();
		System.out.println(userDAO.findUserByLoginPassword("Joey", "asd"));
	}
}
