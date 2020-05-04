package com.qa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String releaseYear;
    private String director;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return getId().equals(movies.getId()) &&
                getTitle().equals(movies.getTitle()) &&
                getReleaseYear().equals(movies.getReleaseYear()) &&
                getDirector().equals(movies.getDirector());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getReleaseYear(), getDirector());
    }
}
