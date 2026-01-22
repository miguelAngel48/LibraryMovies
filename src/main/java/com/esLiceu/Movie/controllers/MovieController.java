package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.DTO.DataMovieManipulate;
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
    public String menuSearch(Model model, @RequestParam String search,@RequestParam(required = false) Integer movieId, @RequestParam MoviesStock.SearchType type) {

        System.out.println("movieId = " + movieId);
        System.out.println("search = " + search);
        List<Movie> movies = moviesStock.globalFinder(search,movieId,type);
        model.addAttribute("moviesList",movies);
        if (movies.isEmpty()) {
            model.addAttribute("error", "Película no encontrada");
//            model.addAttribute("moviesList", movies);
            return "menu";
        }

        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/api/autocomplete")
    @ResponseBody
    public List<DataMovieManipulate> autocomplete(@RequestParam String query){
        return moviesStock.findTop5Titles(query);
    }

}
