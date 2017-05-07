package com.omisoft.vitafu.entity;

import javax.persistence.Entity;

/**
 * Represents one tv station
 * Created by dido on 11/4/14.
 */
@Entity
public class TVStation extends BaseEntity {
    private String stationName;
    private String stationURL;

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationURL() {
        return stationURL;
    }

    public void setStationURL(String stationURL) {
        this.stationURL = stationURL;
    }
}
