package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieKeywordId implements Serializable {
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "keyword_id")
    private Integer keywordId;

    // OBLIGATORIO
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieKeywordId)) return false;
        MovieKeywordId that = (MovieKeywordId) o;
        return Objects.equals(movieId, that.movieId)
                && Objects.equals(keywordId, that.keywordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, keywordId);
    }
}