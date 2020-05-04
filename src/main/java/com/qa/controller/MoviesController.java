package com.qa.controller;

import com.qa.domain.Movies;
import com.qa.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MoviesController {

    private final MovieService service;

    @Autowired
    public MoviesController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/getAllMovies")
    public List<Movies> getAllMovies(){
        return this.service.readMovies();
    }

    @PostMapping("/createMovies")
    public Movies createMovie(@RequestBody Movies movie){
        return this.service.createMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public boolean deleteMovie(@PathVariable Long id){
        return this.service.deleteMovie(id);
    }

    @GetMapping("/getMovieById/{id}")
    public Movies getMovieById(@PathVariable Long id){
        return this.service.findMovieById(id);
    }

    @PutMapping("/updateMovie/{id}")
    public Movies updateMovieById(@PathVariable Long id, @RequestBody Movies movie){
        return this.service.updateMovie(id,movie);
    }

    @PutMapping("/updateMovie2")
    public Movies updateMovies(@PathParam("id") Long id, @RequestBody Movies movie){
        return this.service.updateMovie(id, movie);
    }
}
