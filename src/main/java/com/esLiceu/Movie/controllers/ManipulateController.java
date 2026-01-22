package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.DTO.DataMovieManipulate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManipulateController {

    @GetMapping("/manipulateMovie")
    public static String dataMovie(@RequestParam DataMovieManipulate movieData){

        return "manipulateMovie";
    }
}
