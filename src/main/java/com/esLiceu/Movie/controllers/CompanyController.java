package com.esLiceu.Movie.controllers;


import com.esLiceu.Movie.models.entitys.ProductionCompany;
import com.esLiceu.Movie.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    // FORM (create + edit)
    @GetMapping("/formProductionCompany")
    public String editCompany(Model model,
                              @RequestParam(required = false) Integer id) {

        if (id == null) {
            model.addAttribute("company", new ProductionCompany());
        } else {
            ProductionCompany company = companyService.findById(id);
            model.addAttribute("company", company);
        }

        return "formProductionCompany";
    }

    // CREATE / UPDATE (save sirve para ambos)
    @PostMapping("/company/save")
    public String saveCompany(@ModelAttribute ProductionCompany company) {
        companyService.saveCompany(company);
        return "redirect:/";
    }

    // DELETE
    @PostMapping("/company/delete")
    public String removeCompany(@RequestParam Integer companyId) {
        companyService.deleteCompany(companyId);
        return "redirect:/";
    }
}
