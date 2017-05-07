package com.omisoft.vitafu.entity;

import javax.persistence.*;
import java.util.*;

/**
 * Holds basic movie info
 * Created by dido on 10/16/14.
 */
@javax.persistence.Entity
@Table(name="movie")
public class Movie extends BaseEntity {

    /**
     * Default constructor
     */
    public Movie(){
    }

    public Movie(String title, String poster, float votes, String relDate, Long viewCount) {
        this.title = title;
        this.poster = poster;
        this.votes = votes;
        this.relDate = relDate;
        this.viewCount = viewCount;
    }

    private String title;
    private String poster;
    private String imdbRating;
    @Transient
    private String magnetLinkURL;
    @Transient
    private String torrentURL;
    @Transient
    private String localURL;
    private Float votes = 0.0f;
    private Boolean featured = false;
    private Long viewCount;
    private String synopsis;
    private String trailerURL;
    private String relDate;
    private Boolean isInUpcomingList;
    private Boolean isInNowPlayingList;
    private Boolean isInPopularList;
    private Boolean isInTopRatedList;
    private Long tmdbId;
    private String imdbId;

    @ManyToMany(cascade=CascadeType.ALL)
    private Set<Genres> genres = new HashSet<>();
    @OneToMany(cascade=CascadeType.ALL)
    private transient List<Subtitle> subtitles;
    @Transient
    private Map<String, Caption> captions = new HashMap<String, Caption>();
    @Transient
    private String mimeType;

    public Map<String, Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(Map<String, Caption> captions) {
        this.captions = captions;
    }

    public String getMimeType() {
        return mimeType;
    }

    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getMagnetLinkURL() {
        return magnetLinkURL;
    }

    public void setMagnetLinkURL(String magnetLinkURL) {
        this.magnetLinkURL = magnetLinkURL;
    }

    public String getTorrentURL() {
        return torrentURL;
    }

    public void setTorrentURL(String torrentURL) {
        this.torrentURL = torrentURL;
    }

    public String getLocalURL() {
        return localURL;
    }

    public void setLocalURL(String localURL) {
        this.localURL = localURL;
    }

    public Float getVotes() {
        return votes;
    }

    public void setVotes(Float votes) {
        this.votes = votes;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getRelDate() {
        return relDate;
    }

    public void setRelDate(String relDate) {
        this.relDate = relDate;
    }

    public Set<Genres> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genres> genres) {
        this.genres = genres;
    }

    public Boolean getIsInUpcomingList() {
        return isInUpcomingList;
    }

    public void setIsInUpcomingList(Boolean isInUpcomingList) {
        this.isInUpcomingList = isInUpcomingList;
    }

    public Boolean getIsInNowPlayingList() {
        return isInNowPlayingList;
    }

    public void setIsInNowPlayingList(Boolean isInNowPlayingList) {
        this.isInNowPlayingList = isInNowPlayingList;
    }

    public Boolean getIsInPopularList() {
        return isInPopularList;
    }

    public void setIsInPopularList(Boolean isInPopularList) {
        this.isInPopularList = isInPopularList;
    }

    public Boolean getIsInTopRatedList() {
        return isInTopRatedList;
    }

    public void setIsInTopRatedList(Boolean isInTopRatedList) {
        this.isInTopRatedList = isInTopRatedList;
    }

    public Long getTmdbId() {
        return tmdbId;
    }

    public void setTmdbId(Long tmdbId) {
        this.tmdbId = tmdbId;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (Float.compare(movie.votes, votes) != 0) return false;
        if (captions != null ? !captions.equals(movie.captions) : movie.captions != null) return false;
        if (featured != null ? !featured.equals(movie.featured) : movie.featured != null) return false;
        if (genres != null ? !genres.equals(movie.genres) : movie.genres != null) return false;
        if (imdbRating != null ? !imdbRating.equals(movie.imdbRating) : movie.imdbRating != null) return false;
        if (localURL != null ? !localURL.equals(movie.localURL) : movie.localURL != null) return false;
        if (magnetLinkURL != null ? !magnetLinkURL.equals(movie.magnetLinkURL) : movie.magnetLinkURL != null)
            return false;
        if (mimeType != null ? !mimeType.equals(movie.mimeType) : movie.mimeType != null) return false;
        if (poster != null ? !poster.equals(movie.poster) : movie.poster != null) return false;
        if (relDate != null ? !relDate.equals(movie.relDate) : movie.relDate != null) return false;
        if (subtitles != null ? !subtitles.equals(movie.subtitles) : movie.subtitles != null) return false;
        if (synopsis != null ? !synopsis.equals(movie.synopsis) : movie.synopsis != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;
        if (torrentURL != null ? !torrentURL.equals(movie.torrentURL) : movie.torrentURL != null) return false;
        if (trailerURL != null ? !trailerURL.equals(movie.trailerURL) : movie.trailerURL != null) return false;
        if (viewCount != null ? !viewCount.equals(movie.viewCount) : movie.viewCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (poster != null ? poster.hashCode() : 0);
        result = 31 * result + (imdbRating != null ? imdbRating.hashCode() : 0);
        result = 31 * result + (magnetLinkURL != null ? magnetLinkURL.hashCode() : 0);
        result = 31 * result + (torrentURL != null ? torrentURL.hashCode() : 0);
        result = 31 * result + (localURL != null ? localURL.hashCode() : 0);
        result = 31 * result + (votes != +0.0f ? Float.floatToIntBits(votes) : 0);
        result = 31 * result + (featured != null ? featured.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (trailerURL != null ? trailerURL.hashCode() : 0);
        result = 31 * result + (relDate != null ? relDate.hashCode() : 0);
        result = 31 * result + (genres != null ? genres.hashCode() : 0);
        result = 31 * result + (subtitles != null ? subtitles.hashCode() : 0);
        result = 31 * result + (captions != null ? captions.hashCode() : 0);
        result = 31 * result + (mimeType != null ? mimeType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                ", magnetLinkURL='" + magnetLinkURL + '\'' +
                ", torrentURL='" + torrentURL + '\'' +
                ", localURL='" + localURL + '\'' +
                ", votes=" + votes +
                ", featured=" + featured +
                ", viewCount=" + viewCount +
                ", synopsis='" + synopsis + '\'' +
                ", trailerURL='" + trailerURL + '\'' +
                ", relDate='" + relDate + '\'' +
                ", isInUpcomingList=" + isInUpcomingList +
                ", isInNowPlayingList=" + isInNowPlayingList +
                ", isInPopularList=" + isInPopularList +
                ", isInTopRatedList=" + isInTopRatedList +
                ", tmdbId=" + tmdbId +
                ", genres=" + genres +
                ", subtitles=" + subtitles +
                ", captions=" + captions +
                ", mimeType='" + mimeType + '\'' +
                '}';
    }
}
