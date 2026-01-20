package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "movie_languages")
public class MovieLanguage {

    @EmbeddedId
    private MovieLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageRoleId")
    @JoinColumn(name = "language_role_id")
    private LanguageRole role;
}

