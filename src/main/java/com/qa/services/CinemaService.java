package com.qa.services;

import com.qa.domain.Cinemas;
import com.qa.dto.CinemaDTO;
import com.qa.exceptions.CinemaNotFoundException;
import com.qa.exceptions.MovieNotFoundException;
import com.qa.repo.CinemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaService {

    private final CinemaRepository repo;

    private final ModelMapper mapper;

    @Autowired
    public CinemaService(CinemaRepository cinema, ModelMapper mapper) {
        this.repo = cinema;
        this.mapper = mapper;
    }

    private CinemaDTO mapToDTO(Cinemas cinemas){
        return this.mapper.map(cinemas, CinemaDTO.class);
    }

    public List<CinemaDTO> readCinema() {
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CinemaDTO createCinema(Cinemas cinema) {
        Cinemas tempCinema =  this.repo.save(cinema);
        return this.mapToDTO(tempCinema);
    }

    public CinemaDTO findCinemaById(Long id) {
        return this.mapToDTO(this.repo.findById(id).orElseThrow(MovieNotFoundException::new));
    }

    public CinemaDTO updateCinema(Long id, Cinemas cinemas){
        Cinemas update = this.repo.findById(id).orElseThrow(MovieNotFoundException::new);
        update.setLocation(cinemas.getLocation());
        Cinemas tempCinema = this.repo.save(cinemas);
        return this.mapToDTO(tempCinema);
    }

    public boolean deleteCinema(Long id){
        if(!this.repo.existsById(id)){
            throw new CinemaNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }

}
