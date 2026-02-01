package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Gender;
import com.esLiceu.Movie.repository.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {
    @Autowired
    GenderRepo genderRepo;


    public void saveGender(Gender gender) {
        genderRepo.save(gender);
    }

    public void deleteGender(Integer genderId) {
        genderRepo.deleteById(genderId);
    }

    public Gender findById(Integer id) {
        return genderRepo.findByGenderId(id);
    }
}
