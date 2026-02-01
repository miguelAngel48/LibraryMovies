package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.MovieCast;
import com.esLiceu.Movie.models.entitys.MovieCastId;
import com.esLiceu.Movie.services.MovieCastService;
import com.esLiceu.Movie.services.MoviesStock;
import com.esLiceu.Movie.services.PersonEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CastController {

    @Autowired
    MoviesStock movieService;
    @Autowired
    PersonEdit personService;
    @Autowired
    MovieCastService castService;

    @GetMapping("/formCast")
    public String formCast(@RequestParam Integer movieId, Model model) {

        model.addAttribute("movie", movieService.findMovieById(movieId));
        model.addAttribute("persons", personService.findAll());
        model.addAttribute("castList", castService.findByMovieId(movieId));

        return "formCast";
    }

    @PostMapping("/cast/save")
    public String saveCast(
            @RequestParam Integer movieId,
            @RequestParam Integer personId,
            @RequestParam String characterName,
            @RequestParam Integer castOrder) {

        MovieCast cast = new MovieCast();
        MovieCastId id = new MovieCastId();
        id.setMovieId(movieId);
        id.setPersonId(personId);
        cast.setId(id);

        cast.setMovie(movieService.findMovieById(movieId));
        cast.setPerson(personService.findById(personId));

        cast.setCharacterName(characterName);
        cast.setCastOrder(castOrder);

        castService.save(cast);

        return "redirect:/formCast?movieId=" + movieId;
    }


    @PostMapping("/cast/delete")
    public String deleteCast(
            @RequestParam Integer movieId,
            @RequestParam Integer personId) {

        MovieCastId id = new MovieCastId();
        id.setMovieId(movieId);
        id.setPersonId(personId);

        castService.delete(id);

        return "redirect:/formCast?movieId=" + movieId;
    }

}

