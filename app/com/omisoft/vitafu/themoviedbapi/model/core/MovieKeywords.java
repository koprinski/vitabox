package com.omisoft.vitafu.themoviedbapi.model.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omisoft.vitafu.themoviedbapi.model.keywords.Keyword;

import java.util.ArrayList;
import java.util.List;


public class MovieKeywords extends AbstractJsonMapping {


    @JsonProperty("keywords")
    private List<Keyword> keywords = new ArrayList<Keyword>();


    public List<Keyword> getKeywords() {
        return keywords;
    }
}
