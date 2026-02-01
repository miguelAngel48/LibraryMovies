package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Language;
import com.esLiceu.Movie.services.LanguageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LanguageController {

    @Autowired
    LanguageService languageService;

    // FORM (create + edit)
    @GetMapping("/formLanguage")
    public String editLanguage(Model model, @RequestParam(required = false) Integer id) {
        if (id == null) {
            model.addAttribute("language", new Language());
        } else {
            Language language = languageService.findById(id);
            model.addAttribute("language", language);
        }

        return "formLanguage";
    }


    @PostMapping("/language/save")
    public String saveLanguage(@ModelAttribute Language language) {
        languageService.saveLanguage(language);
        return "redirect:/";
    }


    @PostMapping("/language/delete")
    public String removeLanguage(@RequestParam Integer languageId) {
        languageService.deleteLanguage(languageId);
        return "redirect:/";
    }
}
