package com.bionic.multiplex;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacade;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;

@Named
public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADAOEJB");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		MovieFacadeLocal movieEJB = new MovieFacade();
		((MovieFacade)movieEJB).setEntityManager(em);
		//System.out.println(movieEJB.find(1));
		List<Movie> movies = movieEJB.findAll();
		for (Movie movie: movies) {
			System.out.println(movie);
		}
	}
}
