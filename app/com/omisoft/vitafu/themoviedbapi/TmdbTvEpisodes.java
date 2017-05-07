package com.omisoft.vitafu.themoviedbapi;

import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.Credits;
import com.omisoft.vitafu.themoviedbapi.model.tv.TvEpisode;
import com.omisoft.vitafu.themoviedbapi.tools.ApiUrl;


public class TmdbTvEpisodes extends AbstractTmdbApi {


    public static final String TMDB_METHOD_TV_EPISODE = "episode";


    public static enum EpisodeMethod {
        // base method shared by all tv apis
        credits, external_ids, images, videos
        // specific method for episodes
        // ...tbd
    }


    TmdbTvEpisodes(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    public TvEpisode getEpisode(int seriesId, int seasonNumber, int episodeNumber, String language, EpisodeMethod... appendToResponse) {
        ApiUrl apiUrl = new ApiUrl(TmdbTV.TMDB_METHOD_TV, seriesId, TmdbTvSeasons.TMDB_METHOD_TV_SEASON, seasonNumber, TMDB_METHOD_TV_EPISODE, episodeNumber);

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        apiUrl.appendToResponse(Utils.asStringArray(appendToResponse));

        return mapJsonResult(apiUrl, TvEpisode.class);
    }


    public Credits getCredits(int seriesId, int seasonNumber, int episodeNumber, String language) {
        ApiUrl apiUrl = new ApiUrl(TmdbTV.TMDB_METHOD_TV, seriesId, TmdbTvSeasons.TMDB_METHOD_TV_SEASON, seasonNumber, TMDB_METHOD_TV_EPISODE, episodeNumber, EpisodeMethod.credits);

        if (StringUtils.isNotBlank(language)) {
            apiUrl.addParam(PARAM_LANGUAGE, language);
        }

        return mapJsonResult(apiUrl, Credits.class);
    }
}
