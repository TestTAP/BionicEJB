package com.bionic.multiplex.entitiesbeans.movieinfo;

import java.util.List;

import javax.ejb.Local;

import com.bionic.multiplex.entities.MovieInfo;

@Local
public interface MovieInfoFacadeLocal {

    void create(MovieInfo movieInfo);

    void edit(MovieInfo movieInfo);

    void remove(MovieInfo movieInfo);

    MovieInfo find(Object id);

    List<MovieInfo> findAll();
    
}
