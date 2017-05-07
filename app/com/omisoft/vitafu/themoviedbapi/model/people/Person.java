package com.omisoft.vitafu.themoviedbapi.model.people;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;
import com.omisoft.vitafu.themoviedbapi.model.core.NamedIdElement;


public class Person extends NamedIdElement {


    @JsonProperty("cast_id")
    private int castId;

    @JsonProperty("credit_id")
    private String creditId;

    @JsonProperty("profile_path")
    protected String profilePath;


    public String getProfilePath() {
        return profilePath;
    }


    public int getCastId() {
        return castId;
    }


    public String getCreditId() {
        return creditId;
    }


    public void setProfilePath(String profilePath) {
        this.profilePath = StringUtils.trimToEmpty(profilePath);
    }
}
