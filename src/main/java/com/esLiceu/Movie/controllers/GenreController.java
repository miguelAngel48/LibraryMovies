package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Genre;
import com.esLiceu.Movie.services.GenreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenreController {

    @Autowired
    GenreService genreService;

    // FORM (create + edit)
    @GetMapping("/formGenre")
    public String editGenre(Model model, @RequestParam(required = false) Integer id) {

        if (id == null) {
            model.addAttribute("genre", new Genre());
        } else {
            Genre genre = genreService.findById(id);
            model.addAttribute("genre", genre);
        }

        return "formGenre";
    }


    @PostMapping("/genre/save")
    public String saveGenre(@ModelAttribute Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/";
    }


    @PostMapping("/genre/update")
    public String updateGenre(@ModelAttribute Genre genre) {
        genreService.saveGenre(genre);
        return "redirect:/";
    }

    // DELETE
    @PostMapping("/genre/delete")
    public String removeGenre(@RequestParam Integer genreId) {
        genreService.deleteGenre(genreId);
        return "redirect:/";
    }
}
