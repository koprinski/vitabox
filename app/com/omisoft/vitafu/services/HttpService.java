package com.omisoft.vitafu.services;

/**
 * Created by dido on 10/16/14.
 */
public interface HttpService {
    public String getMovieMetadata(String query);

    public String getMP3Metadata(String query);

    public String getSubtitles(String query);
}
