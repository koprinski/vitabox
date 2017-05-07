package controllers;

import com.google.inject.Inject;
import com.omisoft.vitafu.entity.Subtitle;
import com.omisoft.vitafu.mapping.ModelMapper;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.dto.MovieDTO;
import com.omisoft.vitafu.entity.Movie;
import play.Logger;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.dto.MovieDTO;
import com.omisoft.vitafu.entity.Movie;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by dido on 10/16/14.
 * Movies controller
 */
public class Movies extends Controller {
    @Inject
    private MovieDAO movieDAO;

    @Inject
    private ModelMapper modelMapper;


    /**
     * Im not using it now !!!
     * Returns all movies as JSON list
     *
     * @return
     */
//    public Result allMovies(String category) {
//
//        List<Movie> movies = movieDAO.findTitle(category);
////        Logger.info("tukkk2" );
//
//
//        return ok(Json.toJson(movies));
//
//    }



    /**
     * Returns all movies as JSON list
     *
     * @return
     */
    public Result returnMoviesByPage(String category, String page) {

        List<Movie> movies = new ArrayList<>();
        int pageSize = 5;
        int currentPage = Integer.parseInt(page);

        System.out.println("Current page = " + currentPage);

        if (currentPage == 0) {

            for (int i = currentPage; i < pageSize; i++)
            {
                Movie movie = movieDAO.findTitle(category).get(i);

                movies.add(movie);

            }
        }
        else {

            for (int i = (currentPage-1)*pageSize; i <currentPage*pageSize; i++)
            {
                Movie movie = movieDAO.findTitle(category).get(i);

                movies.add(movie);
            }
        }

        return ok(Json.toJson(movies));

    }


    /**
     * Returns movie details information by id
     * @param movieId
     * @return
     */
    public Result findMovieByID(String movieId, String category) {

        Movie movie = movieDAO.findMovieByIDAndCategory(movieId, category);
//        MovieDTO movieDTO = modelMapper.mapMovieById(movie);

        return ok(Json.toJson(movie));

    }

    /**
     * Returns the trailer id
     * @param trailerURL
     * @return
     */
    public Result returnTrailerURL(String trailerURL) {
        return ok(trailerURL);
    }

    /**
     * Returns movies subtitle information by movie id
     * @param movieId
     * @return
     */
    public Result returnSubtitles(String movieId) {
        Subtitle subtitle = movieDAO.findMovieSubs(movieId);

        return ok(Json.toJson(subtitle));
    }

    /**
     * Returns movies information by movie id
     * @param movieId
     * @return
     */
    public Result returnMovieInfo(String movieId) {
        Movie movie = movieDAO.findMovieInfo(movieId);

        return ok(Json.toJson(movie));
    }


    /**
     * Returns the number of movies saved in the database
     * @param category
     * @return
     */
    public Result returnNumMovieInDb(String category) {
        int numbMovies = movieDAO.findNumMovieInDb(category);

        return ok(Json.toJson(numbMovies));
    }


}
