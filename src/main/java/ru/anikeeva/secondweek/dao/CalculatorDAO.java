package ru.anikeeva.secondweek.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CalculatorDAO {
    private List<Double> history = new ArrayList<>();

    public List<Double> index(){return history;}

    public void add(double calc){
        history.add(calc.getResult());
    }


}
