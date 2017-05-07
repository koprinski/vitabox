package com.omisoft.vitafu.dao.movies;

import com.omisoft.vitafu.dao.base.BaseDAOImpl;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.entity.Subtitle;

import java.util.Collection;
import java.util.List;

/** Movie DAO methods for accessing DB
 * Created by dido on 1/5/15.
 */
public class MovieDAOImpl extends BaseDAOImpl<Movie> implements MovieDAO{


    public MovieDAOImpl(Class<Movie> type) {
        super(type);
    }
    public MovieDAOImpl() {
        this(Movie.class);
    }



    /**
     * Finds the movies title and poster
     *
     * @param category
     * @return - list of movies with title and poster
     */
    @Override
    public List<Movie> findTitle(String category) {
        return null;
    }

    /**
     * Finds movie information by ID and category
     *
     * @param id
     * @param category
     * @return entity
     */
    @Override
    public Movie findMovieByIDAndCategory(String id, String category) {
        return null;
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
