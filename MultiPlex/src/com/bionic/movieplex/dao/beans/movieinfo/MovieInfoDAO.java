package com.bionic.movieplex.dao.beans.movieinfo;

import com.bionic.movieplex.beans.MovieInfo;

public interface MovieInfoDAO {
	
	public int addMovieInfo(MovieInfo movieInfo);
	
	public MovieInfo getMovieInfoByID(int movieInfoID);
	
	public int deleteMovidInfo(int movieInfoID);
}
