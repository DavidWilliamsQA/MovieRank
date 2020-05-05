package com.qa.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cinemas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cinema_id;
    private String location;

    @OneToMany(mappedBy = "cinemaName", fetch = FetchType.LAZY)
    private List<Movies> movies = new ArrayList<>();

    public Cinemas() {
    }

    public Cinemas(String location) {
        this.location = location;
    }

    public Long getCinema_id() {
        return cinema_id;
    }

    public void setCinema_id(Long cinema_id) {
        this.cinema_id = cinema_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Movies> getMovies() {
        return movies;
    }

    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinemas)) return false;
        Cinemas cinemas = (Cinemas) o;
        return getCinema_id().equals(cinemas.getCinema_id()) &&
                getLocation().equals(cinemas.getLocation()) &&
                getMovies().equals(cinemas.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCinema_id(), getLocation(), getMovies());
    }
}
