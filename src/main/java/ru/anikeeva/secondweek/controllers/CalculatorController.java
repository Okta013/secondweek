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

    @PostMapping("/calculator")
    public String calculate(@RequestParam("numberOne") double numberOne,
                            @RequestParam("numberTwo") double numberTwo,
                            @RequestParam("action") String action, Model model){

        double result;

        Calc calc = new Calc();
        calc.setNumberOne(numberOne);
        calc.setNumberTwo(numberTwo);
        calc.setAction(action);

        switch(action){
            case "multiplication":
                result = numberOne * numberTwo;
                break;
            case "division":
                result = numberOne / numberTwo;
                break;
            case "subtraction":
                result = numberOne - numberTwo;
                break;
            case "addition":
                result = numberOne + numberTwo;
                break;
            default:
                result = 0;
        }

        model.addAttribute("result", result);

        return "calculator";
    }
}
