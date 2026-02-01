package com.esLiceu.Movie.models.DTO;

import com.esLiceu.Movie.models.entitys.MovieCast;
import com.esLiceu.Movie.models.entitys.MovieCrew;

import java.time.LocalDate;
import java.util.List;

public record CRUDMovies(Integer movieId,
                         String title,
                         String overview,
                         LocalDate releaseDate,
                         Integer runtime,
                         String movieStatus,
                         Integer budget,
                         Long revenue,
                         List<MovieCast> cast,
                         List<MovieCrew> crew
) {
}
