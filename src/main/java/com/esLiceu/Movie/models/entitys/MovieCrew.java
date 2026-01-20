package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "movie_crew")
public class MovieCrew {

    @EmbeddedId
    private MovieCrewId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(nullable = false)
    private String job;
}

