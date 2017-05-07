package com.omisoft.vitafu.entity;

import javax.persistence.Entity;

/**
 * Music Clip Entity
 * Created by dido on 10/16/14.
 */
@Entity
public class Music extends BaseEntity {
    private String name;
    private String magnetURL;
    private Long votes;
    private String synopsis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMagnetURL() {
        return magnetURL;
    }

    public void setMagnetURL(String magnetURL) {
        this.magnetURL = magnetURL;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getStreamURL() {
        return streamURL;
    }

    public void setStreamURL(String streamURL) {
        this.streamURL = streamURL;
    }

    private String streamURL;

}
