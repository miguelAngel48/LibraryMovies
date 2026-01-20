package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_cast")
public class MovieCast {

    @EmbeddedId
    private MovieCastId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Column(name = "character_name")
    private String characterName;

    @Column(name = "cast_order")
    private Integer castOrder;
}
