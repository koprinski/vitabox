package com.omisoft.vitafu.themoviedbapi.model.changes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.omisoft.vitafu.themoviedbapi.model.core.IdElement;


public class ChangedMovie extends IdElement {


    @JsonProperty("adult")
    private boolean adult;


    public boolean isAdult() {
        return adult;
    }


    public void setAdult(boolean adult) {
        this.adult = adult;
    }
}
