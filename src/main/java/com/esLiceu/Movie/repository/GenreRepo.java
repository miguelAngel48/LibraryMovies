package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Integer> {

    List<Genre> findTop5ByGenreNameContainingIgnoreCase(String query);

    Genre findByGenreId(Integer id);
}
