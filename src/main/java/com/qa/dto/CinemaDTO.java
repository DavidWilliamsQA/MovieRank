package com.qa.dto;

import com.qa.domain.Movies;

import java.util.ArrayList;
import java.util.List;

public class CinemaDTO {

    private Long cinema_id;
    private String location;
    private List<Movies> movies;

    public CinemaDTO(String location, List<Movies> movies) {
        this.location = location;
        this.movies = movies;
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
}
