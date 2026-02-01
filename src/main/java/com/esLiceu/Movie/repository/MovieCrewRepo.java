package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.models.entitys.MovieCrew;
import com.esLiceu.Movie.models.entitys.MovieCrewId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieCrewRepo extends JpaRepository<MovieCrew, MovieCrewId> {
    List<MovieCrew> findByMovie_MovieId(Integer movieId);
}
