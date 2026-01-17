package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.DepartmentRepo;
import com.esLiceu.Movie.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesStock {
    @Autowired
    MovieRepo movieRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    public List<Movie> findAllMovies() {
       return movieRepo.findAll();
    }
    public Movie findByTitle(String title){

        return movieRepo.findByTitle(title);
    }


    public List<String> findTop5Titles(String query) {
        return movieRepo.findTop5ByTitleContainingIgnoreCase(query)
                .stream()
                .map(Movie::getTitle).toList();

    }
}
