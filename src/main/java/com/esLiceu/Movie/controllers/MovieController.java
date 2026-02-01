package com.esLiceu.Movie.controllers;


import com.esLiceu.Movie.models.DTO.SearchSuggestionDTO;
import com.esLiceu.Movie.models.entitys.Movie;

import com.esLiceu.Movie.services.MoviesStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


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
        if(movieId == null){
            model.addAttribute("error", "Nothing here, try something else");
            model.addAttribute("moviesList", List.of());
            return "menu";
        }
        List<Movie> movies = moviesStock.globalFinder(search,movieId,type);
        model.addAttribute("moviesList",movies);
        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/api/autocomplete")
    @ResponseBody
    public List<SearchSuggestionDTO> autocomplete(@RequestParam String query, @RequestParam MoviesStock.SearchType type){
        return moviesStock.findTop5Suggestions(query,type);
    }

}
