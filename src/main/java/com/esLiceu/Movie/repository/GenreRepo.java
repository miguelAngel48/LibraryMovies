package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Integer> {

}
