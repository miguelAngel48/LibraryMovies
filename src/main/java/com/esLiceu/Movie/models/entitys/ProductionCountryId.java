package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductionCountryId implements Serializable {
    @Column(name = "movie_id")
    private Integer movieId;
    @Column(name = "country_id")
    private Integer countryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductionCountryId)) return false;
        ProductionCountryId that = (ProductionCountryId) o;
        return Objects.equals(movieId, that.movieId)
                && Objects.equals(countryId, that.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId, countryId);
    }
}
