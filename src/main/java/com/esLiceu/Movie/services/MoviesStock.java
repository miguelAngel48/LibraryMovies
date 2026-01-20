package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.DepartmentRepo;
import com.esLiceu.Movie.repository.GenreRepo;
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
    @Autowired
    GenreRepo genreRepo;
    public enum SearchType {
        PERSON,
        MOVIE,
        DIRECTOR,
        CHARACTER,
        GENRE
    }
    public List<Movie> findAllMovies() {
       return movieRepo.findAll();
    }
    public List<Movie> globalFinder(String query, SearchType type){
        switch (type){
            case PERSON -> findByActor(query);
            case MOVIE -> findByTitle(query);
            case GENRE -> findByGenre(query);
        }

        return  findAllMovies();
    }

    private List<Movie> findByGenre(String query) {
     return movieRepo.findDistinctByMovieGenresGenreGenreNameIgnoreCase(query);
    }

    public Movie findByTitle(String title){

        return movieRepo.findByTitle(title);
    }

    public List<Movie> findByActor(String actor) {
        List<Movie> filmsActor = movieRepo.findDistinctByCastPersonPersonName(actor);
        System.out.println(filmsActor);
        return filmsActor;
    }
    public List<String> findTop5Titles(String query) {
        return movieRepo.findTop5ByTitleContainingIgnoreCase(query)
                .stream()
                .map(Movie::getTitle).toList();

    }
}
