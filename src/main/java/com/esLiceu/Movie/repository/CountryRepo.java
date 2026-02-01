package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.DTO.SearchSuggestionDTO;
import com.esLiceu.Movie.models.entitys.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepo extends JpaRepository<Country,Integer> {

    Country findByCountryId(Integer id);

    List<Country> findTop5ByCountryNameContainingIgnoreCase(String query);
}
