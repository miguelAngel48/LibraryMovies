package com.esLiceu.Movie.controllers;

import com.esLiceu.Movie.models.entitys.User;
import com.esLiceu.Movie.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    HttpSession session;



    @PostMapping("/register")
    public String register(
            Model model,
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String passwordCheck) {

        if (userService.register(email, username, password, passwordCheck)) {
            return "redirect:/";
        }

        model.addAttribute("error", "Invalid register data");
       return "redirect:/";
    }



    @PostMapping("/login")
    public String login(
            Model model,
            @RequestParam String username,
            @RequestParam String password) {

        if (userService.login(username, password)) {

            User u = userService.getByUsername(username);

            session.setAttribute("user", u.getUsername());
            session.setAttribute("userId", u.getUserId());

        }

        model.addAttribute("error", "Wrong credentials");
        return "redirect:/";
    }



    @GetMapping("/logout")
    public String logout() {
        session.invalidate();
        return "redirect:/";
    }
}

