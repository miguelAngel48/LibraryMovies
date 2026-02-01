package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Country;

import com.esLiceu.Movie.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CountryController {
@Autowired
CountryService countryService;
    @GetMapping("/formCountry")
    public String editCountry(Model model, @RequestParam(required = false) Integer id){
        if (id == null ) {
            model.addAttribute("country", new Country());
        } else {
            Country country = countryService.findById(id) ;
            model.addAttribute("country", country);
        }
        return "formCountry";
    }
    @PostMapping("/country/save")
    public String saveCountry(@ModelAttribute Country person){
        countryService.saveCountry(person);
        return "redirect:/";
    }
    @PostMapping("/country/update")
    public String updateCountry(@ModelAttribute Country country){
        countryService.saveCountry(country);
        return "redirect:/";
    }

    @PostMapping("country/delete")
    public String removeCountry(@RequestParam Integer countryId){
        countryService.deleteCountry(countryId);
        return "redirect:/";
    }
}
