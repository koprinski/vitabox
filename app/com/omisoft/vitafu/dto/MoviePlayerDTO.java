package com.omisoft.vitafu.dto;

/**
 * Movie player DTO
 * Used to populate video player
 * Created by dido on 11/13/14.
 */
public class MoviePlayerDTO {
    private String movieId;
    private String poster;
    private String mp4Url;
    private String oggUrl;
    private String webmUrl;
    private String captionsUrl;
    private String captionsLang;
    private String captionsLabel;
    private String subsUrl;
    private String subsLang;
    private String subsLabel;


    @Override
    public String toString() {
        return "MoviePlayerDTO{" +
                "movieId='" + movieId + '\'' +
                ", poster='" + poster + '\'' +
                ", mp4Url='" + mp4Url + '\'' +
                ", oggUrl='" + oggUrl + '\'' +
                ", webmUrl='" + webmUrl + '\'' +
                ", captionsUrl='" + captionsUrl + '\'' +
                ", captionsLang='" + captionsLang + '\'' +
                ", captionsLabel='" + captionsLabel + '\'' +
                ", subsLang='" + subsLang + '\'' +
                ", subsLabel='" + subsLabel + '\'' +
                '}';
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getMp4Url() {
        return mp4Url;
    }

    public void setMp4Url(String mp4Url) {
        this.mp4Url = mp4Url;
    }

    public String getOggUrl() {
        return oggUrl;
    }

    public void setOggUrl(String oggUrl) {
        this.oggUrl = oggUrl;
    }

    public String getWebmUrl() {
        return webmUrl;
    }

    public void setWebmUrl(String webmUrl) {
        this.webmUrl = webmUrl;
    }

    public String getCaptionsUrl() {
        return captionsUrl;
    }

    public void setCaptionsUrl(String captionsUrl) {
        this.captionsUrl = captionsUrl;
    }

    public String getCaptionsLang() {
        return captionsLang;
    }

    public void setCaptionsLang(String captionsLang) {
        this.captionsLang = captionsLang;
    }

    public String getCaptionsLabel() {
        return captionsLabel;
    }

    public void setCaptionsLabel(String captionsLabel) {
        this.captionsLabel = captionsLabel;
    }

    public String getSubsLang() {
        return subsLang;
    }

    public void setSubsLang(String subsLang) {
        this.subsLang = subsLang;
    }

    public String getSubsLabel() {
        return subsLabel;
    }

    public void setSubsLabel(String subsLabel) {
        this.subsLabel = subsLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviePlayerDTO that = (MoviePlayerDTO) o;

        if (captionsLabel != null ? !captionsLabel.equals(that.captionsLabel) : that.captionsLabel != null)
            return false;
        if (captionsLang != null ? !captionsLang.equals(that.captionsLang) : that.captionsLang != null) return false;
        if (captionsUrl != null ? !captionsUrl.equals(that.captionsUrl) : that.captionsUrl != null) return false;
        if (movieId != null ? !movieId.equals(that.movieId) : that.movieId != null) return false;
        if (mp4Url != null ? !mp4Url.equals(that.mp4Url) : that.mp4Url != null) return false;
        if (oggUrl != null ? !oggUrl.equals(that.oggUrl) : that.oggUrl != null) return false;
        if (poster != null ? !poster.equals(that.poster) : that.poster != null) return false;
        if (subsLabel != null ? !subsLabel.equals(that.subsLabel) : that.subsLabel != null) return false;
        if (subsLang != null ? !subsLang.equals(that.subsLang) : that.subsLang != null) return false;
        if (webmUrl != null ? !webmUrl.equals(that.webmUrl) : that.webmUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = movieId != null ? movieId.hashCode() : 0;
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (mp4Url != null ? mp4Url.hashCode() : 0);
        result = 31 * result + (oggUrl != null ? oggUrl.hashCode() : 0);
        result = 31 * result + (webmUrl != null ? webmUrl.hashCode() : 0);
        result = 31 * result + (captionsUrl != null ? captionsUrl.hashCode() : 0);
        result = 31 * result + (captionsLang != null ? captionsLang.hashCode() : 0);
        result = 31 * result + (captionsLabel != null ? captionsLabel.hashCode() : 0);
        result = 31 * result + (subsLang != null ? subsLang.hashCode() : 0);
        result = 31 * result + (subsLabel != null ? subsLabel.hashCode() : 0);
        return result;
    }

    public String getSubsUrl() {
        return subsUrl;
    }

    public void setSubsUrl(String subsUrl) {
        this.subsUrl = subsUrl;
    }
}
