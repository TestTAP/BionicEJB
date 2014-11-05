package com.bionic.movieplex.logic.actions.commands;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionic.movieplex.beans.User;
import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.DAOFactoryType;
import com.bionic.movieplex.logic.actions.ActionCommand;
import com.bionic.movieplex.logic.managers.ConfigurationManager;
import com.bionic.movieplex.logic.managers.MessageManager;

public class LoginCommand implements ActionCommand {

	private static final String PARAM_NAME_LOGIN = "login";
	private static final String PARAM_NAME_PASSWORD = "password";

	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		String userLogin = request.getParameter(PARAM_NAME_LOGIN);
		String userPassword = request.getParameter(PARAM_NAME_PASSWORD);
		User user = DAOFactory.getDAOFactory(DAOFactoryType.MYSQL).getUserDAO()
				.findUserByLoginPassword(userLogin, userPassword);
		if (user != null) {
			request.setAttribute("userName", user.getUserName());
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.MAIN_PAGE_PATH);
		} else {
			request.setAttribute("errorMessage", MessageManager.getInstance()
					.getProperty(MessageManager.LOGIN_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		return page;
	}
}
