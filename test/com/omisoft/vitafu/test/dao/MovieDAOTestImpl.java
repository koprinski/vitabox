package com.omisoft.vitafu.test.dao;

import com.omisoft.vitafu.constants.MimeTypes;
import com.omisoft.vitafu.dao.APIKeys;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.entity.Subtitle;
import play.Logger;
import com.omisoft.vitafu.themoviedbapi.TmdbApi;
import com.omisoft.vitafu.themoviedbapi.TmdbMovies;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;
import com.omisoft.vitafu.themoviedbapi.model.core.MovieResults;

import java.util.*;

/**
 * Created by dido on 11/14/14.
 */
public class MovieDAOTestImpl implements MovieDAO {
    /**
     * Finds all elements
     *
     * @return
     */
    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public void deleteByID(Long id) {

    }


    /**
     * Updates entity
     *
     * @param movie tyoe
     * @return updated entity
     */
    @Override
    public Movie update(Movie movie) {
        return null;
    }


    /**
     * Finds by ID one element
     *
     * @param id@return entity
     */
    @Override
    public Movie findByID(Long id) {
        Movie movie = new Movie();
        movie.setLocalURL("https://www.youtube.com/watch?v=0vxOhd4qlnA");
        movie.setPoster("http://192.168.6.10/vitabox/images/ed_thumb.jpg");
        movie.setMimeType(MimeTypes.MP4.getType());
        movie.setId(Long.valueOf(id));
//        Map<String, Subtitle> subsMap = new HashMap<String, Subtitle>();
//        subsMap.put("en", new Subtitle("http://192.168.6.10/vitabox/subs/subs.srt", "en"));
//        movie.setSubtitles(subsMap);

        return movie;
    }

    @Override
    public Movie save(Movie movie) {
        return null;
    }

    @Override
    public void saveAll(Collection<Movie> collection) {

    }

    @Override
    public List<Movie> selectMoviesFromDB() {
        return null;
    }


    @Override
    public List<Movie> findTitle(String category) {
        List<Movie> movieList = new ArrayList<>();

        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();

        MovieResults results = movies.getUpcoming("EN", 0);

        for (MovieDb movieResult : results.getResults()) {
            if (movieResult.getTitle() != null) {
                Logger.info("Title:" + movieResult.getTitle());
                Movie movie = new Movie();
                movie.setTitle(movieResult.getTitle());
                movie.setSynopsis(movieResult.getOverview());
                Logger.info("Overview : " + movies.getMovie(movieResult.getId(), "EN", TmdbMovies.MovieMethod.alternative_titles).getOverview());
                Logger.info("Trailer : " + movies.getVideos(movieResult.getId(), "EN"));
                movieList.add(movie);
            }
        }
        return movieList;
    }

    @Override
    public Movie findMovieByIDAndCategory(String id, String category) {
        Movie movie = new Movie();
        movie.setId(Long.valueOf(id));
        movie.setPoster("https://image.tmdb.org/t/p/w185/yBxbh9flNSxsXIfjoB2HzwuM3zf.jpg");
        movie.setTitle("The Shoe Box");

        return movie;
    }

    @Override
    public Subtitle findMovieSubs(String id) {
        return null;
    }

    @Override
    public Movie findMovieInfo(String id) {
        return null;
    }

    @Override
    public int findNumMovieInDb(String category) {
        return 0;
    }

}
