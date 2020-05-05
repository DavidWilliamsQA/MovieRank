package com.qa.services;

import com.qa.domain.Cinemas;
import com.qa.domain.Movies;
import com.qa.exceptions.CinemaNotFoundException;
import com.qa.exceptions.MovieNotFoundException;
import com.qa.repo.CinemaRepository;
import com.qa.repo.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaService {

    private final CinemaRepository cinema;

    @Autowired
    public CinemaService(CinemaRepository cinema) {
        this.cinema = cinema;
    }

    public List<Cinemas> readCinema() {
        return this.cinema.findAll();
    }

    public Cinemas createCinema(Cinemas cinema) {
        return this.cinema.save(cinema);
    }

    public Cinemas findCinemaById(Long id) {
        return this.cinema.findById(id).orElseThrow(MovieNotFoundException::new);
    }

    public Cinemas updateCinema(Long id, Cinemas cinemas){
        Cinemas update = findCinemaById(id);
        update.setLocation(cinemas.getLocation());
        return this.cinema.save(update);
    }

    public boolean deleteCinema(Long id){
        if(!this.cinema.existsById(id)){
            throw new CinemaNotFoundException();
        }
        this.cinema.deleteById(id);
        return this.cinema.existsById(id);
    }

}
