package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Keyword;
import com.esLiceu.Movie.models.entitys.Person;
import com.esLiceu.Movie.repository.PersonRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonEdit {
    @Autowired
    PersonRepo personRepo;
    public void savePerson(Person person) {
        personRepo.save(person);
    }


    public void deletePerson(Integer personId) {
        personRepo.deleteById(personId);
    }

    public Person findById(Integer id) {
        return personRepo.findByPersonId(id);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }
}
