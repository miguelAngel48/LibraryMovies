package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Country;
import com.esLiceu.Movie.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    CountryRepo countryRepo;

    public Country findById(Integer id) {
        return countryRepo.findByCountryId(id);
    }

    public void saveCountry(Country country) {
        countryRepo.save(country);
    }

    public void deleteCountry(Integer countryId) {
        countryRepo.deleteById(countryId);
    }
}
