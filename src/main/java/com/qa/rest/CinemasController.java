package com.qa.rest;

import com.qa.domain.Cinemas;
import com.qa.domain.Movies;
import com.qa.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Cinemas> getAllCinemas(){
        return this.service.readCinema();
    }

    @PostMapping("/createCinemas")
    public Cinemas createCinema(@RequestBody Cinemas cinemas){
        return this.service.createCinema(cinemas);
    }

    @DeleteMapping("/deleteCinema/{id}")
    public boolean deleteCinema(@PathVariable Long id){
        return this.service.deleteCinema(id);
    }

    @GetMapping("/getCinemaById/{id}")
    public Cinemas getCinemaById(@PathVariable Long id){
        return this.service.findCinemaById(id);
    }

    @PutMapping("/updateCinema/{id}")
    public Cinemas updateCinemaById(@PathVariable Long id, @RequestBody Cinemas cinemas){
        return this.service.updateCinema(id,cinemas);
    }

    @PutMapping("/updateCinema2")
    public Cinemas updateMovies(@PathParam("id") Long id, @RequestBody Cinemas cinemas){
        return this.service.updateCinema(id, cinemas);
    }


}
