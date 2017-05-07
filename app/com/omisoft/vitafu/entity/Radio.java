package com.omisoft.vitafu.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Represents radio station
 * Created by dido on 11/4/14.
 */
@Entity
public class Radio extends BaseEntity {

    private String name;
    private String streamurl;
    private String category;
    private String country;
    private String bitrate;
    private String website;
    private String status;

    /**
     * Default constructor
     */
    public Radio(){
    }

    /**
     * Initialization constructor
     * @param radioName
     * @param radioStreamUrl
     * @param radioCategory
     * @param radioCountry
     * @param radioBitrate
     * @param radioWebsite
     * @param radioStatus
     */
    public Radio(String radioName, String radioStreamUrl, String radioCategory, String radioCountry, String  radioBitrate,String radioWebsite,String radioStatus ) {
        this.name = radioName;
        this.streamurl = radioStreamUrl;
        this.category = radioCategory;
        this.country = radioCountry;
        this.bitrate = radioBitrate;
        this.website = radioWebsite;
        this.status = radioStatus;

    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Radio)) return false;
        if (!super.equals(o)) return false;

        Radio radio = (Radio) o;

        if (bitrate != null ? !bitrate.equals(radio.bitrate) : radio.bitrate != null) return false;
        if (category != null ? !category.equals(radio.category) : radio.category != null) return false;
        if (country != null ? !country.equals(radio.country) : radio.country != null) return false;
        if (currentlyPlaying != null ? !currentlyPlaying.equals(radio.currentlyPlaying) : radio.currentlyPlaying != null)
            return false;
        if (name != null ? !name.equals(radio.name) : radio.name != null) return false;
        if (status != null ? !status.equals(radio.status) : radio.status != null) return false;
        if (streamurl != null ? !streamurl.equals(radio.streamurl) : radio.streamurl != null) return false;
        if (website != null ? !website.equals(radio.website) : radio.website != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (streamurl != null ? streamurl.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (bitrate != null ? bitrate.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (currentlyPlaying != null ? currentlyPlaying.hashCode() : 0);
        return result;
    }

    /**
     * Getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param  name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter
     * @return streamurl
     */
    public String getStreamurl() {
        return streamurl;
    }
    /**
     * Setter
     * @param  streamurl
     */
    public void setStreamurl(String streamurl) {
        this.streamurl = streamurl;
    }
    /**
     * Getter
     * @return category
     */
    public String getCategory() {
        return category;
    }
    /**
     * Setter
     * @param  category
     */
    public void setCategory(String category) {
        this.category = category;
    }
    /**
     * Getter
     * @return country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Setter
     * @param  country
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * Getter
     * @return bitrate
     */
    public String getBitrate() {
        return bitrate;
    }
    /**
     * Setter
     * @param  bitrate
     */
    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }
    /**
     * Getter
     * @return website
     */
    public String getWebsite() {
        return website;
    }
    /**
     * Setter
     * @param  website
     */
    public void setWebsite(String website) {
        this.website = website;
    }
    /**
     * Getter
     * @return status
     */
    public String getStatus() {
        return status;
    }
    /**
     * Setter
     * @param  status
     */
    public void setStatus(String status) {
        this.status = status;
    }
    /**
     * Getter
     * @return currentlyPlaying
     */
    public String getCurrentlyPlaying() {
        return currentlyPlaying;
    }
    /**
     * Setter
     * @param  currentlyPlaying
     */
    public void setCurrentlyPlaying(String currentlyPlaying) {
        this.currentlyPlaying = currentlyPlaying;
    }

    private String currentlyPlaying;

}
