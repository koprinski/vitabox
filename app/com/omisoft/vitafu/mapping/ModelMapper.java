package com.omisoft.vitafu.mapping;

import com.omisoft.vitafu.dto.MovieDTO;
import com.omisoft.vitafu.dto.MoviePlayerDTO;
import com.omisoft.vitafu.entity.Movie;

import java.util.List;

/**
 * Maps DTOs and models
 * Created by dido on 11/13/14.
 */
public interface ModelMapper {
    /**
     * Maps Movie to MoviePlayerDTO
     *
     * @param movie
     * @return
     */
    MoviePlayerDTO mapMovieToPlayerDTO(final Movie movie, String captionLang, String subsLang);

    /**
     * Maps Movie to MovieDTO
     * @param movie
     * @return
     */
    List<MovieDTO> mapMovieDTO(final List<Movie> movie);

    /**
     * Maps Movie to MovieDTO
     * @param movie
     * @return
     */
    MovieDTO mapMovieById(final Movie movie);

}
