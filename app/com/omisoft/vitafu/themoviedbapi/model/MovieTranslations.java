package com.omisoft.vitafu.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omisoft.vitafu.themoviedbapi.model.core.IdElement;

import java.util.List;


public class MovieTranslations extends IdElement {

    @JsonProperty("translations")
    private List<Translation> translations;


    public List<Translation> getTranslations() {
        return translations;
    }
}
