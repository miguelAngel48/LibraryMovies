package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.MovieCast;
import com.esLiceu.Movie.models.entitys.MovieCastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCastRepo extends JpaRepository<MovieCast, MovieCastId> {

    List<MovieCast> findDistinctTop5ByCharacterNameContainingIgnoreCase(String query);

    List<MovieCast> findByMovie_MovieId(Integer movieId);

    void deleteById(Integer castId);

    Optional<MovieCast> findTopByMovie_MovieIdOrderByCastOrderDesc(Integer movieId);
}
