package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_keywords")
public class MovieKeyword {
    @EmbeddedId
    private MovieKeywordId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("keywordId")
    @JoinColumn(name = "keyword_id")
    private Keyword keyword;
}
