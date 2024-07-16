package ru.anikeeva.secondweek.dao;

import org.springframework.stereotype.Component;
import ru.anikeeva.secondweek.models.Calculator;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDAO {
    private List<String> history = new ArrayList<String>();

    public List<String> index() {
        return history;
    }

    public void add(Calculator calculator){
        switch(calculator.getAction()){
            case "addition":
                calculator.setResult(calculator.getNumberOne() + calculator.getNumberTwo());
                break;
            case "subtraction":
                calculator.setResult(calculator.getNumberOne() - calculator.getNumberTwo());
                break;
            case "multiplication":
                calculator.setResult(calculator.getNumberOne() * calculator.getNumberTwo());
                break;
            case "division":
                calculator.setResult(calculator.getNumberOne() /  calculator.getNumberTwo());
                break;
            default:
                calculator.setResult(0);
        }
        history.add(calculator.toString());
    }
}
