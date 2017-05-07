package com.omisoft.vitafu.dto;

/**
 * Movie DTO
 * Created by bkoprinski on 14-11-21.
 */
public class MovieDTO {
    private String movieId;
    private String poster;
    private String title;
    private String date;
    private float votes;
    private Long viewCount;
    private String synopsis;

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    private String trailerURL;


    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getVotes() {
        return votes;
    }

    public void setVotes(float votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "movieId='" + movieId + '\'' +
                ", poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", votes=" + votes +
                ", viewCount=" + viewCount +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }

}
