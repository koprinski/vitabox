package com.omisoft.vitafu.themoviedbapi.model.tv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omisoft.vitafu.themoviedbapi.model.Credits;
import com.omisoft.vitafu.themoviedbapi.model.ExternalIds;
import com.omisoft.vitafu.themoviedbapi.model.MovieImages;
import com.omisoft.vitafu.themoviedbapi.model.Video;
import com.omisoft.vitafu.themoviedbapi.model.core.NamedIdElement;

import java.util.List;


public class AbstractTvElement extends NamedIdElement {


    // Appendable responses for all tv elements

    @JsonProperty("credits")
    private Credits credits;

    @JsonProperty("external_ids")
    private ExternalIds externalIds;

    @JsonProperty("images")
    private MovieImages images;

    @JsonProperty("videos")
    private Video.Results videos;


    public Credits getCredits() {
        return credits;
    }


    public ExternalIds getExternalIds() {
        return externalIds;
    }


    public MovieImages getImages() {
        return images;
    }


    public List<Video> getVideos() {
        return videos != null ? videos.getVideos() : null;
    }
}
