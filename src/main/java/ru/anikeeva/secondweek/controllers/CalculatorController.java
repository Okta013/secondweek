package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.models.Calculator;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    List<Calculator> history = new ArrayList<>();

    @GetMapping
    public String showCalculator(Model model){
        model.addAttribute("operation", new Calculator());
        model.addAttribute("history", history);
        return "calculator/Calculator";
    }

    @PostMapping
    public String calculate(@ModelAttribute Calculator operation, Model model){
        switch (operation.getAction()) {
            case "addition":
                operation.setResult(operation.getNumberOne() + operation.getNumberTwo());
                break;
            case "subtraction":
                operation.setResult(operation.getNumberOne() - operation.getNumberTwo());
                break;
            case "multiplication":
                operation.setResult(operation.getNumberOne() * operation.getNumberTwo());
                break;
            case "division":
                operation.setResult(operation.getNumberOne() / operation.getNumberTwo());
                break;
        }

        history.add(operation);

        model.addAttribute("operation", operation);
        model.addAttribute("history", history);
        return "calculator/Calculator";
    }
}