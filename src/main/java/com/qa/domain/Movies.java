package com.qa.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "movies_table")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movie_id;
    private String title;
    private String releaseYear;
    private String director;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movies)) return false;
        Movies movies = (Movies) o;
        return getMovie_id().equals(movies.getMovie_id()) &&
                getTitle().equals(movies.getTitle()) &&
                getReleaseYear().equals(movies.getReleaseYear()) &&
                getDirector().equals(movies.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie_id(), getTitle(), getReleaseYear(), getDirector());
    }
}
