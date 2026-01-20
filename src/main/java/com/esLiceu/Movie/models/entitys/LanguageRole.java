package com.esLiceu.Movie.models.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "language_role")
public class LanguageRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer roleId;

     String languageRole;
}
