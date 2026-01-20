package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;

import java.io.Serializable;

@Embeddable
public class MovieCastId implements Serializable {
    @Column(name = "movie_id")
    Integer movieId;

    @Column(name = "person_id")
    Integer personId;


    public MovieCastId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieCastId)) return false;
        MovieCastId that = (MovieCastId) o;
        return movieId.equals(that.movieId)
                && personId.equals(that.personId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movieId, personId);
    }
}
