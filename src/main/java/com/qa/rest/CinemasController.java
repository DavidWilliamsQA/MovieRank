package com.qa.rest;

import com.qa.domain.Cinemas;
import com.qa.domain.Movies;
import com.qa.dto.CinemaDTO;
import com.qa.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CinemasController {

    private final CinemaService service;

    @Autowired
    public CinemasController(CinemaService service) {
        this.service = service;
    }

    @GetMapping("/getAllCinemas")
    public ResponseEntity<List<CinemaDTO>> getAllCinemas(){
        return ResponseEntity.ok(this.service.readCinema());
    }

    @PostMapping("/createCinemas")
    public ResponseEntity<CinemaDTO> createCinema(@RequestBody Cinemas cinemas){
        return new ResponseEntity<CinemaDTO>(this.service.createCinema(cinemas), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteCinema/{id}")
    public ResponseEntity<?> deleteCinema(@PathVariable Long id){
        return this.service.deleteCinema(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }

    @GetMapping("/getCinemaById/{id}")
    public ResponseEntity<CinemaDTO> getCinemaById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCinemaById(id));
    }

    @PutMapping("/updateCinema/{id}")
    public ResponseEntity<CinemaDTO> updateCinemaById(@PathVariable Long id, @RequestBody Cinemas cinemas){
        return ResponseEntity.ok(this.service.updateCinema(id,cinemas));
    }

    @PutMapping("/updateCinema2")
    public ResponseEntity<CinemaDTO> updateMovies(@PathParam("id") Long id, @RequestBody Cinemas cinemas){
        return ResponseEntity.ok(this.service.updateCinema(id, cinemas));
    }


}
