package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer LanguageId;
    String languageCode;
    String languageName;

    public Integer getLanguageId() {
        return LanguageId;
    }

    public void setLanguageId(Integer languageId) {
        LanguageId = languageId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
