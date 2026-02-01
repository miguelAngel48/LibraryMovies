package com.esLiceu.Movie.repository;

import com.esLiceu.Movie.models.DTO.SearchSuggestionDTO;
import com.esLiceu.Movie.models.entitys.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepo extends JpaRepository<Language,Integer> {
    Language findByLanguageId(Integer id);

    List<Language> findTop5ByLanguageNameContainingIgnoreCase(String query);
}
