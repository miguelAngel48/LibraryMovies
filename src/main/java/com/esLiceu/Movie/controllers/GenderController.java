package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Gender;
import com.esLiceu.Movie.services.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GenderController {

    @Autowired
    GenderService genderService;

    // FORM (create + edit)
    @GetMapping("/formGender")
    public String editGender(Model model,@RequestParam(required = false) Integer id) {


        if (id == null) {
            model.addAttribute("gender", new Gender());
        } else {
            Gender gender = genderService.findById(id);
            model.addAttribute("gender", gender);
        }

        return "formGender";
    }

    // CREATE / UPDATE (save sirve para ambos)
    @PostMapping("/gender/save")
    public String saveGender(@ModelAttribute Gender gender) {
        genderService.saveGender(gender);
        return "redirect:/";
    }

    // DELETE
    @PostMapping("/gender/delete")
    public String removeGender(@RequestParam Integer genderId) {
        genderService.deleteGender(genderId);
        return "redirect:/";
    }
}
