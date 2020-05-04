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

    public Movies createMovie(Movies movies) {
        return this.movie.save(movies);
    }

    public Movies findMovieById(Long id) {
        return this.movie.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Movies updateMovie(Long id, Movies movies){
        Movies update = findMovieById(id);
        update.setTitle(movies.getTitle());
        update.setReleaseYear(movies.getReleaseYear());
        update.setDirector(movies.getDirector());
        return this.movie.save(update);
    }

    public boolean deleteMovie(Long id){
        if(!this.movie.existsById(id)){
            throw new MovieNotFoundException();
        }
        this.movie.deleteById(id);
        return this.movie.existsById(id);
    }

}
