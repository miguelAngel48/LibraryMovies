package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
@Embeddable
public class MovieGenreId implements Serializable {

    @Column(name = "genre_id")
    private Integer genreId;

    @Column(name = "movie_id")
    private Integer movieId;

    public MovieGenreId() {}


    @Override
    public int hashCode() {
        return java.util.Objects.hash(movieId,genreId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieGenreId)) return false;
        MovieGenreId that = (MovieGenreId) o;
        return movieId.equals(that.movieId)
                && genreId.equals(that.genreId);

    }
}
