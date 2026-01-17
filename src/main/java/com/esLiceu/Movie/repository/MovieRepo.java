package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    Movie findByTitle(String title);
    List<Movie> findTop5ByTitleContainingIgnoreCase(String q);
}
