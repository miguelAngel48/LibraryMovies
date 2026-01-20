package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MovieLanguageId implements Serializable {

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "language_role_id")
    private Integer languageRoleId;

    public MovieLanguageId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieLanguageId)) return false;
        MovieLanguageId that = (MovieLanguageId) o;
        return movieId.equals(that.movieId)
                && languageId.equals(that.languageId)
                && languageRoleId.equals(that.languageRoleId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movieId, languageId, languageRoleId);
    }
}

