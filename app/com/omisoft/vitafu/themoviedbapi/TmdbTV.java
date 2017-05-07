package com.omisoft.vitafu.themoviedbapi;

import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.tv.TvSeries;
import com.omisoft.vitafu.themoviedbapi.tools.ApiUrl;


public class TmdbTV extends AbstractTmdbApi {

    public static final String TMDB_METHOD_TV = "tv";

    public static enum TvMethod {credits, external_ids, images, videos}


    TmdbTV(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    /**
     * This method is used to retrieve all of the basic series information.
     *
     * @param seriesId
     * @param language
     */
    public TvSeries getSeries(int seriesId, String language, TvMethod... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_TV, seriesId);

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        apiUrl.appendToResponse(Utils.asStringArray(appendToResponse));

        return mapJsonResult(apiUrl, TvSeries.class);
    }
}
