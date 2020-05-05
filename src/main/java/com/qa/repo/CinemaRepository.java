package com.qa.repo;

import com.qa.domain.Cinemas;
import com.qa.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinemas, Long> {

}
