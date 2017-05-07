package com.omisoft.vitafu.entity;

import javax.persistence.*;

/**
 * Represents subtitle entry
 * Created by dido on 11/13/14.
 */
@Entity
@Table(name="subtitle")
public class Subtitle extends BaseEntity {

    @Column(name = "subtitle_url",nullable = true)
    private String subtitleUrl;
    @Column(name = "subtitle_name",nullable = true)
    private String subtitleFileName;
    @Column(name = "subtitle_lang",nullable = true)
    private String subtitleLang;


    public String getSubtitleUrl() {
        return subtitleUrl;
    }

    public void setSubtitleUrl(String subtitleUrl) {
        this.subtitleUrl = subtitleUrl;
    }

    public String getSubtitleFileName() {
        return subtitleFileName;
    }

    public void setSubtitleFileName(String subtitleFileName) {
        this.subtitleFileName = subtitleFileName;
    }

    public String getSubtitleLang() {
        return subtitleLang;
    }

    public void setSubtitleLang(String subtitleLang) {
        this.subtitleLang = subtitleLang;
    }


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="movie_id")
    Movie movie;
}
