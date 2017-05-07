package com.omisoft.vitafu.themoviedbapi;

import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.Reviews;
import com.omisoft.vitafu.themoviedbapi.model.core.ResultsPage;
import com.omisoft.vitafu.themoviedbapi.tools.ApiUrl;

import java.util.List;


public class TmdbReviews extends AbstractTmdbApi {

    TmdbReviews(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    public List<Reviews> getReviews(int movieId, String language, Integer page) {
        ApiUrl apiUrl = new ApiUrl(TmdbMovies.TMDB_METHOD_MOVIE, movieId, "reviews");

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        if (page != null && page > 0) {
            apiUrl.addParam(PARAM_PAGE, page);
        }

        return mapJsonResult(apiUrl, ReviewResults.class).getResults();
    }


    private static class ReviewResults extends ResultsPage<Reviews> {

    }

}