package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import java.io.Serializable;

@Embeddable
public class MovieCrewId implements Serializable {
    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "department_id")
    private Integer departmentId;


    public MovieCrewId() {}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieCrewId)) return false;
        MovieCrewId that = (MovieCrewId) o;
        return movieId.equals(that.movieId)
                && personId.equals(that.personId)
                && departmentId.equals(that.departmentId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(movieId, personId, departmentId);
    }
}

