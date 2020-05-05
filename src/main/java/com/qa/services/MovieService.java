package com.qa.services;

import com.qa.domain.Movies;
import com.qa.dto.MovieDTO;
import com.qa.exceptions.MovieNotFoundException;
import com.qa.repo.MoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MoviesRepository repo;

    private final ModelMapper mapper;


    @Autowired
    public MovieService(MoviesRepository movie, ModelMapper mapper) {
        this.repo = movie;
        this.mapper = mapper;
    }

    private MovieDTO mapToDTO(Movies movies){
        return this.mapper.map(movies, MovieDTO.class);
    }

    public List<MovieDTO> readMovies() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public MovieDTO createMovie(Movies movies) {
        Movies tempMovie = this.repo.save(movies);
        return this.mapToDTO(tempMovie);
    }

    public MovieDTO findMovieById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow(MovieNotFoundException::new));
    }

    public MovieDTO updateMovie(Long id, Movies movies){
        Movies update = this.repo.findById(id).orElseThrow(MovieNotFoundException::new);
        update.setTitle(movies.getTitle());
        update.setReleaseYear(movies.getReleaseYear());
        update.setDirector(movies.getDirector());
        Movies tempMovie = this.repo.save(movies);
        return this.mapToDTO(tempMovie);
    }

    public boolean deleteMovie(Long id){
        if(!this.repo.existsById(id)){
            throw new MovieNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
