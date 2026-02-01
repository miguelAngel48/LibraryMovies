package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.repository.LanguageRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Controller
public class LanguageRoleController {
    @Autowired
    LanguageRoleRepo languageRoleRepo;
}
