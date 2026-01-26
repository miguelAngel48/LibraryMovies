package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.DTO.DataMovieManipulate;
import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.services.MoviesEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManipulateController {
@Autowired
    MoviesEdit moviesEdit;
    @GetMapping("/manipulateMovie")
    public String dataMovie(Model model){
        model.addAttribute("movie", new Movie());
        return "manipulateMovie";
    }

    @PostMapping("/movies/save")
    public String saveMovie(@ModelAttribute Movie movie){
        moviesEdit.saveMovie(movie);
        return "redirect:/";
    }
}
