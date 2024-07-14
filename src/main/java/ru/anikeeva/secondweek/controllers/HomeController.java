package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(@RequestParam(value = "name", required = false) String name, Model model) {
        if (name == null) {
            name = "";
        }
        model.addAttribute("name", name);
        return "home";
    }
}