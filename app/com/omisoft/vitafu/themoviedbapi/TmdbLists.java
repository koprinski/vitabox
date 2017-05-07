package com.omisoft.vitafu.themoviedbapi;

import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.ListItemStatus;
import com.omisoft.vitafu.themoviedbapi.model.MovieList;
import com.omisoft.vitafu.themoviedbapi.model.MovieListCreationStatus;
import com.omisoft.vitafu.themoviedbapi.model.core.SessionToken;
import com.omisoft.vitafu.themoviedbapi.model.core.StatusCode;
import com.omisoft.vitafu.themoviedbapi.tools.ApiUrl;
import com.omisoft.vitafu.themoviedbapi.tools.RequestMethod;

import java.util.Collections;
import java.util.HashMap;


public class TmdbLists extends AbstractTmdbApi {


    public static final String TMDB_METHOD_LIST = "list";


    public TmdbLists(TmdbApi tmdbApi) {
        super(tmdbApi);
    }


    /**
     * Get a list by its ID
     *
     * @param listId
     * @return The list and its items
     */
    public MovieList getList(String listId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_LIST, listId);

        return mapJsonResult(apiUrl, MovieList.class);
    }


    /**
     * This method lets users create a new list. A valid session id is required.
     *
     * @return The list id
     */
    public String createList(SessionToken sessionToken, String name, String description) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_LIST);

        apiUrl.addParam(TmdbAccount.PARAM_SESSION, sessionToken);

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("name", StringUtils.trimToEmpty(name));
        body.put("description", StringUtils.trimToEmpty(description));

        String jsonBody = Utils.convertToJson(jsonMapper, body);


        return mapJsonResult(apiUrl, MovieListCreationStatus.class, jsonBody).getListId();
    }


    /**
     * Check to see if a movie ID is already added to a list.
     *
     * @return true if the movie is on the list
     */
    public boolean isMovieOnList(String listId, Integer movieId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_LIST, listId, "item_status");

        apiUrl.addParam("movie_id", movieId);

        return mapJsonResult(apiUrl, ListItemStatus.class).isItemPresent();
    }


    /**
     * This method lets users add new movies to a list that they created. A valid session id is required.
     *
     * @return true if the movie is on the list
     */
    public StatusCode addMovieToList(SessionToken sessionToken, String listId, Integer movieId) {
        return modifyMovieList(sessionToken, listId, movieId, "add_item");
    }


    /**
     * This method lets users remove movies from a list that they created. A valid session id is required.
     *
     * @return true if the movie is on the list
     */
    public StatusCode removeMovieFromList(SessionToken sessionToken, String listId, Integer movieId) {
        return modifyMovieList(sessionToken, listId, movieId, "remove_item");
    }


    private StatusCode modifyMovieList(SessionToken sessionToken, String listId, Integer movieId, String operation) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_LIST, listId, operation);

        apiUrl.addParam(TmdbAccount.PARAM_SESSION, sessionToken);

        String jsonBody = Utils.convertToJson(jsonMapper, Collections.singletonMap("media_id", movieId + ""));

        return mapJsonResult(apiUrl, StatusCode.class, jsonBody);
    }


    /**
     * This method lets users delete a list that they created. A valid session id is required.
     */
    public StatusCode deleteMovieList(SessionToken sessionToken, String listId) {
        ApiUrl apiUrl = new ApiUrl(TMDB_METHOD_LIST, listId);

        apiUrl.addParam(TmdbAccount.PARAM_SESSION, sessionToken);

        return mapJsonResult(apiUrl, StatusCode.class, null, RequestMethod.DELETE);
    }
}
