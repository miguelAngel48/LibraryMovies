package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_company")
public class MovieCompany {

    @EmbeddedId
    MovieCompanyId movieCompanyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("companyId")
    @JoinColumn(name = "company_id")
    private ProductionCompany productionCompany;

    public MovieCompanyId getMovieCompanyId() {
        return movieCompanyId;
    }

    public void setMovieCompanyId(MovieCompanyId movieCompanyId) {
        this.movieCompanyId = movieCompanyId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ProductionCompany getProductionCompany() {
        return productionCompany;
    }

    public void setProductionCompany(ProductionCompany productionCompany) {
        this.productionCompany = productionCompany;
    }
}
