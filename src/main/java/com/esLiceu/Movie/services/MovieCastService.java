package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.models.entitys.MovieCast;
import com.esLiceu.Movie.models.entitys.MovieCastId;
import com.esLiceu.Movie.repository.MovieCastRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieCastService {
    @Autowired
    MovieCastRepo movieCastRepo;
    @Autowired
    MoviesStock movieService;
    @Autowired
    PersonEdit personService;

    public List<MovieCast> findByMovieId(Integer movieId) {
        return movieCastRepo.findByMovie_MovieId(movieId);
    }

    public void save(MovieCast cast) {
        Integer movieId = cast.getId().getMovieId();
        Optional<MovieCast> last =
                movieCastRepo.findTopByMovie_MovieIdOrderByCastOrderDesc(movieId);
        int nextOrder = last.map(c -> c.getCastOrder() + 1).orElse(1);
        cast.setCastOrder(nextOrder);
        movieCastRepo.save(cast);
    }

    public void delete(MovieCastId castId) {
        movieCastRepo.deleteById(castId);
    }


    public MovieCast getCast(Integer movieId, Integer personId, String characterName) {
        MovieCast cast = new MovieCast();
        MovieCastId id = getCastId(movieId, personId);
        cast.setMovie(movieService.findMovieById(movieId));
        cast.setPerson(personService.findById(personId));
        cast.setCharacterName(characterName);

        cast.setId(id);
        return cast;
    }

    public MovieCastId getCastId(Integer movieId, Integer personId) {
        MovieCastId id = new MovieCastId();
        id.setMovieId(movieId);
        id.setPersonId(personId);
        return id;
    }
}
