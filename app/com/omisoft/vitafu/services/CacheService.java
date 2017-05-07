package com.omisoft.vitafu.services;

import com.omisoft.vitafu.entity.Movie;

import java.util.List;

/**
 * Interface with all the cache services
 * Created by bkoprinski on 14-12-29.
 */
public interface CacheService {

    /**
     * On start caches all movies by category
     */
    public void movieCache();

    /**
     * On start saves all movies details in the database
     */
    public void saveMoviesInfoInDB();

    /**
     * On start caches all movies from local database
     * @param movieList
     */
    public void cacheMovieFromDB(List<Movie> movieList);

    /**
     * Updates all the movies details in the database daily
     */
    public void updateMoviesInfoInDB();

}
