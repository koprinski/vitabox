package com.omisoft.vitafu.dto;

/**
 * Radio DTO
 * Created by nslavov on 1/29/15.
 */
public class RadioDTO {
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
    public RadioDTO(){

    }

    /**
     * Initialization constructor
     * @param name
     * @param streamurl
     * @param category
     * @param country
     * @param bitrate
     * @param website
     * @param status
     */
    public RadioDTO(String name, String streamurl, String category, String country, String bitrate, String website, String status){
        this.name = name;
        this.streamurl = streamurl;
        this.category = category;
        this.country = country;
        this.bitrate = bitrate;
        this.website = website;
        this.status = status;

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
     * @param name
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
     * @param streamurl
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
     * @param category
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
     * @param country
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
     * @param bitrate
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
     * @param website
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
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
