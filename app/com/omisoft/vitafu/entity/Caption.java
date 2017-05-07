package com.omisoft.vitafu.entity;

import javax.persistence.Entity;

/**
 * Represents caption data
 * Created by dido on 11/13/14.
 */
@Entity
public class Caption {

    private String captionUrl;
    private String captionLang;


    public String getCaptionUrl() {
        return captionUrl;
    }

    public void setCaptionUrl(String captionUrl) {
        this.captionUrl = captionUrl;
    }

    public String getCaptionLang() {
        return captionLang;
    }

    public void setCaptionLang(String captionLang) {
        this.captionLang = captionLang;
    }


}

