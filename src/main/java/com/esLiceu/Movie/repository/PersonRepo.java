package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Person;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<Person,Integer> {

    List<Person> findTop5ByPersonNameContainingIgnoreCase(String query);

    List<Person> findTop5DirectorsByPersonNameContainingIgnoreCase(String query, String director);

    Person findByPersonId(Integer id);
}
