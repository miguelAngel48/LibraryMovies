package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Keyword;
import com.esLiceu.Movie.models.entitys.Person;
import com.esLiceu.Movie.services.PersonEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {
    @Autowired
    PersonEdit personEdit;
    //person
    @GetMapping("/formPerson")
    public String editPerson(Model model, @RequestParam(required = false) Integer id){
        if (id == null ) {
            model.addAttribute("person", new Person());
        } else {
            Person person = personEdit.findById(id) ;
            model.addAttribute("person", person);
        }
        return "formPerson";
    }
    @PostMapping("/persons/save")
    public String saveMovie(@ModelAttribute Person person){
        personEdit.savePerson(person);
        return "redirect:/";
    }
    @PostMapping("/persons/update")
    public String updatePerson(@ModelAttribute Person person){
        personEdit.savePerson(person);
        return "redirect:/";
    }

    @PostMapping("persons/delete")
    public String removePerson(@RequestParam Integer personId){
        personEdit.deletePerson(personId);
        return "redirect:/";
    }
}
