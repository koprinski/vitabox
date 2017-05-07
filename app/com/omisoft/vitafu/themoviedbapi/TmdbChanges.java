package com.omisoft.vitafu.themoviedbapi;

import com.omisoft.vitafu.themoviedbapi.tools.MovieDbException;
import com.omisoft.vitafu.themoviedbapi.tools.MovieDbExceptionType;


public class TmdbChanges extends AbstractTmdbApi {

    TmdbChanges(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    public void getMovieChangesList(int page, String startDate, String endDate) {
        throw new MovieDbException(MovieDbExceptionType.UNKNOWN_CAUSE, "Not implemented yet");
    }


    public void getPersonChangesList(int page, String startDate, String endDate) {
        throw new MovieDbException(MovieDbExceptionType.UNKNOWN_CAUSE, "Not implemented yet");
    }
}
