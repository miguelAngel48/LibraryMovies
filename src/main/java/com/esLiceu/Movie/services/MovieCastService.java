package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.models.entitys.MovieCast;
import com.esLiceu.Movie.models.entitys.MovieCastId;
import com.esLiceu.Movie.repository.MovieCastRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCastService {
    @Autowired
    MovieCastRepo movieCastRepo;
    public List<MovieCast> findByMovieId(Integer movieId) {
       return movieCastRepo.findByMovie_MovieId(movieId);
    }

    public void save(MovieCast cast) {
        movieCastRepo.save(cast);
    }

    public void delete(MovieCastId castId) {
        movieCastRepo.deleteById(castId);
    }
}
