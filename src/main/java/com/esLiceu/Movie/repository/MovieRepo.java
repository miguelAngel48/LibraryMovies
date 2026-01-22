package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
    Movie findByMovieId(Integer movieId);

    List<Movie> findTop5ByTitleContainingIgnoreCase(String q);

    List<Movie> findDistinctByCastPersonPersonId(Integer actor);

    List<Movie> findDistinctByMovieGenresGenreGenreNameIgnoreCase(String genreName);

    List<Movie> findDistinctByCastCharacterName(String query);

    List<Movie> findDistinctByCrewPersonPersonNameContainingIgnoreCaseAndCrewJob(String query, String director);

}
