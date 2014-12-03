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
	}
}
