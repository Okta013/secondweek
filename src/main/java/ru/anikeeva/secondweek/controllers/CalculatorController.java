package ru.anikeeva.secondweek.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.anikeeva.secondweek.dao.CalculatorDAO;
import ru.anikeeva.secondweek.models.Calc;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorDAO calculatorDAO;

    public CalculatorController(CalculatorDAO calculatorDAO) {
        this.calculatorDAO = calculatorDAO;
    }

    @GetMapping
    public String showCalculator(Model model) {
        model.addAttribute("calc", calculatorDAO.index());
        return "calculator";
    }

    @PostMapping()
    public String calculate(@RequestParam("numberOne") double numberOne,
                            @RequestParam("numberTwo") double numberTwo,
                            @RequestParam("action") String action, Model model){
        double result;

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

        calculatorDAO.add(result);

        return "calculator";
    }
}
