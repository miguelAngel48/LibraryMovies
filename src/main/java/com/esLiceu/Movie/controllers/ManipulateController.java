package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.DTO.CRUDMovies;
import com.esLiceu.Movie.models.DTO.DataMovieManipulate;
import com.esLiceu.Movie.models.entitys.*;
import com.esLiceu.Movie.services.MoviesEdit;
import com.esLiceu.Movie.services.MoviesStock;
import com.esLiceu.Movie.services.PersonEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ManipulateController {
    @Autowired
    MoviesEdit moviesEdit;
    @Autowired
    PersonEdit personEdit;

    @GetMapping("/manipulateMovie")
    public String dataMovie() {

        return "manipulateMovie";
    }

    //movie
    @GetMapping("/formMovie")
    public String editMovie(Model model, @RequestParam(required = false) Integer id) {
        Movie movie;
        if (id != null) {
            movie = moviesEdit.findByIdMovie(id);
        } else {
            movie = new Movie();
        }
        model.addAttribute("movie", movie);
        return "formMovie";
    }


    @PostMapping("/movies/save")
    public String saveMovie(@ModelAttribute Movie movie) {

        moviesEdit.saveMovie(movie);

        return "redirect:/";
    }

    @PostMapping("movies/delete")
    public String removeMovie(@RequestParam Integer movieId) {
        moviesEdit.deleteMovie(movieId);
        return "redirect:/";
    }

}
