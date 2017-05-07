package com.omisoft.vitafu.dao.movies;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.omisoft.vitafu.cache.MovieLists;
import com.omisoft.vitafu.constants.MimeTypes;
import com.omisoft.vitafu.dao.APIKeys;
import com.omisoft.vitafu.dao.base.BaseDAOImpl;
import com.omisoft.vitafu.entity.Genres;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.entity.Subtitle;
import com.omisoft.vitafu.opensubtitlesapi.api.OpenSubtitles;
import com.omisoft.vitafu.opensubtitlesapi.impl.OpenSubtitlesImpl;
import com.omisoft.vitafu.opensubtitlesapi.response.SubtitleInfo;
import com.omisoft.vitafu.services.TmdbHttpService;
import com.omisoft.vitafu.themoviedbapi.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlrpc.XmlRpcException;
import org.reflections.util.Utils;
import play.Logger;
import com.omisoft.vitafu.themoviedbapi.model.Genre;
import com.omisoft.vitafu.themoviedbapi.model.MovieDb;
import com.omisoft.vitafu.themoviedbapi.model.core.MovieResults;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Created by dido on 10/16/14.
 * Currentlly loads from  web. Results should be persisted so that we can limit bandwidth
 */
public class MovieDAOHttpImpl extends BaseDAOImpl<Movie> implements MovieDAO {

    public MovieDAOHttpImpl(Class<Movie> type) {
        super(type);
    }

    public MovieDAOHttpImpl() {
        this(Movie.class);
    }

//    @Inject
//    private OpenSubtitles os;
    private static final String OS_API_BASE = "http://api.opensubtitles.org/xml-rpc";



    /**
     * Finds by ID one element
     * @return
     */
    @Override
    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<>();
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();

        TmdbCompany company = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getCompany();

        TmdbGenre find = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getGenre();


//        MovieResults results = movies.getPopularMovieList("EN", 2);

//
//        Logger.info("Test = " + find.getGenreMovies(28, "EN", 3, true));
//
//
//        Logger.info("Movie page 1 = " + movies.getPopularMovieList("EN", 1).getResults());
//
//        Logger.info("Movie page 2 = " + movies.getPopularMovieList("EN", 0).getTotalPages()); // 10462

        int totalPages = movies.getPopularMovieList("EN", 0).getTotalPages();

        Logger.info("Total pages = " + totalPages);

        for (int i=0; i<1000; i++) {
            MovieResults results = movies.getNowPlayingMovies("EN", i);
            if (results.getResults()!=null && !results.getResults().isEmpty()) {
                for (MovieDb movieResult : results.getResults()) {
                    Movie movie = new Movie();
                    movie.setTitle(movieResult.getTitle());
//                Logger.info("Movie Title = " + movie.getTitle());
                    movieList.add(movie);
                }
            }
            Logger.info("Numer of page = " + i);
        }

        Logger.info("List All movies = " + movieList);

        return null;


    }

    /**
     * Finds all the movies categorised by popularity in the movie.html
     * @return
     */
    @Override
    public List<Movie> findTitle(String category) {
        List<Movie> movieList = new ArrayList<>();
        List<Movie> listUpcoming = MovieLists.getListUpcoming();
        List<Movie> listPopular = MovieLists.getListPopular();
        List<Movie> listTopRated = MovieLists.getListTopRated();
        List<Movie> listNowPlaying = MovieLists.getListNowPlaying();
        Set<Movie> setAllMovies = MovieLists.getSetAllMovies();


        if(category.contains("upcoming")) {
            movieList = listUpcoming;
        }
        else if(category.contains("popular")) {
            movieList = listPopular;
        }
        else if(category.contains("top-rated")) {
            movieList = listTopRated;
        }
        else if(category.contains("now-playing")) {
            movieList = listNowPlaying;
        }
        else if(category.contains("action")) {
            movieList = getMovieBySubcategory(setAllMovies, "Action");
        }
        else if(category.contains("comedy")) {
            movieList = getMovieBySubcategory(setAllMovies, "Comedy");
        }
        else if(category.contains("drama")) {
            movieList = getMovieBySubcategory(setAllMovies, "Drama");
        }
        else if(category.contains("fantasy")) {
            movieList = getMovieBySubcategory(setAllMovies, "Fantasy");
        }


        return movieList;
    }

    /**
     * Finds movie by id and generates movie detail information by category which is used in the movieDetail.html
     * @param id
     * @return
     */
    @Override
    public Movie findMovieByIDAndCategory(String id, String category) {
        TmdbMovies movies = new TmdbApi(APIKeys.THEMOVIEDB_API_KEY).getMovies();
        Map<String, Movie> mapMoviesById = MovieLists.getMapMovieById();

        Movie movie = mapMoviesById.get(id);

        if (StringUtils.isEmpty(movie.getTrailerURL())) {
            if (movies.getVideos(Integer.parseInt(id), "EN").size() > 1) {
                movie.setTrailerURL(movies.getVideos(Integer.parseInt(id), "EN").get(0).getKey());
            }
        }
        movie.setSynopsis(movies.getMovie(Integer.parseInt(id),"EN", TmdbMovies.MovieMethod.alternative_titles).getOverview());
        movie.setImdbId(movies.getMovie(Integer.parseInt(id), "EN", TmdbMovies.MovieMethod.alternative_titles).getImdbID());

        return movie;
    }

    /**
     * Using the OpenSubtitles api we can find the subtitles for the requested movie
     * by searching with imdb movie id
     * @param id
     * @return
     */
    @Override
    public Subtitle findMovieSubs(String id) {
        OpenSubtitlesImpl os = null;
        Subtitle subtitle = new Subtitle();
        try {
            os = new OpenSubtitlesImpl(new URL(OS_API_BASE));
            os.login("en", "OSTestUserAgent");

            Logger.info("Open subtitles = " + os.searchSubtitles("bul", id)); // 120347

            List<SubtitleInfo> subtitleInfo = os.searchSubtitles("bul", id); //2310332

            for (SubtitleInfo subs : subtitleInfo) {
                subtitle.setSubtitleFileName(subs.getFileName());
                subtitle.setSubtitleLang("bul");
                subtitle.setSubtitleUrl(subs.getZipDownloadLink());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.logout();
                } catch (XmlRpcException e) {
                    e.printStackTrace();
                }
            }

        }


        return subtitle;
    }

    /**
     * Finds movie information by id
     * @param id
     * @return
     */
    @Override
    public Movie findMovieInfo(String id) {
        Map<String, Movie> mapMoviesById = MovieLists.getMapMovieById();
        Movie movie = mapMoviesById.get(id);

        return movie;
    }

    /**
     * Find the number of movies saved in the database
     * @return
     */
    @Override
    public int findNumMovieInDb(String category) {
        List<Movie> listMovies = findTitle(category);

        return listMovies.size();
    }

    /**
     * Categorizing by subcategory
     * @param allMovies
     * @return
     */
    private List<Movie> getMovieBySubcategory(Set<Movie> allMovies, String subCategory) {
        List<Movie> movieList = new ArrayList<>();

        for (Movie movie : allMovies) {
            for (Genres genre : movie.getGenres()) {
                if (genre.getGenre().contains(subCategory)) {
                    movieList.add(movie);
                }
            }
        }


        return movieList;
    }

}