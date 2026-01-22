package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.DTO.DataMovieManipulate;
import com.esLiceu.Movie.models.entitys.Department;
import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.DepartmentRepo;
import com.esLiceu.Movie.repository.GenreRepo;
import com.esLiceu.Movie.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<Movie> globalFinder(String query,Integer idMovie, SearchType type){
        List<Movie> returnsMovies = new ArrayList<>();
        switch (type){
            case PERSON -> {

                return findByActor(idMovie);
            }
            case MOVIE -> {
                returnsMovies.add(findByTitle(idMovie));
                return returnsMovies;
            }
            case DIRECTOR -> {
                return findByDirectorMovies(query);
            }
            case CHARACTER -> {
                return findByCharacterMovie(query);
            }
            case GENRE -> {
                return findByGenre(query);
            }

        }

        return  findAllMovies();
    }

    private List<Movie> findByDirectorMovies(String query) {
        return  movieRepo.findDistinctByCrewPersonPersonNameContainingIgnoreCaseAndCrewJob(query,"Director");
    }

    private List<Movie> findByCharacterMovie(String query) {
        return  movieRepo.findDistinctByCastCharacterName(query);
    }

    private List<Movie> findByGenre(String query) {
     return movieRepo.findDistinctByMovieGenresGenreGenreNameIgnoreCase(query);
    }

    public Movie findByTitle(Integer title){
        return movieRepo.findByMovieId(title);
    }

    public List<Movie> findByActor(Integer actor) {
        List<Movie> filmsActor = movieRepo.findDistinctByCastPersonPersonId(actor);
        System.out.println(filmsActor);
        return filmsActor;
    }
    public List<DataMovieManipulate> findTop5Titles(String query) {

        return movieRepo.findTop5ByTitleContainingIgnoreCase(query)
                .stream()
                .map(movie -> new DataMovieManipulate(movie.getMovieId(),movie.getTitle()) ).toList();

    }
}
