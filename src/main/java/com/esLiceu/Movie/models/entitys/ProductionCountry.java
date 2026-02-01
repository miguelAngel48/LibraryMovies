package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "production_country")
public class ProductionCountry {

    @EmbeddedId
    private ProductionCountryId id;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;
}

