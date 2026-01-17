package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Movie;
import com.esLiceu.Movie.repository.MovieRepo;
import com.esLiceu.Movie.services.MoviesStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MovieController {
    @Autowired
    MoviesStock moviesStock;



    @GetMapping("/")
    public String menu(Model model){
        List<Movie> movies = moviesStock.findAllMovies();
        model.addAttribute("movies",movies);
        return "menu";
    }
    @PostMapping("/menu")
    public String menuSearch(Model model, @RequestParam String search) {

        String normalized = search.trim();

        Movie movie = moviesStock.findByTitle(normalized);
        List<Movie> movies = moviesStock.findAllMovies();
        model.addAttribute("movies",movies);
        if (movie == null) {
            model.addAttribute("error", "Película no encontrada");
            model.addAttribute("movies", moviesStock.findAllMovies());
            return "menu";
        }

        model.addAttribute("movie", movie);
        return "movie";
    }

    @GetMapping("/api/autocomplete")
    @ResponseBody
    public List<String> autocomplete(@RequestParam String query){
        return moviesStock.findTop5Titles(query);
    }

}
