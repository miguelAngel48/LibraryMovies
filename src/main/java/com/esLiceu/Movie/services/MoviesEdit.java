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
         movieRepo.save(movie);
    }


}
