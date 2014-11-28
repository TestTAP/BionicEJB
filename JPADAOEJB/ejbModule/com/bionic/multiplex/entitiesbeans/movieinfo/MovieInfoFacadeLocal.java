package com.bionic.multiplex.entitiesbeans.movieinfo;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.MovieInfo;

@Local
public interface MovieInfoFacadeLocal {

    void create(MovieInfo users);

    void edit(MovieInfo users);

    void remove(MovieInfo users);

    MovieInfo find(Object id);

    List<MovieInfo> findAll();
    
}
