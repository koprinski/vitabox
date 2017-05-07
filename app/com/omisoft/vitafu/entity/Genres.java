package com.omisoft.vitafu.entity;

import com.omisoft.vitafu.themoviedbapi.model.Genre;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Table which holds the genres of all movies
 */
@Entity
@Table(name="genres")
public class Genres extends BaseEntity {

    @Column(name = "genres_name",nullable = true)
    private String genre="";


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<>();

}
