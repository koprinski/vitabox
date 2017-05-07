package controllers;

import com.google.inject.Inject;
import com.omisoft.vitafu.mapping.ModelMapper;
import com.omisoft.vitafu.dao.movies.MovieDAO;
import com.omisoft.vitafu.dto.MoviePlayerDTO;
import com.omisoft.vitafu.entity.Movie;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by dido on 10/16/14.
 * Movies controller
 */
public class PlayMovie extends Controller {
    @Inject
    private MovieDAO movieDAO;

    @Inject
    private ModelMapper modelMapper;

    /**
     * Tetursn all movies as JSON list
     *
     * @return
     */
    public Result loadMovie(String movieId, String subsLang, String captionLang) {

        Movie movie = movieDAO.findByID(Long.valueOf(movieId));
        MoviePlayerDTO playerDTO = modelMapper.mapMovieToPlayerDTO(movie, captionLang, subsLang);

        return ok(Json.toJson(playerDTO));


    }


}
