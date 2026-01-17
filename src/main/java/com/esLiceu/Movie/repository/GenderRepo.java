package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends JpaRepository<Gender,Integer> {

}
