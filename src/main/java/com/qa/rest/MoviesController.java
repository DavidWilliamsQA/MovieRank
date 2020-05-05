package com.qa.rest;

import com.qa.domain.Movies;
import com.qa.dto.MovieDTO;
import com.qa.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<MovieDTO>> getAllMovies(){
        return ResponseEntity.ok(this.service.readMovies());
    }

    @PostMapping("/createMovies")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody Movies movie){
        return new ResponseEntity<MovieDTO>(this.service.createMovie(movie), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMovie/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id){
        return this.service.deleteMovie(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findMovieById(id));
    }

    @PutMapping("/updateMovie/{id}")
    public ResponseEntity<MovieDTO> updateMovieById(@PathVariable Long id, @RequestBody Movies movie){
        return ResponseEntity.ok(this.service.updateMovie(id,movie));
    }

    @PutMapping("/updateMovie2")
    public ResponseEntity<MovieDTO> updateMovies(@PathParam("id") Long id, @RequestBody Movies movie){
        return ResponseEntity.ok(this.service.updateMovie(id, movie));
    }
}
