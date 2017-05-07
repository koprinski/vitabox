package com.omisoft.vitafu.entity;

import javax.persistence.Entity;

/**
 * Holds info for pictures
 * Created by dido on 11/4/14.
 */
@Entity
public class Picture extends BaseEntity {
    private String pictureURL;
    private String description;

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
