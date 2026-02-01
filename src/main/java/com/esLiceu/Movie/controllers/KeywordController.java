package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.Keyword;
import com.esLiceu.Movie.models.entitys.Person;
import com.esLiceu.Movie.repository.KeywordRepo;
import com.esLiceu.Movie.services.KeywordService;
import com.esLiceu.Movie.services.PersonEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KeywordController {
    @Autowired
    KeywordService keywordService;

    //Keyword
    @GetMapping("/formKeyword")
    public String editKeyword(Model model, @RequestParam(required = false) Integer id) {
        if (id == null ) {
            model.addAttribute("keyword", new Keyword());
        } else {
            Keyword keyword = keywordService.findById(id) ;
            model.addAttribute("keyword", keyword);
        }

        return "formKeyword";
    }

    @PostMapping("/keyword/save")
    public String saveMovie(@ModelAttribute Keyword keyword) {
        keywordService.saveKeyword(keyword);
        return "redirect:/";
    }

    @PostMapping("/keyword/update")
    public String updateKeyword(@ModelAttribute Keyword keyword) {
        keywordService.saveKeyword(keyword);
        return "redirect:/";
    }

    @PostMapping("keyword/delete")
    public String removeKeyword(@RequestParam Integer keywordId) {
        keywordService.deletekeyword(keywordId);
        return "redirect:/";
    }
}
