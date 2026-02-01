package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.models.entitys.MovieCrew;
import com.esLiceu.Movie.models.entitys.MovieCrewId;
import com.esLiceu.Movie.repository.MovieCrewRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieCrewService {
    @Autowired
    MovieCrewRepo movieCrewRepo;
    @Autowired
    MoviesStock movieService;

    @Autowired
    PersonEdit personService;

    @Autowired
    DepartmentService departmentService;


    public  void delete(MovieCrewId id) {
        movieCrewRepo.deleteById(id);
    }

    public List<MovieCrew> findByMovieId(Integer movieId) {
        return  movieCrewRepo.findByMovie_MovieId(movieId);
    }

    public void save(MovieCrew crew) {
        movieCrewRepo.save(crew);
    }

    public MovieCrewId getMovieCrew(Integer movieId, Integer personId, Integer departmentId) {
        MovieCrewId crew = new MovieCrewId();
        crew.setMovieId(movieId);
        crew.setPersonId(personId);
        crew.setDepartmentId(departmentId);
        return crew;
    }


    public MovieCrew findCrew(Integer movieId, Integer personId, Integer departmentId, String job) {
        MovieCrew crew = new MovieCrew();
        crew.setMovie(movieService.findMovieById(movieId));
        crew.setPerson(personService.findById(personId));
        crew.setDepartment(departmentService.findById(departmentId));
        crew.setJob(job);
        MovieCrewId id = findCrewId(movieId,personId,departmentId);
        crew.setId(id);
        return crew;
    }

    public MovieCrewId findCrewId(Integer movieId, Integer personId, Integer departmentId) {
        MovieCrewId crew = new MovieCrewId();
        crew.setMovieId(movieId);
        crew.setPersonId(personId);
        crew.setDepartmentId(departmentId);
        return crew;
    }
}
