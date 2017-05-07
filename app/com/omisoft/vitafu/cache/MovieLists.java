package com.omisoft.vitafu.cache;

import com.omisoft.vitafu.entity.Genres;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.themoviedbapi.model.Genre;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;

import java.util.*;

/**
 * Singleton class witch keeps all the lists sorted by category
 * Created by bkoprinski on 14-12-29.
 */
public class MovieLists {
    private static List<Movie> listUpcoming = new ArrayList<Movie>();
    private static List<Movie> listPopular = new ArrayList<Movie>();
    private static List<Movie> listTopRated = new ArrayList<Movie>();
    private static List<Movie> listNowPlaying = new ArrayList<Movie>();
    private static Set<Movie> setAllMovies = new HashSet<Movie>();
    private static Map<String, Movie> mapMovieById = new HashMap<String, Movie>();
    private static Map<Long, Movie> movieIdReference = new HashMap<>();
    private static Map<Long, Set<Genres>> genreOfMovies = new HashMap<>();

    /**
     * private constructor
     */
    private MovieLists(){}

    /**
     * Getting the instance of upcoming movies list
     * @return
     */
    public static List<Movie> getListUpcoming(){
        return listUpcoming;
    }

    /**
     * Getting the instance of popular movies list
     * @return
     */
    public static List<Movie> getListPopular(){
        return listPopular;
    }

    /**
     * Getting the instance of top-rated movies list
     * @return
     */
    public static List<Movie> getListTopRated(){
        return listTopRated;
    }

    /**
     * Getting the instance of now-playing movies list
     * @return
     */
    public static List<Movie> getListNowPlaying(){
        return listNowPlaying;
    }

    /**
     * Getting the instance of all movies set list
     * @return
     */
    public static Set<Movie> getSetAllMovies(){
        return setAllMovies;
    }

    /**
     * Getting the instance of a movie by id
     * @return
     */
    public static Map<String, Movie> getMapMovieById(){
        return mapMovieById;
    }

    /**
     * Getting the reference for a movie by id
     * @return
     */
    public static Map<Long, Movie> getMovieIdReference(){
        return movieIdReference;
    }

    /**
     * Getting the set of genre from tmdb api
     * @return
     */
    public static Map<Long, Set<Genres>> getGenreOfMovies(){
        return genreOfMovies;
    }
}
