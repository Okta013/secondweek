package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.models.Calc;

@Controller
@RequestMapping("/")
public class CalculatorController {

    @GetMapping("/calculator")
    public String showCalculator(Model model) {
        model.addAttribute("calc", new Calc());
        return "calculator";
    }

    @PostMapping()
    public String calculate(@ModelAttribute Calc form){
        double result;

        switch (form.getAction()) {
            case "multiplication":
                result = form.getNumberOne() * form.getNumberTwo();
                break;
            case "division":
                result = form.getNumberOne() / form.getNumberTwo();
                break;
            case "subtraction":
                result = form.getNumberOne() - form.getNumberTwo();
                break;
            case "addition":
                result = form.getNumberOne() + form.getNumberTwo();
                break;
            default:
                result = 0.0;
                break;
        }

        form.setResult(result);
        return "calculator";
    }
}
