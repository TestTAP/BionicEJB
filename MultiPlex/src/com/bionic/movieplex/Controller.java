package com.bionic.movieplex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionic.movieplex.dao.DAOFactory;
import com.bionic.movieplex.dao.DAOFactoryType;
import com.bionic.movieplex.logic.actions.ActionCommand;
import com.bionic.movieplex.logic.actions.ActionFactory;
import com.bionic.movieplex.logic.managers.ConfigurationManager;
import com.bionic.movieplex.logic.managers.MessageManager;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_DAO = "DEFAULT_DAO";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		DAOFactoryType daoType = DAOFactoryType.valueOf(ConfigurationManager
				.getInstance().getProperty(DEFAULT_DAO).toUpperCase());
		DAOFactory.setDAOFactory(daoType);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = null;
		try {
			ActionCommand command = ActionFactory.getInstance().getCommand(
					request);
			page = command.execute(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
			request.setAttribute(
					"errorMessage",
					MessageManager.getInstance().getProperty(
							MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		} catch (IOException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", MessageManager.getInstance()
					.getProperty(MessageManager.IO_EXCEPTION_ERROR_MESSAGE));
			page = ConfigurationManager.getInstance().getProperty(
					ConfigurationManager.ERROR_PAGE_PATH);
		}
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
