package com.omisoft.vitafu.opensubtitlesapi.api;


import com.omisoft.vitafu.opensubtitlesapi.response.MovieInfo;
import com.omisoft.vitafu.opensubtitlesapi.response.ServerInfo;
import com.omisoft.vitafu.opensubtitlesapi.response.SubtitleFile;
import com.omisoft.vitafu.opensubtitlesapi.response.SubtitleInfo;
import org.apache.xmlrpc.XmlRpcException;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * opensubtitles.org XML-RPC API client
 */
public interface OpenSubtitles {

    /**
     * Retrieves basic information about the server. It could be used for ping or telling server info to client, no
     * valid UserAgent is needed.
     *
     * @return server information
     *
     * @throws
     */
    public ServerInfo serverInfo() throws XmlRpcException;

    /**
     * Login as anonymous user. Logging in is required before talking to the OSDb server.
     *
     * @param lang      ISO639 2 letter language code
     * @param useragent UserAgent registered with OpenSubtitles
     *
     * @throws org.apache.xmlrpc.XmlRpcException
     */
    public void login(String lang, String useragent) throws XmlRpcException;

    /**
     * Login given user, set interface language and initiate session. Logging in is required before talking to the OSDb
     * server.
     *
     * Login user {user} identified by password {pass} communicating in language {lang} and working in client
     * application {useragent}. This function should be always called when starting communication with OSDb server to
     * identify user, specify application and start a new session (either registered user or anonymous).
     *
     * If user has no account, blank username and password should be used.
     *
     * @param user      username
     * @param pass      password
     * @param lang      ISO639 2 letter language code
     * @param useragent UserAgent registered with OpenSubtitles
     *
     * @throws org.apache.xmlrpc.XmlRpcException
     */
    public void login(String user, String pass, String lang, String useragent) throws XmlRpcException;

    /**
     * Logout the user and end the session. This method should always be called just before exiting the application.
     *
     * @throws org.apache.xmlrpc.XmlRpcException
     */
    public void logout() throws XmlRpcException;

    /**
     * This method is used to keep the session alive while client application is idling. Should be called every 15
     * minutes between XML-RPC requests (in case user is idle or client application is not currently communicating with
     * OSDb server) to keep the connection alive while client application is still running. It can be also used to check
     * if given session is still active.
     *
     * @throws org.apache.xmlrpc.XmlRpcException
     */
    public void noop() throws XmlRpcException;

    /**
     * Search for subtitle files matching your videos using a movie file.
     *
     * @param lang ISO639-3 language code
     * @param file Movie file
     *
     * @return Information about found subtitles
     *
     * @throws org.apache.xmlrpc.XmlRpcException
     * @throws java.io.IOException
     */
    public List<SubtitleInfo> searchSubtitles(String lang, File file) throws IOException, XmlRpcException;

    /**
     * Search for subtitle files matching your videos using IMDB ids. If {lang} is empty or contains the string 'all' -
     * search is performed for all languages. Please note that some fields (IDSubMovieFile, MovieHash, MovieByteSize,
     * MovieTimeMS) are missing in output when using this method.
     *
     * @param lang   ISO639-3 language code
     * @param imdbId IMDB movie ID
     *
     * @return Information about found subtitles
     *
     * @throws XmlRpcException
     */
    public List<SubtitleInfo> searchSubtitles(String lang, String imdbId) throws XmlRpcException;

    /**
     * Download given subtitle file
     *
     * @param subtitleFileID ID of the subtitle file to download
     *
     * @return Subtitle files
     *
     * @throws XmlRpcException
     */
    public List<SubtitleFile> downloadSubtitles(int subtitleFileID) throws XmlRpcException;

    /**
     * Searches for movies matching given movie title {query}. Returns list of movies data found on IMDb.com and in
     * internal server movie database. Manually added movies can be identified by ID starting at 10000000.
     *
     * @param query Query string
     *
     * @return Information about found movies
     *
     * @throws XmlRpcException
     */
    public List<MovieInfo> searchMoviesOnImdb(String query) throws XmlRpcException;

}
