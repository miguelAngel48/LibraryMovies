package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface GenderRepo extends JpaRepository<Gender,Integer> {

    Gender findByGenderId(Integer id);

    List<Gender> findTop5ByGenderContainingIgnoreCase(String query);
}
