package com.omisoft.vitafu.services;

import com.omisoft.vitafu.cache.MovieLists;
import com.omisoft.vitafu.dao.APIKeys;
import com.omisoft.vitafu.entity.Genres;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.themoviedbapi.TmdbApi;
import com.omisoft.vitafu.themoviedbapi.TmdbFind;
import com.omisoft.vitafu.themoviedbapi.TmdbMovies;
import com.omisoft.vitafu.themoviedbapi.model.Genre;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;
import com.omisoft.vitafu.themoviedbapi.model.core.MovieResults;
import play.Logger;

import java.util.*;

/**
 * Tmdb Http service implementation
 * Created by bkoprinski on 15-1-6.
 */
public class TmdbHttpServiceImpl implements TmdbHttpService {

    /**
     * returns list of Upcoming movies from the Tmdb api
     * @return
     */
    @Override
    public List<MovieDb> getListUpcoming() {
        List<MovieDb> listUpcoming = new ArrayList<>();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();


        int totalPages = 5;//movies.getPopularMovieList("EN", 0).getTotalPages();

        Logger.info("Total pages = " + totalPages);

        for (int i=0; i<totalPages; i++) {
            MovieResults resultsUpcoming = movies.getUpcoming("EN", i);
            if (resultsUpcoming.getResults()!=null && !resultsUpcoming.getResults().isEmpty()) {
                for (MovieDb movieResult : resultsUpcoming.getResults()) {
                    if (movieResult.getPosterPath() != null) {
                        Set<Genres> genresSet = new HashSet<>();
//                        if (movies.getMovie(movieResult.getId(), "EN").getGenres() != null) {
                            for (Genre genre : movies.getMovie(movieResult.getId(), "EN").getGenres()) {
                                Genres genres = new Genres();
                                genres.setGenre(genre.getName());
                                genresSet.add(genres);
                                genreOfMovie.put(Long.valueOf(movieResult.getId()), genresSet);
                            }
                            movieResult.setImdbID(movies.getMovie(movieResult.getId(), "EN").getImdbID());
                            listUpcoming.add(movieResult);
//                        }
                    }
                }
            }
            Logger.info("Numer of page = " + i);
        }





        return listUpcoming;
    }

    /**
     * returns list of Popular movies from the Tmdb api
     * @return
     */
    @Override
    public List<MovieDb> getListPopular() {
        List<MovieDb> listPopular = new ArrayList<>();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();


        int totalPages = 5;//movies.getPopularMovieList("EN", 0).getTotalPages();

        Logger.info("Total pages = " + totalPages);

        for (int i=0; i<totalPages; i++) {
            MovieResults resultsPopular = movies.getPopularMovieList("EN", i);
            if (resultsPopular.getResults()!=null && !resultsPopular.getResults().isEmpty()) {
                for (MovieDb movieResult : resultsPopular.getResults()) {
                    if (movieResult.getPosterPath() != null) {
                        Set<Genres> genresSet = new HashSet<>();
//                        if (movies.getMovie(movieResult.getId(), "EN").getGenres() != null) {
                            for (Genre genre : movies.getMovie(movieResult.getId(), "EN").getGenres()) {
                                Genres genres = new Genres();
                                genres.setGenre(genre.getName());
                                genresSet.add(genres);
                                genreOfMovie.put(Long.valueOf(movieResult.getId()), genresSet);
                            }
                            movieResult.setImdbID(movies.getMovie(movieResult.getId(), "EN").getImdbID());
                            listPopular.add(movieResult);
//                        }
                    }
                }
            }
            Logger.info("Numer of page = " + i);

        }




        return listPopular;
    }

    /**
     * returns list of TopRated movies from the Tmdb api
     * @return
     */
    @Override
    public List<MovieDb> getListTopRated() {
        List<MovieDb> listTopRated = new ArrayList<>();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();




        int totalPages = 5;//movies.getPopularMovieList("EN", 0).getTotalPages();

        Logger.info("Total pages = " + totalPages);

        for (int i=0; i<totalPages; i++) {
            MovieResults resultsTopRated = movies.getTopRatedMovies("EN", i);
            if (resultsTopRated.getResults()!=null && !resultsTopRated.getResults().isEmpty()) {
                for (MovieDb movieResult : resultsTopRated.getResults()) {
                    if (movieResult.getPosterPath() != null) {
                        Set<Genres> genresSet = new HashSet<>();
//                        if (movies.getMovie(movieResult.getId(), "EN").getGenres() != null) {
                            for (Genre genre : movies.getMovie(movieResult.getId(), "EN").getGenres()) {
                                Genres genres = new Genres();
                                genres.setGenre(genre.getName());
                                genresSet.add(genres);
                                genreOfMovie.put(Long.valueOf(movieResult.getId()), genresSet);
                            }
                            movieResult.setImdbID(movies.getMovie(movieResult.getId(), "EN").getImdbID());
                            listTopRated.add(movieResult);
//                        }
                    }
                }
            }
            Logger.info("Numer of page = " + i);
        }



        return listTopRated;
    }

    /**
     * returns list of NowPlaying movies from the Tmdb api
     * @return
     */
    @Override
    public List<MovieDb> getListNowPlaying() {
        List<MovieDb> listNowPlaying = new ArrayList<>();
        Map<Long, Set<Genres>> genreOfMovie = MovieLists.getGenreOfMovies();
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();


        int totalPages = 5;//movies.getPopularMovieList("EN", 0).getTotalPages();

        Logger.info("Total pages = " + totalPages);

        for (int i=0; i<totalPages; i++) {
            MovieResults resultsNowPlaying = movies.getNowPlayingMovies("EN", 0);
            if (resultsNowPlaying.getResults()!=null && !resultsNowPlaying.getResults().isEmpty()) {
                for (MovieDb movieResult : resultsNowPlaying.getResults()) {
                    if (movieResult.getPosterPath() != null) {
                        Set<Genres> genresSet = new HashSet<>();
//                        if (movies.getMovie(movieResult.getId(), "EN").getGenres() != null) {
                            for (Genre genre : movies.getMovie(movieResult.getId(), "EN").getGenres()) {
                                Genres genres = new Genres();
                                genres.setGenre(genre.getName());
                                genresSet.add(genres);
                                genreOfMovie.put(Long.valueOf(movieResult.getId()), genresSet);
                            }
                            movieResult.setImdbID(movies.getMovie(movieResult.getId(), "EN").getImdbID());
                            listNowPlaying.add(movieResult);
//                        }
                    }
                }
            }
            Logger.info("Numer of page = " + i);
        }



        return listNowPlaying;
    }
}
