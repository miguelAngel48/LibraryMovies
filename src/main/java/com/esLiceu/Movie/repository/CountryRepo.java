package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {

}
