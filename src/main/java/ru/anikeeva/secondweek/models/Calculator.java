package ru.anikeeva.secondweek.models;

public class Calculator {
    private double numberOne;
    private double numberTwo;
    private String action;
    private double result;

    public Calculator(double numberOne, double numberTwo, String action) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.action = action;
    }

    public Calculator(){}

    public double getNumberOne() {
        return numberOne;
    }

    public void setNumberOne(double numberOne) {
        this.numberOne = numberOne;
    }

    public double getNumberTwo() {
        return numberTwo;
    }

    public void setNumberTwo(double numberTwo) {
        this.numberTwo = numberTwo;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return numberOne + " " + action + " " + numberTwo + " = " + result;
    }

}
