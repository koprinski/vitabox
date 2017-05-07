package com.omisoft.vitafu.services;

import com.google.inject.Inject;
import com.omisoft.vitafu.cache.MovieLists;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.dao.movies.MovieDAOHttpImpl;
import com.omisoft.vitafu.entity.Genres;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.themoviedbapi.model.Genre;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;
import play.Logger;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Cache services implementation
 * Created by bkoprinski on 14-12-29.
 */
public class CacheServiceImpl implements CacheService {

    @Inject
    private TmdbHttpService tmdbLists;

    @Inject
    private MovieDAO movieDAO;

    /**
     * On start caches all movies by category
     */
    @Override
    public void movieCache() {

        List<MovieDb> tmdbUpcomingMovies = tmdbLists.getListUpcoming();
        List<MovieDb> tmdbPopularMovies = tmdbLists.getListPopular();
        List<MovieDb> tmdbTopRatedMovies = tmdbLists.getListTopRated();
        List<MovieDb> tmdbNowPlayingMovies = tmdbLists.getListNowPlaying();

        checkUpcomingInSingleton(tmdbUpcomingMovies);
        checkPopularInSingleton(tmdbPopularMovies);
        checkTopRatedInSingleton(tmdbTopRatedMovies);
        checkNowPlayingInSingleton(tmdbNowPlayingMovies);
    }

    /**
     * On start saves all movies details in the database
     */
    @Override
    public void saveMoviesInfoInDB() {
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();

        for (Movie movie : setAllMovies) {
            movieDAO.save(movie);
        }
        Logger.info("All movies saved in DB!");
    }

    /**
     * On start caches all movies from the database
     * @param movieList
     */
    @Override
    public void cacheMovieFromDB(List<Movie> movieList) {
        List<Movie> listUpcoming = MovieLists.getListUpcoming();
        List<Movie> listPopular = MovieLists.getListPopular();
        List<Movie> listTopRated = MovieLists.getListTopRated();
        List<Movie> listNowPlaying = MovieLists.getListNowPlaying();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();
        Map<String, Movie> listMovieById = MovieLists.getMapMovieById();
        Map<Long, Movie> mapMovieReference = MovieLists.getMovieIdReference();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();


        for (Movie movie : movieList) {
            if (movie.getIsInUpcomingList() == true) {
                listUpcoming.add(movie);
            }
            else if (movie.getIsInPopularList() == true) {
                listPopular.add(movie);
            }
            else if (movie.getIsInTopRatedList() == true) {
                listTopRated.add(movie);
            }
            else if (movie.getIsInNowPlayingList() == true) {
                listNowPlaying.add(movie);
            }

            genreOfMovie.put(movie.getTmdbId(), movie.getGenres());
            mapMovieReference.put(movie.getTmdbId(), movie);
            setAllMovies.add(movie);
            listMovieById.put(movie.getId().toString(), movie);
        }
    }

    /**
     * Updates all the movies details in the database daily
     */
    @Override
    public void updateMoviesInfoInDB() {
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();

        for (Movie movie : setAllMovies) {
            movieDAO.update(movie);
        }
        Logger.info("All movies updated in DB!");
    }

    /**
     * This method checks if the movie is in the singleton list. If yes we don't make new object.
     */
    private void checkUpcomingInSingleton (List<MovieDb> tmdbMovieList) {
        List<Movie> listUpcoming = MovieLists.getListUpcoming();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        Map<String, Movie> listMovieById = MovieLists.getMapMovieById();
        Map<Long, Movie> mapMovieReference = MovieLists.getMovieIdReference();

        for (MovieDb movieTmdb : tmdbMovieList) {
            Long movieTmdbId = Long.valueOf(movieTmdb.getId());

            if (mapMovieReference.containsKey(movieTmdbId)) {
                mapMovieReference.get(movieTmdbId).setIsInUpcomingList(true);
            }
            else {

                Movie movie = new Movie(movieTmdb.getTitle(), movieTmdb.getPosterPath(), movieTmdb.getVoteAverage(), movieTmdb.getReleaseDate(), (long) 0);
                movie.setId(Long.valueOf(movieTmdb.getId()));
                movie.setImdbId(movieTmdb.getImdbID());
                movie.setIsInUpcomingList(true);
                movie.setIsInNowPlayingList(false);
                movie.setIsInPopularList(false);
                movie.setIsInTopRatedList(false);

                if (genreOfMovie.containsKey(movieTmdbId)) {
                    movie.setGenres(genreOfMovie.get(movieTmdbId));
                }

                mapMovieReference.put(movieTmdbId, movie);
                setAllMovies.add(movie);
                listMovieById.put(movie.getId().toString(), movie);
                listUpcoming.add(movie);
            }
        }
    }

