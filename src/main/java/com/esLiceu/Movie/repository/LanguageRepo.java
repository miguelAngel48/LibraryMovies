package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.entitys.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepo extends JpaRepository<Language,Integer> {
}
