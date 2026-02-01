package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.MovieCrew;
import com.esLiceu.Movie.models.entitys.MovieCrewId;
import com.esLiceu.Movie.services.MovieCrewService;
import com.esLiceu.Movie.services.MoviesStock;
import com.esLiceu.Movie.services.PersonEdit;
import com.esLiceu.Movie.services.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CrewController {

    @Autowired
     MoviesStock movieService;

    @Autowired
     PersonEdit personService;

    @Autowired
     DepartmentService departmentService;

    @Autowired
    MovieCrewService movieCrewService;


    @GetMapping("/formCrew")
    public String formCrew(@RequestParam Integer movieId, Model model) {

        model.addAttribute("movie", movieService.findMovieById(movieId));
        model.addAttribute("persons", personService.findAll());
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("crewList", movieCrewService.findByMovieId(movieId));

        return "formCrew";
    }



    @PostMapping("/crew/save")
    public String saveCrew(
            @RequestParam Integer movieId,
            @RequestParam Integer personId,
            @RequestParam Integer departmentId,
            @RequestParam String job) {

        MovieCrew crew = movieCrewService.findCrew(movieId,personId,departmentId,job);
        movieCrewService.save(crew);

        return "redirect:/formCrew?movieId=" + movieId;
    }

    @PostMapping("/crew/delete")
    public String deleteCrew(
            @RequestParam Integer movieId,
            @RequestParam Integer personId,
            @RequestParam Integer departmentId) {

        MovieCrewId id = movieCrewService.getMovieCrew(movieId,personId,departmentId);
        movieCrewService.delete(id);

        return "redirect:/formCrew?movieId=" + movieId;
    }
}

