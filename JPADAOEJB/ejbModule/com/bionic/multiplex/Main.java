package com.bionic.multiplex;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bionic.multiplex.entities.Order;
import com.bionic.multiplex.entities.Movie;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacade;
import com.bionic.multiplex.entitiesbeans.movie.MovieFacadeLocal;
import com.bionic.multiplex.entitiesbeans.order.OrderFacade;
import com.bionic.multiplex.entitiesbeans.order.OrderFacadeLocal;

@Named
public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPADAOEJB");
		System.out.println(emf);
		EntityManager em = emf.createEntityManager();
		MovieFacadeLocal movieEJB = new MovieFacade(em);
		OrderFacadeLocal orderEJB = new OrderFacade(em);
		List<Order> orders = orderEJB.findAll();
		for (int i = 0; i < orders.size(); i++) {
			System.out.println(orders.get(i));
		}
		List<Movie> movies = movieEJB.findAll();
		for (int i = 0; i < movies.get(0).getMovieCinemas().size(); i++) {
			System.out.println(movies.get(0).getMovieCinemas().get(i));
		}
/*		//System.out.println(movieEJB.find(1));
//		em.getTransaction().begin();
		List<Movie> movies = movieEJB.findAll();
//		System.out.println(movies.get(0).getMovieCinemas().get(0));
		for (int i = 0; i < movies.get(0).getMovieCinemas().size(); i++) {
			System.out.println(movies.get(0).getMovieCinemas().get(i));
		}
		CinemaFacadeLocal cinemaEJB = new CinemaFacade();
		((CinemaFacade)cinemaEJB).setEntityManager(em);
		List<Cinema> cinemas = cinemaEJB.findAll();
		for (Cinema cinema: cinemas) {
			System.out.println(cinema.getCinemaMovies());
		}*/
//		em.getTransaction().commit();
/*		Movie movie = new Movie();
		movie.setMovieID(2);
		movie.setMovieInfo(null);
		movie.setMovieName("New Movie");
		movie.setMovieShowtime(new Time(System.currentTimeMillis()));
		
		Cinema cinema = new Cinema();
		cinema.setCinemaID(2);
		cinema.setCinemaName("New Cinema");
		cinema.setCinemaPlaces(10);
		cinema.setCinemaRows(10);
		List<Movie> cinemaMovies = new ArrayList<Movie>();
		cinemaMovies.add(movie);
		cinema.setCinemaMovies(cinemaMovies);
		
		em.getTransaction().begin();
		em.persist(movie);
		em.persist(cinema);
		em.getTransaction().commit();*/
	}
}
