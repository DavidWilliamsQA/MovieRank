package com.qa.services;

import com.qa.domain.Movies;
import com.qa.exceptions.MovieNotFoundException;
import com.qa.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MoviesRepository movie;

    @Autowired
    public MovieService(MoviesRepository movie) {
        this.movie = movie;
    }

    public List<Movies> readMovies() {
        return this.movie.findAll();
    }

    public Movies createMovie(Movies movie) {
        return this.movie.save(movie);
    }

    public Movies findMovieById(Long id) {
        return this.movie.findById(id).orElseThrow(MovieNotFoundException::new);
    }

}
