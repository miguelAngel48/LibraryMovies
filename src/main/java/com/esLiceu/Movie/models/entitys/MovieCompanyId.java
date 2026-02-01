package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieCompanyId implements Serializable {

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "company_id")
    private Integer companyId;

    public MovieCompanyId() {}

    @Override
    public int hashCode() {
        return Objects.hash(movieId,companyId);
    }

    @Override
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       MovieCompanyId that = (MovieCompanyId) obj;
       return Objects.equals(movieId, that.movieId) && Objects.equals(companyId,that.companyId);
    }
}
