package com.omisoft.vitafu.themoviedbapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.omisoft.vitafu.themoviedbapi.model.core.NamedElement;


public class Translation extends NamedElement {

    @JsonProperty("iso_639_1")
    private String isoCode;


    @JsonProperty("english_name")
    private String englishName;


    public String getEnglishName() {
        return englishName;
    }


    public String getIsoCode() {
        return isoCode;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