    /**
     * This method checks if the movie is in the singleton list. If yes we don't make new object.
     */
    private void checkPopularInSingleton (List<MovieDb> tmdbMovieList) {
        List<Movie> listPopular = MovieLists.getListPopular();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        Map<String, Movie> listMovieById = MovieLists.getMapMovieById();
        Map<Long, Movie> mapMovieReference = MovieLists.getMovieIdReference();

        for (MovieDb movieTmdb : tmdbMovieList) {
            Long movieTmdbId = Long.valueOf(movieTmdb.getId());

            if (mapMovieReference.containsKey(movieTmdbId)) {
                mapMovieReference.get(movieTmdbId).setIsInPopularList(true);
            }
            else {
                Movie movie = new Movie(movieTmdb.getTitle(), movieTmdb.getPosterPath(), movieTmdb.getVoteAverage(), movieTmdb.getReleaseDate(), (long)0);
                movie.setId(Long.valueOf(movieTmdb.getId()));
                movie.setImdbId(movieTmdb.getImdbID());
                movie.setIsInPopularList(true);
                movie.setIsInUpcomingList(false);
                movie.setIsInNowPlayingList(false);
                movie.setIsInTopRatedList(false);

                if (genreOfMovie.containsKey(movieTmdbId)) {
                    movie.setGenres(genreOfMovie.get(movieTmdbId));
                }

                mapMovieReference.put(movieTmdbId, movie);
                setAllMovies.add(movie);
                listMovieById.put(movie.getId().toString(), movie);
                listPopular.add(movie);
            }
        }
    }

    /**
     * This method checks if the movie is in the singleton list. If yes we don't make new object.
     */
    private void checkTopRatedInSingleton (List<MovieDb> tmdbMovieList) {
        List<Movie> listTopRated = MovieLists.getListTopRated();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        Map<String, Movie> listMovieById = MovieLists.getMapMovieById();
        Map<Long, Movie> mapMovieReference = MovieLists.getMovieIdReference();

        for (MovieDb movieTmdb : tmdbMovieList) {
            Long movieTmdbId = Long.valueOf(movieTmdb.getId());

            if (mapMovieReference.containsKey(movieTmdbId)) {
                mapMovieReference.get(movieTmdbId).setIsInTopRatedList(true);
            }
            else {
                Movie movie = new Movie(movieTmdb.getTitle(), movieTmdb.getPosterPath(), movieTmdb.getVoteAverage(), movieTmdb.getReleaseDate(), (long)0);
                movie.setId(Long.valueOf(movieTmdb.getId()));
                movie.setImdbId(movieTmdb.getImdbID());
                movie.setIsInTopRatedList(true);
                movie.setIsInUpcomingList(false);
                movie.setIsInNowPlayingList(false);
                movie.setIsInPopularList(false);

                if (genreOfMovie.containsKey(movieTmdbId)) {
                    movie.setGenres(genreOfMovie.get(movieTmdbId));
                }

                mapMovieReference.put(movieTmdbId, movie);
                setAllMovies.add(movie);
                listMovieById.put(movie.getId().toString(), movie);
                listTopRated.add(movie);
            }
        }
    }

    /**
     * This method checks if the movie is in the singleton list. If yes we don't make new object.
     */
    private void checkNowPlayingInSingleton (List<MovieDb> tmdbMovieList) {
        List<Movie> listNowPlaying = MovieLists.getListNowPlaying();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        Map<String, Movie> listMovieById = MovieLists.getMapMovieById();
        Map<Long, Movie> mapMovieReference = MovieLists.getMovieIdReference();

        for (MovieDb movieTmdb : tmdbMovieList) {
            Long movieTmdbId = Long.valueOf(movieTmdb.getId());

            if (mapMovieReference.containsKey(movieTmdbId)) {
                mapMovieReference.get(movieTmdbId).setIsInNowPlayingList(true);
            }
            else {
                Movie movie = new Movie(movieTmdb.getTitle(), movieTmdb.getPosterPath(), movieTmdb.getVoteAverage(), movieTmdb.getReleaseDate(), (long)0);
                movie.setId(Long.valueOf(movieTmdb.getId()));
                movie.setImdbId(movieTmdb.getImdbID());
                movie.setIsInNowPlayingList(true);
                movie.setIsInUpcomingList(false);
                movie.setIsInPopularList(false);
                movie.setIsInTopRatedList(false);

                if (genreOfMovie.containsKey(movieTmdbId)) {
                    movie.setGenres(genreOfMovie.get(movieTmdbId));
                }

                mapMovieReference.put(movieTmdbId, movie);
                setAllMovies.add(movie);
                listMovieById.put(movie.getId().toString(), movie);
                listNowPlaying.add(movie);
            }
        }
    }
}