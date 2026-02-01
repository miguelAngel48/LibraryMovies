package com.esLiceu.Movie.services;

import com.esLiceu.Movie.models.entitys.Language;
import com.esLiceu.Movie.repository.LanguageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageService {
    @Autowired
    LanguageRepo languageRepo;

    public Language findById(Integer id) {
        return languageRepo.findByLanguageId(id);
    }

    public void saveLanguage(Language language) {
        languageRepo.save(language);
    }

    public void deleteLanguage(Integer languageId) {
        languageRepo.deleteById(languageId);
    }
}
