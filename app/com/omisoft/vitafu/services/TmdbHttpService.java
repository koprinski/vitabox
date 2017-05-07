package com.omisoft.vitafu.services;

import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;
import com.omisoft.vitafu.themoviedbapi.model.core.MovieResults;

import java.util.List;

/**
 * Tmdb Http Service interface
 * Created by bkoprinski on 15-1-6.
 */
public interface TmdbHttpService {
    /**
     * returns list of Upcoming movies from the Tmdb api
     * @return
     */
    public List<MovieDb> getListUpcoming();

    /**
     * returns list of Popular movies from the Tmdb api
     * @return
     */
    public List<MovieDb> getListPopular();

    /**
     * returns list of TopRated movies from the Tmdb api
     * @return
     */
    public List<MovieDb> getListTopRated();

    /**
     * returns list of Now Playing movies from the Tmdb api
     * @return
     */
    public List<MovieDb> getListNowPlaying();
}
