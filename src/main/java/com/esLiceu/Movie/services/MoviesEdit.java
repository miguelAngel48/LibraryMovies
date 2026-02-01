package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesEdit {
    @Autowired
    MovieRepo movieRepo;


    public void saveMovie(Movie movie) {
        movie.getCast().forEach(c -> c.setMovie(movie));
        movie.getCrew().forEach(c -> c.setMovie(movie));
         movieRepo.save(movie);
    }

    public void deleteMovie(Integer movieId) {
        movieRepo.deleteById(movieId);
    }

    public Movie findByIdMovie(Integer id) {
        return movieRepo.findByMovieId(id);
    }

}
