package com.omisoft.vitafu.dao.movies;

import com.omisoft.vitafu.dao.base.BaseDAO;
import com.omisoft.vitafu.entity.Movie;
import com.omisoft.vitafu.entity.Subtitle;

import java.util.List;

/**
 * Created by dido on 10/16/14.
 * Currentlly loads from  web. Results should be persisted so that we can limit bandwidth
 */
public interface MovieDAO extends BaseDAO<Movie> {

    /**
     * Finds the movies title and poster
     * @return - list of movies with title and poster
     */
    public List<Movie> findTitle(final String category);

    /**
     * Finds movie information by ID
     *
     * @return entity
     */
    public Movie findMovieByIDAndCategory(final String id, final String category);

    /**
     * Using the OpenSubtitles api we can find the subtitles for the requested movie
     * @param id
     * @return
     */
    public Subtitle findMovieSubs(final String id);

    /**
     * Finds movie information by id
     * @param id
     * @return
     */
    public Movie findMovieInfo(final String id);

    /**
     * Find the number of movies saved in the database
     * @return
     */
    public int findNumMovieInDb(final String category);
}
