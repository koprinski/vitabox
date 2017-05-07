package com.omisoft.vitafu.entity;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by dido on 10/16/14.
 */
@Entity
public class Attraction extends BaseEntity {
    private String name;
    private String visitCount;
    //TODO Move to seperate table for days
    private String workingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getMainPictureURL() {
        return mainPictureURL;
    }

    public void setMainPictureURL(String mainPictureURL) {
        this.mainPictureURL = mainPictureURL;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    private String synopsis;
    private String mainPictureURL;
    private List<Picture> pictureList;
    private List<Comment> comments;



}
