package com.bionic.multiplex.commands;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;
import com.bionic.multiplex.manager.Config;

@EJB(name = "MovieFacadeLocal", beanInterface = MovieFacadeLocal.class)
public class CommandShowMovies implements ICommand {

	private MovieFacadeLocal movieEJB = null;

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse responce) throws ServletException, IOException {
		String page = null;

		movieEJB = lookupMovieFacadeLocal();

		List<Movie> movies = movieEJB.findAll();
		request.setAttribute("list", movies);
		page = Config.getInstance().getProperty(Config.MOVIES);

		return page;
	}

	private MovieFacadeLocal lookupMovieFacadeLocal() {
		try {
			Context c = new InitialContext();
			return (MovieFacadeLocal) c
					.lookup("java:comp/env/MovieFacadeLocal");
		} catch (NamingException ex) {
			Logger.getLogger(CommandLogin.class.getName()).log(Level.SEVERE,
					null, ex);
			throw new RuntimeException(ex);
		}
	}
}
